create table if not exists users(

    username varchar(255) not null,
    name varchar(255) not null,
    position varchar(255) not null,
    password varchar(255) not null,
    isadmin bit not null,
    primary key(username)

);