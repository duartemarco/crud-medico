# Crud Médico - Spring Boot

Este projeto é uma API REST com operações CRUD que utiliza Spring Boot como backend e banco H2 para persistência (local)
de dados.

A aplicação permite a gestão de informações relacionadas a pacientes, médicos e consultas.

## Overview

## To Do

- [ ] Implementar logging (LoggerFactory)
- [ ] Adicionar validações de entrada (@NotNull, etc)
- [ ] Implementar autenticação nos endpoints (Spring Security)
- [ ] Incluir tratamento de exceções e retorno de códigos de status (@ExceptionHandler)
- [ ] Implementar testes unitários (JUnit)

### Endpoints

#### HTML

| Método HTTP | URL                    | Descrição      |
|-------------|------------------------|----------------|
| `GET`       | http://localhost:8000/ | Página inicial |

#### Paciente Service

| Método HTTP | URL                                        | Descrição                |
|-------------|--------------------------------------------|--------------------------|
| `GET`       | http://localhost:8000/paciente/all         | Lista todos os pacientes |
| `GET`       | http://localhost:8000/paciente/{id}        | Obtém paciente por ID    |
| `GET`       | http://localhost:8000/paciente?nome={nome} | Obtém paciente por nome  |
| `POST`      | http://localhost:8000/paciente/add         | Cadastra um paciente     |
| `PUT`       | http://localhost:8000/paciente/update/{id} | Atualiza paciente por ID |
| `DELETE`    | http://localhost:8000/paciente/delete/{id} | Deleta paciente por ID   |

#### Médico Service

| Método HTTP | URL                                       | Descrição                |
|-------------|-------------------------------------------|--------------------------|
| `GET`       | http://localhost:8000/medico/all          | Lista todos os médicos   |
| `GET`       | http://localhost:8000/medico/{id}         | Obtém médico por ID      |
| `GET`       | http://localhost:8000/medico?nome={nome}  | Obtém médico por nome    |
| `POST`      | http://localhost:8000/medico/add          | Cadastra um médico       |
| `PUT`       | http://localhost:8000/medico/update/{id}  | Atualiza médico por ID   |
| `DELETE`    | http://localhost:8000/medico/delete/{id}  | Deleta médico por ID     |

