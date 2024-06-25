CREATE TABLE report_reviews
(
    report_id BIGINT NOT NULL,
    review_id BIGINT NOT NULL,
    CONSTRAINT pk_report_reviews PRIMARY KEY (report_id, review_id)
);

CREATE TABLE reports
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_date      datetime     NOT NULL,
    updated_date      datetime     NULL,
    deleted           BIT(1) NOT   NULL,
    agency_id         BIGINT       NOT NULL,
    content           VARCHAR(255) NULL,
    ai_recommendation VARCHAR(255) NULL,
    CONSTRAINT pk_reports PRIMARY KEY (id)
);

CREATE TABLE reviews
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime     NOT NULL,
    updated_date    datetime     NULL,
    deleted         BIT(1) NOT   NULL,
    tourist_id      BIGINT       NOT NULL,
    tour_package_id BIGINT       NOT NULL,
    rating          INT          NULL,
    review_text     VARCHAR(255) NULL,
    CONSTRAINT pk_reviews PRIMARY KEY (id)
);



CREATE TABLE activities
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    updated_date datetime     NULL,
    deleted      BIT(1) NOT   NULL,
    title        VARCHAR(255) NULL,
    img_url      VARCHAR(255) NULL,
    CONSTRAINT pk_activities PRIMARY KEY (id)
);

CREATE TABLE agencies
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_date     datetime     NOT NULL,
    updated_date     datetime     NULL,
    deleted          BIT(1) NOT   NULL,
    user_id          VARCHAR(255) NOT NULL,
    legal_name       VARCHAR(100) NULL,
    ruc              BIGINT       NULL,
    address          VARCHAR(240) NULL,
    agency_photo_url VARCHAR(255) NULL,
    `description`    VARCHAR(255) NULL,
    phone_number     VARCHAR(255) NULL,
    web_page_url     VARCHAR(255) NULL,
    CONSTRAINT pk_agencies PRIMARY KEY (id)
);

CREATE TABLE assigned_vehicles
(
    tour_package_id BIGINT NOT NULL,
    vehicle_id      BIGINT NOT NULL
);

CREATE TABLE bookings
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime     NOT NULL,
    updated_date    datetime     NULL,
    deleted         BIT(1) NOT   NULL,
    serie_number    VARCHAR(255) NULL,
    serie           VARCHAR(255) NULL,
    number          VARCHAR(255) NULL,
    tourist_id      BIGINT       NOT NULL,
    tourist_user_id VARCHAR(255) NOT NULL,
    tour_package_id BIGINT       NOT NULL,
    agency_user_id  VARCHAR(255) NOT NULL,
    selected_date   datetime     NULL,
    start_datetime  datetime     NULL,
    end_datetime    datetime     NULL,
    CONSTRAINT pk_bookings PRIMARY KEY (id)
);

CREATE TABLE correlative
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    updated_date datetime     NULL,
    deleted      BIT(1) NOT   NULL,
    serie        VARCHAR(255) NULL,
    number       VARCHAR(255) NULL,
    digits       INT          NULL,
    type         VARCHAR(255) NULL,
    CONSTRAINT pk_correlative PRIMARY KEY (id)
);

CREATE TABLE departments
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    updated_date datetime     NULL,
    deleted      BIT(1) NOT   NULL,
    name         VARCHAR(255) NULL,
    region_id    BIGINT       NOT NULL,
    CONSTRAINT pk_departments PRIMARY KEY (id)
);

CREATE TABLE destinations
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime        NOT NULL,
    updated_date    datetime        NULL,
    deleted         BIT(1) NOT      NULL,
    latitude        DECIMAL(13, 10) NULL,
    longitude       DECIMAL(13, 10) NULL,
    name            VARCHAR(255)    NULL,
    tour_package_id BIGINT          NOT NULL,
    CONSTRAINT pk_destinations PRIMARY KEY (id)
);

CREATE TABLE regions
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime     NOT NULL,
    updated_date  datetime     NULL,
    deleted       BIT(1) NOT   NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    img_url       VARCHAR(255) NULL,
    CONSTRAINT pk_regions PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE schedule
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime     NOT NULL,
    updated_date    datetime     NULL,
    deleted         BIT(1) NOT   NULL,
    day             VARCHAR(255) NULL,
    start_hour      VARCHAR(255) NULL,
    start_minute    VARCHAR(255) NULL,
    start_day_time  VARCHAR(255) NULL,
    end_hour        VARCHAR(255) NULL,
    end_minute      VARCHAR(255) NULL,
    end_day_time    VARCHAR(255) NULL,
    tour_package_id BIGINT       NOT NULL,
    CONSTRAINT pk_schedule PRIMARY KEY (id)
);

