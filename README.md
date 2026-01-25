# Praticando_Java

## Sistema de Gerenciamento de Bootcamps Java
Microprojeto Java Puro com Programação Orientada a Objetos (POO)

Este projeto é um microprojeto/desafio de arquitetura em Java puro, desenvolvido com foco em Programação Orientada a Objetos, boas práticas de design, camadas definidas e uso consciente de generics e streams, sem frameworks ou banco de dados.

O objetivo principal é praticar domínio conceitual de POO, arquitetura em camadas e organização de código, simulando um sistema educacional de gerenciamento de bootcamps.

## Descrição do Projeto

O sistema simula uma plataforma educacional capaz de gerenciar:

- Cursos com carga horária definida
- Mentorias com datas agendadas
- Bootcamps, que agrupam cursos e mentorias
- Desenvolvedores (Devs) inscritos nos bootcamps
- Consultas de negócio (ex.: bootcamps com cursos longos ou mentorias futuras)

A persistência é feita inteiramente em memória, utilizando estruturas de dados do Java (HashMap, Set, List), simulando o comportamento de um banco de dados.

## Camadas

- Domain
    - Representa o modelo de negócio (entidades e invariantes).
- DAO (Data Access Object)
    - Camada de persistência em memória, abstraída por generics.
- Service
    - Camada de regras de negócio, consultas semânticas e coordenação entre DAOs.
- Main
    - Ponto de entrada da aplicação, responsável apenas por orquestrar e executar casos de uso.
    
### Conceitos de POO Aplicados

- Herança
- Polimorfismo
- Abstração
- Encapsulamento
- Composição
- Injeção de Dependência
- Generics
- Override de Métodos
- Programação Funcional

### Possíveis Evoluções
- Cálculo de XP por conteúdo
- Regras de progressão do Dev
- Persistência real (JPA/Hibernate)
- Testes unitários
- Interfaces de Service

## Como Executar o Projeto
Este projeto utiliza Docker + Makefile, garantindo que a aplicação possa ser executada sem necessidade de instalar Java localmente, com ambiente totalmente reprodutível.

### Pré-requisitos
- Docker instalado
- GNU Make instalado (Opcional)

### Comandos Disponíveis
- `make build`-  Build da imagem Docker
- `make run`-  Executar a aplicação
- `make rebuild`-  Rebuild completo
- `make clean`-  Limpeza do ambiente