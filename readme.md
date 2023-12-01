# Crud Médico - Spring Boot

Este projeto é uma API com operações CRUD que utiliza Spring Boot como backend e banco H2 para persistência de dados.

A aplicação permite a gestão de informações relacionadas a pacientes, médicos e consultas.

## Overview

### Layout


### Endpoints

#### HTML
| Método HTTP | URL                            | Descrição      |
|-------------|--------------------------------|----------------|
| `GET`       | http://localhost:8000/         | Página inicial |

#### User Service

| Método HTTP | URL                                                | Descrição                |
|-------------|----------------------------------------------------|--------------------------|
| `GET`       | http://localhost:8000/paciente/todos               | Lista todos os pacientes |
| `POST`      | http://localhost:8000/paciente/cadastrar           | Cadastra um paciente     |
| `DELETE`    | http://localhost:8000/paciente/deleta/{pacienteId} | Deleta paciente pelo ID  |