CREATE TABLE temperatures
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    department_id BIGINT   NOT NULL,
    value DOUBLE NOT NULL,
    measured_at   datetime NOT NULL,
    CONSTRAINT pk_temperatures PRIMARY KEY (id)
);

CREATE TABLE tour_package_activities
(
    activity_id     BIGINT NOT NULL,
    tour_package_id BIGINT NOT NULL
);

CREATE TABLE tour_packages
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime        NOT NULL,
    updated_date  datetime        NULL,
    deleted       BIT(1) NOT      NULL,
    title         VARCHAR(255)    NULL,
    `description` TEXT            NULL,
    img_url       VARCHAR(255)    NULL,
    price         DECIMAL(10, 2)  NULL,
    `visible`     BIT(1) NOT      NULL,
    rating        FLOAT           NULL,
    latitude      DECIMAL(13, 10) NULL,
    longitude     DECIMAL(13, 10) NULL,
    region_id     BIGINT          NOT NULL,
    department_id BIGINT          NOT NULL,
    agency_id     BIGINT          NOT NULL,
    CONSTRAINT pk_tour_packages PRIMARY KEY (id)
);

CREATE TABLE tourists
(
    id                     BIGINT AUTO_INCREMENT NOT NULL,
    created_date           datetime     NOT NULL,
    updated_date           datetime     NULL,
    deleted                BIT(1) NOT   NULL,
    user_id                VARCHAR(255) NOT NULL,
    name                   VARCHAR(255) NULL,
    birth_date             datetime     NULL,
    phone_number           VARCHAR(255) NULL,
    photo_url              VARCHAR(255) NULL,
    emergency_phone_number VARCHAR(255) NULL,
    CONSTRAINT pk_tourists PRIMARY KEY (id)
);

CREATE TABLE tracking_wereables
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime        NOT NULL,
    updated_date    datetime        NULL,
    deleted         BIT(1) NOT      NULL,
    tourist_id      BIGINT          NOT NULL,
    tourist_user_id VARCHAR(255)    NOT NULL,
    latitude        DECIMAL(13, 10) NULL,
    longitude       DECIMAL(13, 10) NULL,
    serie_number    VARCHAR(255)    NULL,
    serie           VARCHAR(255)    NULL,
    number          VARCHAR(255)    NULL,
    CONSTRAINT pk_tracking_wereables PRIMARY KEY (id)
);

CREATE TABLE users
(
    id               VARCHAR(255) NOT NULL,
    email            VARCHAR(100) NOT NULL,
    google_name      VARCHAR(100) NOT NULL,
    google_photo_url VARCHAR(255) NULL,
    role_id          BIGINT       NOT NULL,
    created_date     datetime     NOT NULL,
    deleted          BIT(1) NOT   NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE vehicles
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    updated_date datetime     NULL,
    deleted      BIT(1) NOT   NULL,
    brand        VARCHAR(255) NULL,
    model        VARCHAR(255) NULL,
    plate        VARCHAR(255) NULL,
    capacity     INT          NULL,
    driver_name  VARCHAR(255) NULL,
    weight       DECIMAL      NULL,
    img_url      VARCHAR(255) NULL,
    status       SMALLINT     NULL,
    agency_id    BIGINT       NOT NULL,
    CONSTRAINT pk_vehicles PRIMARY KEY (id)
);

CREATE TABLE weather_sensors
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_date   datetime     NOT NULL,
    updated_date   datetime     NULL,
    deleted        BIT(1) NOT   NULL,
    destination_id BIGINT       NOT NULL,
    agency_id      BIGINT       NOT NULL,
    agency_user_id VARCHAR(255) NOT NULL,
    temperature DOUBLE NULL,
    humidity DOUBLE NULL,
    serie_number   VARCHAR(255) NULL,
    serie          VARCHAR(255) NULL,
    number         VARCHAR(255) NULL,
    CONSTRAINT pk_weather_sensors PRIMARY KEY (id)
);

CREATE TABLE weight_balances
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    updated_date datetime     NULL,
    deleted      BIT(1) NOT   NULL,
    vehicle_id   BIGINT       NOT NULL,
    weight DOUBLE NULL,
    serie_number VARCHAR(255) NULL,
    serie        VARCHAR(255) NULL,
    number       VARCHAR(255) NULL,
    CONSTRAINT pk_weight_balances PRIMARY KEY (id)
);

