package com.atendimentomedico.crudmedico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class CrudMedicoApplication {

    private static Logger logger = LoggerFactory.getLogger(CrudMedicoApplication.class);

    public static void main(String[] args) {
        logger.info("Iniciando a API");
        SpringApplication.run(CrudMedicoApplication.class, args);
        logger.info("API iniciada com sucesso");
    }

}
