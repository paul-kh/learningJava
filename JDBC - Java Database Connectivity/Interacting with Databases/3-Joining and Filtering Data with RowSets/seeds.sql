/* Create new schema */
create database DeliveryService;

use DeliveryService;

show tables;

/* Create new table */
create table if not exists delpartners (
    pid int auto_increment primary key,
    first_name varchar(100),
    last_name varchar(20),
    hourly_rate double,
    is_fulltime boolean
);

/* Insert 8 rows of data to the table delpartners */
insert into delpartners values (101, 'Adam', 'Bell', 18.5, true);
insert into delpartners values (102, 'Eric', 'Jones', 22.75, false);
insert into delpartners values (103, 'Pam', 'Cruz', 19.0, true);
insert into delpartners values (104, 'Stacey', 'Shields', 21.0, false);
insert into delpartners values (105, 'Marie', 'Woods', 19.0, true);
insert into delpartners values (106, 'Pablo', 'Hernandez', 20.0, false);
insert into delpartners values (107, 'Kylie', 'Kass', 22.0, false);
insert into delpartners values (108, 'Brian', 'Walters', 22.0, false);

Select * from delpartners;

/* Create table delvehicles - Delivery Vehicles */
create table if not exists delvehicles (
    vid int primary key,
    color varchar(20),
    vehicle_type varchar(20),
    license_plate varchar(10)
);

/* Insert 5 rows of data to the table delvehicles */
insert into delvehicles values (11, 'Red', 'Pickup', 'CPAUL11');
insert into delvehicles values (12, 'Blue', 'Van', 'CPAUL12' );
insert into delvehicles values (13, 'Grey', 'Truck', 'CPAUL13');
insert into delvehicles values (14, 'White', 'Truck', 'CPAUL14' );
insert into delvehicles values (15, 'Red', 'Van', 'CPAUL15');

select * from delvehicles;

/* Create table deliveries - relation between delpartners and delvehicles */
create table if not exists deliveries (
    did int primary key,
    pid int,
    vid int,
    destination varchar(20),
    foreign key(pid) references delpartners(pid) on delete cascade,
    foreign key(vid) references delvehicles(vid) on delete cascade
);

/* Insert 5 rows of data to the table deliveries */
insert into deliveries values (1, 102, 14, "Minneapolis");
insert into deliveries values (2, 103, 12, "Brooklyn Park");
insert into deliveries values (3, 101, 11, "Saint Paul");
insert into deliveries values (4, 107, 13, "Apple Valley");
insert into deliveries values (5, 102, 11, "Burnsville");

select * from deliveries;