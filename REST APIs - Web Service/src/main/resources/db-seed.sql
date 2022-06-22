create database BookService;

use BookService;

show tables;

create table if not exists books (
    book_id varchar(20) primary key,
    book_title varchar(100),
    book_author varchar(20),
    book_price float
);

show tables;

insert into books values('ISBN101', 'The advantures of Tom Sawyer', 'Mark Twain', 10.25);
insert into books values('ISBN102', 'To Kill a Mockingbird', 'Harper Lee', 8.50);
insert into books values('ISBN103', 'All the Light We Cannot See', 'Anthony Derr', 9.50);
insert into books values('ISBN104', 'Little Women', 'Louisa May Alcott', 8.75);
insert into books values('ISBN105', 'Charlie and the Chocolate Factory', 'Roald Dahl', 7.65);

select * from books;