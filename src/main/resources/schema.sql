drop table if exists STUDENT;
create table STUDENT (
    id int auto_increment primary key,
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    email varchar(100) not null
);