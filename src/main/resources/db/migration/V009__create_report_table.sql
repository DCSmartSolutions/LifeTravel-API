CREATE TABLE reports
(
    id           bigint IDENTITY (1, 1) NOT NULL,
    created_date datetime               NOT NULL,
    updated_date datetime,
    deleted      bit                    NOT NULL,
    content      varchar(255),
    CONSTRAINT pk_reports PRIMARY KEY (id)
)
GO

CREATE TABLE reviews
(
    id           bigint IDENTITY (1, 1) NOT NULL,
    created_date datetime               NOT NULL,
    updated_date datetime,
    deleted      bit                    NOT NULL,
    rating       varchar(255),
    information  varchar(255),
    booking_id   bigint                 NOT NULL,
    CONSTRAINT pk_reviews PRIMARY KEY (id)
)
GO

CREATE TABLE report_tour_packages
(
    report_id       bigint NOT NULL,
    tour_package_id bigint NOT NULL,
    CONSTRAINT pk_reporting_tour_packages PRIMARY KEY (report_id, tour_package_id)
)
GO

ALTER TABLE reviews
    ADD CONSTRAINT FK_REVIEWS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES bookings (id)
GO

ALTER TABLE report_tour_packages
    ADD CONSTRAINT fk_reptoupac_on_report FOREIGN KEY (report_id) REFERENCES reports (id)
GO

ALTER TABLE report_tour_packages
    ADD CONSTRAINT fk_reptoupac_on_review FOREIGN KEY (tour_package_id) REFERENCES reviews (id)
GO