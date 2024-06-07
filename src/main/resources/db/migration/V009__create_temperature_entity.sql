CREATE TABLE temperatures
(
    id           bigint IDENTITY (1, 1) NOT NULL,
    value        float(53)              NOT NULL,
    measured_at  datetime               NOT NULL,
    department_id bigint                NOT NULL,
    CONSTRAINT pk_temperatures PRIMARY KEY (id)
)
GO

ALTER TABLE temperatures
    ADD CONSTRAINT FK_TEMPERATURES_ON_DEPARTMENTS FOREIGN KEY (department_id) REFERENCES departments (id)
GO