# Crud Médico - Spring Boot

Este projeto é uma API REST com operações CRUD que utiliza Spring Boot como backend e banco H2 para persistência (local)
de dados.

A aplicação permite a gestão de informações relacionadas a Pacientes, Médicos e Consultas, 
possibilitando adicionar, ler, atualizar e deletar tais entidades.

## Overview

## To Do

- [ ] Implementar logging (LoggerFactory)
- [ ] Adicionar validações de entrada (@NotNull, etc)
- [ ] Implementar autenticação nos endpoints (Spring Security)
- [ ] Incluir tratamento de exceções e retorno de códigos de status (@ExceptionHandler)
- [ ] Implementar testes unitários (JUnit)

## Endpoints

### HTML

| Método HTTP | URL                    | Descrição      |
|-------------|------------------------|----------------|
| `GET`       | http://localhost:8000/ | Página inicial |

### Paciente

| Método   | URL                                        | Descrição                |
|----------|--------------------------------------------|--------------------------|
| `GET`    | http://localhost:8000/paciente/all         | Lista todos os Pacientes |
| `GET`    | http://localhost:8000/paciente/{id}        | Obtém Paciente por ID    |
| `GET`    | http://localhost:8000/paciente?nome={nome} | Obtém Paciente por nome  |
| `POST`   | http://localhost:8000/paciente/add         | Cadastra um Paciente     |
| `PUT`    | http://localhost:8000/paciente/update/{id} | Atualiza Paciente por ID |
| `DELETE` | http://localhost:8000/paciente/delete/{id} | Deleta Paciente por ID   |

### Médico

| Método   | URL                                       | Descrição              |
|----------|-------------------------------------------|------------------------|
| `GET`    | http://localhost:8000/medico/all          | Lista todos os Médicos |
| `GET`    | http://localhost:8000/medico/{id}         | Obtém Médico por ID    |
| `GET`    | http://localhost:8000/medico?nome={nome}  | Obtém Médico por nome  |
| `POST`   | http://localhost:8000/medico/add          | Cadastra um Médico     |
| `PUT`    | http://localhost:8000/medico/update/{id}  | Atualiza Médico por ID |
| `DELETE` | http://localhost:8000/medico/delete/{id}  | Deleta Médico por ID   |

### Consulta

| Método   | URL                                           | Descrição                  |
|----------|-----------------------------------------------|----------------------------|
| `GET`    | http://localhost:8000/consulta/all            | Lista todas as Consultas   |
| `GET`    | http://localhost:8000/consulta/{id}           | Obtém Consulta por ID      |
| `POST`   | http://localhost:8000/consulta/add            | Adiciona uma nova Consulta |
| `PUT`    | http://localhost:8000/consulta/update/{id}    | Atualiza Consulta por ID   |
| `DELETE` | http://localhost:8000/consulta/delete/{id}    | Deleta Consulta por ID     |

Você pode utilizar o Postman (ou outro cliente rest) para testar os endpoints.