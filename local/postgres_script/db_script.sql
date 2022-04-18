create schema banco_student;

create table banco_student.student(
    id integer not null primary key,

    name varchar(250),
    email varchar(250),
    dob Date

);
CREATE SEQUENCE hibernate_sequence START 1;
