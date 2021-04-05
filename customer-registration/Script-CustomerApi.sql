drop database if exists api_customer_registation;
create database api_customer_registation;
use api_customer_registation;

create table customer(
	id_customer int not null auto_increment,
	nome varchar(40),
	idade int,
	email varchar(40),
	cpf varchar(15),
    primary key(id_customer)
);