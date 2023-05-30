-- UPs
CREATE TABLE IF NOT EXISTS est_schedule_user (
                                                 usr_id           VARCHAR NOT NULL CONSTRAINT est_schedule_user_pk PRIMARY KEY,
                                                 usr_name         VARCHAR,
                                                 usr_email        VARCHAR,
                                                 usr_password     VARCHAR,
                                                 usr_first_access boolean default true,
                                                 usr_cur_id       VARCHAR,
                                                 usr_rol_id       VARCHAR,
                                                 constraint fk_est_schedule_user_est_schedule_role foreign key (usr_rol_id) references est_schedule_role(rol_id),
    constraint fk_est_schedule_user_est_schedule_course foreign key (usr_are_id) references est_schedule_area(are_id)
);

CREATE TABLE IF NOT EXISTS est_schedule_role (
                                                 rol_id      VARCHAR NOT NULL CONSTRAINT est_schedule_role_pk PRIMARY KEY,
                                                 rol_name    VARCHAR
);

CREATE TABLE IF NOT EXISTS est_schedule_area (
                                                   are_id      VARCHAR NOT NULL CONSTRAINT est_schedule_area_pk PRIMARY KEY,
                                                   are_name    VARCHAR
);

CREATE TABLE IF NOT EXISTS est_schedule_time (
                                                 tim_id varchar not null constraint est_schedule_time_pk primary key,
                                                 tim_semester varchar,
                                                 tim_service_time varchar,
                                                 tim_shift varchar,
                                                 tim_day varchar,
                                                 tim_service_start varchar,
                                                 tim_service_end varchar,
                                                 tim_usr_id varchar,
                                                 constraint fk_est_schedule_time_est_schedule_user foreign key (tim_usr_id) references est_schedule_user(usr_id)
);


-- DOWNs

DROP TABLE est_schedule_user cascade;

DROP TABLE est_schedule_role cascade;

DROP TABLE area cascade;

DROP TABLE est_schedule_time cascade;