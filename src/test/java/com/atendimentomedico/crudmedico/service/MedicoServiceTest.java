package com.atendimentomedico.crudmedico.service;

import com.atendimentomedico.crudmedico.entity.Medico;
import com.atendimentomedico.crudmedico.exception.MedicoNotFoundException;
import com.atendimentomedico.crudmedico.repository.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicoServiceTest {

    @Mock
    private MedicoRepository repository;

    @InjectMocks
    private MedicoService service;

    private Medico testMedico;

    @BeforeEach
    void setUp() {
        testMedico = new Medico(1L, "Marco Túlio", "12345", "Anestesiologia");
    }

    @Test
    void testCadastraMedico() {
        when(repository.save(any(Medico.class))).thenReturn(testMedico);

        Medico savedMedico = service.cadastraMedico(testMedico);

        assertNotNull(savedMedico);
        assertEquals(testMedico.getId(), savedMedico.getId());
        assertEquals(testMedico.getNome(), savedMedico.getNome());
        assertEquals(testMedico.getCrm(), savedMedico.getCrm());
        assertEquals(testMedico.getEspecialidade(), savedMedico.getEspecialidade());

        verify(repository, times(1)).save(any(Medico.class));
    }

    @Test
    void testGetAllMedicos() {
        when(repository.findAll()).thenReturn(Collections.singletonList(testMedico));

        List<Medico> medicos = service.getAllMedicos();

        assertEquals(1, medicos.size());
        assertEquals(testMedico, medicos.get(0));

        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetMedicoById() {
        when(repository.findById(1L)).thenReturn(Optional.of(testMedico));

        Medico medico = service.getMedicoById(1L);

        assertNotNull(medico);
        assertEquals(testMedico, medico);

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetMedicoById_NotFound() {
        when(repository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(MedicoNotFoundException.class, () -> service.getMedicoById(2L));

        verify(repository, times(1)).findById(2L);
    }

}