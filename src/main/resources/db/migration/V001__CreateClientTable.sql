CREATE TABLE client (
    id bigint not null AUTO_INCREMENT,
    name varchar(60) not null,
    email varchar(255) not null,
    phone_number varchar(20) not null,
    
    primary key (id)
)