ALTER TABLE reports
    ADD CONSTRAINT FK_REPORTS_ON_AGENCY FOREIGN KEY (agency_id) REFERENCES agencies (id);

ALTER TABLE reviews
    ADD CONSTRAINT FK_REVIEWS_ON_TOURIST FOREIGN KEY (tourist_id) REFERENCES tourists (id);

ALTER TABLE reviews
    ADD CONSTRAINT FK_REVIEWS_ON_TOUR_PACKAGE FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);

ALTER TABLE report_reviews
    ADD CONSTRAINT fk_reprev_on_report FOREIGN KEY (report_id) REFERENCES reports (id);

ALTER TABLE report_reviews
    ADD CONSTRAINT fk_reprev_on_review FOREIGN KEY (review_id) REFERENCES reviews (id);

ALTER TABLE agencies
    ADD CONSTRAINT uc_agencies_user UNIQUE (user_id);

ALTER TABLE tourists
    ADD CONSTRAINT uc_tourists_user UNIQUE (user_id);

ALTER TABLE tracking_wereables
    ADD CONSTRAINT uc_tracking_wereables_tourist UNIQUE (tourist_id);

ALTER TABLE weather_sensors
    ADD CONSTRAINT uc_weather_sensors_destination UNIQUE (destination_id);

ALTER TABLE agencies
    ADD CONSTRAINT FK_AGENCIES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_AGENCY_USER FOREIGN KEY (agency_user_id) REFERENCES users (id);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_TOURIST FOREIGN KEY (tourist_id) REFERENCES tourists (id);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_TOURIST_USER FOREIGN KEY (tourist_user_id) REFERENCES users (id);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_TOUR_PACKAGE FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);

ALTER TABLE departments
    ADD CONSTRAINT FK_DEPARTMENTS_ON_REGION FOREIGN KEY (region_id) REFERENCES regions (id);

ALTER TABLE destinations
    ADD CONSTRAINT FK_DESTINATIONS_ON_TOUR_PACKAGE FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);

ALTER TABLE schedule
    ADD CONSTRAINT FK_SCHEDULE_ON_TOUR_PACKAGE FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);

ALTER TABLE temperatures
    ADD CONSTRAINT FK_TEMPERATURES_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (id);

ALTER TABLE tourists
    ADD CONSTRAINT FK_TOURISTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE tour_packages
    ADD CONSTRAINT FK_TOUR_PACKAGES_ON_AGENCY FOREIGN KEY (agency_id) REFERENCES agencies (id);

ALTER TABLE tour_packages
    ADD CONSTRAINT FK_TOUR_PACKAGES_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (id);

ALTER TABLE tour_packages
    ADD CONSTRAINT FK_TOUR_PACKAGES_ON_REGION FOREIGN KEY (region_id) REFERENCES regions (id);

ALTER TABLE tracking_wereables
    ADD CONSTRAINT FK_TRACKING_WEREABLES_ON_TOURIST FOREIGN KEY (tourist_id) REFERENCES tourists (id);

ALTER TABLE tracking_wereables
    ADD CONSTRAINT FK_TRACKING_WEREABLES_ON_TOURIST_USER FOREIGN KEY (tourist_user_id) REFERENCES users (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_AGENCY FOREIGN KEY (agency_id) REFERENCES agencies (id);

ALTER TABLE weather_sensors
    ADD CONSTRAINT FK_WEATHER_SENSORS_ON_AGENCY FOREIGN KEY (agency_id) REFERENCES agencies (id);

ALTER TABLE weather_sensors
    ADD CONSTRAINT FK_WEATHER_SENSORS_ON_AGENCY_USER FOREIGN KEY (agency_user_id) REFERENCES users (id);

ALTER TABLE weather_sensors
    ADD CONSTRAINT FK_WEATHER_SENSORS_ON_DESTINATION FOREIGN KEY (destination_id) REFERENCES destinations (id);

ALTER TABLE weight_balances
    ADD CONSTRAINT FK_WEIGHT_BALANCES_ON_VEHICLE FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);

ALTER TABLE assigned_vehicles
    ADD CONSTRAINT fk_assveh_on_tour_package FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);

ALTER TABLE assigned_vehicles
    ADD CONSTRAINT fk_assveh_on_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);

ALTER TABLE tour_package_activities
    ADD CONSTRAINT fk_toupacact_on_activity FOREIGN KEY (activity_id) REFERENCES activities (id);

ALTER TABLE tour_package_activities
    ADD CONSTRAINT fk_toupacact_on_tour_package FOREIGN KEY (tour_package_id) REFERENCES tour_packages (id);