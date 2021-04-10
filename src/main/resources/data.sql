create table if not exists W_CITY
(
    id         varchar(10) primary key,
    name       varchar(255) not null,
    country    varchar(255) not null,
    created_at timestamp    not null,
    updated_At timestamp    not null
    )

create table if not exists W_WEATHER
(
    id         varchar(10) primary key,
    city_id    varchar(10)   not null,
    temp       decimal(3, 2) not null,
    feels_like decimal(3, 2) not null,
    temp_min   decimal(3, 2) not null,
    temp_max   decimal(3, 2) not null,
    pressure   decimal(3, 2) not null,
    humidity   decimal(3, 2) not null,
    wind_speed decimal(3, 2) not null,
    wind_deg   decimal(3, 2) not null,
    date       timestamp     not null,
    created_at timestamp     not null,
    updated_At timestamp     not null,
    foreign key (city_id) references W_CITY(id)
    )