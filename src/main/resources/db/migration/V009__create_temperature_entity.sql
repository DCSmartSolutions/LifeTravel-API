CREATE TABLE temperatures
(
    id           bigint IDENTITY (1, 1) NOT NULL,
    created_date datetime               NOT NULL,
    updated_date datetime,
    deleted      bit                    NOT NULL,
    value        float(53)              NOT NULL,
    measured_at  datetime               NOT NULL,
    CONSTRAINT pk_temperatures PRIMARY KEY (id)
)
GO