# clinicaSpringBoot

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/juliocesarmj/clinicaSpringBoot/blob/master/LICENCE) 

# Sobre o projeto

Clínica Meriti é um projeto de minha autoria, onde a ideia é fornecer um sistema de gerenciamento de dados de uma clinica médica fictícia.
Com esse sistema um paciente pode solicitar o agendamento de uma consulta médica de acordo com a sua necessidade.

Simulando um atendimento real, o paciente informa seu cpf para que o atendente possa verificar se esse paciente já possui registro no sistema.
Caso sim, o paciente informa a especialidade que deseja receber atendimento. O atendente apresenta os médicos disponíveis para esse paciente e é registrado uma nova consulta.
Caso o cpf nao exista no sistema, é solicitado alguns dados para cadastro e posteriomente é feito o agendamento da consulta.

É possível cadastrar funcionários com niveis de acesso.

### Atendente - Esse perfil é possível cadastrar novos pacientes no sistema, pesquisar consultas de um determinado paciente, pesquisar consultas agendadas para um determinado médico.
### Médico - Pode informar indisponibilidade em sua agenda do dia, com isso, todos os pacientes agendados para esse dia, terão suas consultas modificadas para o status de cancelada, precisando ser reagendadas pelos atendentes. O medico poderá informar observaçoes em suas consultas durante o atendimento de um paciente X. Informações como remédios receitados, exames solicitados e etc. Ao fim de uma consulta, o mesmo poderá finalizar a consulta e a mesma terá o status de finalizada.
## Administrador - Permissão para criar/consultar/editar/remover cadastros de médicos e atendentes. Poderá realizar qualquer operação em relaçao a uma consulta, como criar/editar/consultar/excluir.

## Features que serão implementadas

- Endpoint da agenda do diária do médico(get com todos as consultas agendadas para o dia atual)
- Endpoint de cancelamento da agenda diária.
- Endpoint para reagendamento de uma consulta

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Lombok
- H2 Database

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/juliocesarmj/clinicaSpringBoot

# Importar o projeto dentro de uma IDEA (eclipse, intellij)

# Baixar as dependencias informadas no arquivo pom.xml

# Postman para enviar as requisições http

# Endpoints disponíveis até o momento:

# Paciente

## POST
http://localhost:8082/paciente
OBS: Validações implementadas até o momento para evitar registros repetidos(cpf, telefone e email)

Body ex: 
{
    "nome": "paciente 1 teste",
    "email": "s33Sss@aa.com",
    "telefone": "21969323282",
    "dataNascimento": "1990-09-17",
    "cpf": "11511511519",
    "enderecoDTO": {
        "ruaOuAvenida": "rua murilo costa",
        "numero": 10,
        "complemento": "lote x quadra z",
        "bairro": "jaspe",
        "cidade": "nova york",
        "estado": "florida",
        "cep": "55225665"
    }
}

## GET (retorna um paciente especifico por cpf)
http://localhost:8082/paciente/pacienteporcpf/11511511519

## GET (retorna um paciente especifico por id)
http://localhost:8082/paciente/1

## GET (retorna uma listagem paginada com todos os pacientes)
http://localhost:8082/paciente

# Medico

## POST 

http://localhost:8082/medico

Body ex:

{
    "nome": "Julio Cesar de Moraes",
    "crm": "56562323",
    "dataNascimento": "1990-09-17",
    "especialidade": "CLINICO_GERAL",
    "valorConsulta": 150.00
}

OBS: As especialidades devem seguir de acordo com as opções disponíveis, caso contrário uma exceção bad request será lançada.

CARDIOLOGISTA, PEDIATRA, NUTRICIONISTA, GINECOLOGISTA, DENTISTA, NEUROLOGISTA, CLINICO_GERAL, PSICOLOGO;

## GET (Retorna todos os médicos de uma determinada especialidade)
http://localhost:8082/medico/especialidades/NUTRICIONISTA

## GET (Consultar todos os médicos cadastrados)
http://localhost:8082/medico

## GET (Consultar um médico por id)
http://localhost:8082/medico/1

## DELETE (Excluir um médico do sistema)
http://localhost:8082/medico/1

## PUT (Altera os dados de um determinado médico)
http://localhost:8082/medico/1

Body ex:

{
    "nome": "Julio Cesar de Moraes",
    "crm": "56562323",
    "dataNascimento": "1990-09-17",
    "especialidade": "CLINICO_GERAL",
    "valorConsulta": 150.00
}

# Consultas

## POST (Agenda uma nova consulta)
http://localhost:8082/consulta

Body ex: 

{
    "pacienteId": 1,
    "medicoId": 1,
    "statusConsulta": "AGENDADA",
    "statusPagamento": "AGUARDANDO_PAGAMENTO",
    "dataAgendamento": "2022-06-30",
    "observacoesMedico": "" (opcional)
}

## GET (Pesquisa uma consulta por id)
http://localhost:8082/consulta/1

Json retorno:

{
    "id": 1,
    "dataRegistroConsulta": "2022-06-25",
    "statusConsulta": "AGENDADA",
    "statusPagamento": "AGUARDANDO_PAGAMENTO",
    "dataAgendamento": "2022-06-30",
    "pacienteDTO": {
        "id": 1,
        "nome": "paciente 1 teste",
        "email": "s33Sss@aa.com",
        "telefone": "21969323282",
        "dataNascimento": "1990-09-17",
        "cpf": "11511511519",
        "enderecoDTO": {
            "ruaOuAvenida": "rua murilo costa",
            "numero": 10,
            "complemento": "lote x quadra z",
            "bairro": "jaspe",
            "cidade": "nova york",
            "estado": "florida",
            "cep": "55225665"
        }
    },
    "medicoDTO": {
        "id": 1,
        "nome": "Julio Cesar de Moraes",
        "crm": "56562323",
        "dataNascimento": "1990-09-17",
        "especialidade": "CLINICO_GERAL",
        "valorConsulta": 150.0
    },
    "observacoesMedico": ""
}

# Autor

Julio Cesar de Moraes 

https://www.linkedin.com/in/julio-moraes-1291a2170/
