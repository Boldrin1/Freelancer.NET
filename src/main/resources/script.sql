create database Freelancer.NET;

create table usuarios(
id int not null auto_increment primary key;
nome varchar(40),
email varchar(45),
senha boolean,
dataNascimento date,
sexo varchar(10),
cpf int,
telefone varchar(15)
)