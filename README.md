# About

The ideia is to create an application that's able to assist people to locate points of interest (POIs).

This service will be REST, so we'll create an API.

# Example

- 'Restaurant' (x=27, y=12)
- 'Station' (x=31, y=18)
- 'Jewelry' (x=15, y=12)
- 'Florist' (x=19, y=21)
- 'Pub' (x=12, y=8)
- 'Supermarket' (x=23, y=6)
- 'BBQ' (x=28, y=2)

Given the coordinates (X=20, y=10) for the POIs, indicated by the GPS, and a maximum distance of 10 meters, the service
should return the following POIs:

- Restaurant
- Jewelry
- Pub
- Supermarket

# Requirements

- Register the POIs, with 3 attributes: name of the PI, coordinates (integer, not negative) both X and Y;
- POIs should be stored in a database;
- List all the registered POIs
- List the POIs per proximity. This service will receive both coordinates (X and Y), specifying a point of reference,
with a maximum distance (d-max) in meters. The service must return all the POIs in the database that are in a distance
smaller or igual the d-max (maximum distance) from a POI.

# Techs

- Spring Web
- Lombok
- PostgreSQL
- Docker
- Spring Data JPA

# Project

## Architecture

```textmate
src/
├── domain/               # Entidades e interfaces
│   ├── model/            # Classes de domínio (entidades)
│   ├── repository/       # Interfaces dos repositórios
├── application/          # Lógica de negócios (serviços)
├── infrastructure/       # Implementações de repositórios e banco
│   ├── persistence/      # Repositórios que implementam a interface do domínio
│   ├── migrations/       # Flyway migrations
├── web/                  # Interfaces HTTP
│   ├── controllers/      # Controladores REST
│   ├── dtos/             # DTOs (entrada/saída)
│   ├── exceptions/       # Manipulação de exceções
└── config/               # Configurações da aplicação
```

## Entities
