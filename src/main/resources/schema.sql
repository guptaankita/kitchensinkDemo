CREATE TABLE IF NOT EXISTS member(
    id bigint not null,
    phone_number varchar(12) not null,
    name varchar(25) not null,
    email varchar(255) not null,
    primary key (id)
);