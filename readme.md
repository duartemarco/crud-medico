# Crud Médico - Spring Boot

Este projeto é uma API REST com operações CRUD que utiliza Spring Boot como backend e banco H2 para persistência (local) de dados.

A aplicação permite a gestão de informações relacionadas a pacientes, médicos e consultas.

## Overview

### Layout


### Endpoints

#### HTML
| Método HTTP | URL                            | Descrição      |
|-------------|--------------------------------|----------------|
| `GET`       | http://localhost:8000/         | Página inicial |

#### Paciente Service

| Método HTTP | URL                                        | Descrição                |
|-------------|--------------------------------------------|--------------------------|
| `GET`       | http://localhost:8000/paciente/all         | Lista todos os pacientes |
| `GET`       | http://localhost:8000/paciente/{id}        | Obtém paciente por ID    |
| `GET`       | http://localhost:8000/paciente?nome={nome} | Obtém paciente por nome  |
| `POST`      | http://localhost:8000/paciente/add         | Cadastra um paciente     |
| `PUT`       | http://localhost:8000/paciente/update/{id} | Atualiza paciente por ID |
| `DELETE`    | http://localhost:8000/paciente/delete/{id} | Deleta paciente por ID   |