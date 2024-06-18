create table if not exists users(

    username varchar(255) not null,
    name varchar(255) not null,
    position varchar(255) not null,
    password varchar(255) not null,
    isadmin bit not null,
    primary key(username)

);

CREATE TABLE IF NOT EXISTS filemanager (
    name VARCHAR(255) NOT NULL,
    filename VARCHAR(255) NOT NULL,
    file LONGBLOB NOT NULL,
    date VARCHAR(255) NOT NULL,
    creator VARCHAR(255) NOT NULL,
    contenttype VARCHAR(255) NOT NULL,
    PRIMARY KEY(name)
);