CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_point_of_interest (

    /*
    get_random_uuid é uma função
    de uma extensão do Postgres
    onde iremos instalar depois.
    Ela irá gerar uma random UUID
    */
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,  -- Auto-incremento
                         name VARCHAR(30) NOT NULL,
                         x INT NOT NULL CHECK (x >= 0 AND x <= 99),
                         y INT NOT NULL CHECK (y >= 0 AND y <= 99)
);