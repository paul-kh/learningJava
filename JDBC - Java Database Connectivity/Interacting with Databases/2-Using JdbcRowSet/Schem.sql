/* Create new schema */
create database DeliveryService;

use DeliveryService;

show tables;

/* Create new table */
create table if not exists delpartners (
    id int auto_increment primary key,
    first_name varchar(100),
    last_name varchar(20),
    hourly_rate double,
    is_fulltime boolean
);

/* Insert 2 row of data to the table */
insert into delpartners values (101, 'Adam', 'Bell', 18.5, true);
insert into delpartners values (102, 'Eric', 'Jones', 22.75, false);

select * from delpartners;

/* Verify the auto auto_increment */
insert into delpartners (first_name, last_name, hourly_rate, is_fulltime)
values ('Pam', 'Cruz', 19.0, true);

select * from delpartners;