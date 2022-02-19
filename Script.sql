create database project_handler

create table projects(
id serial primary key not null,
name varchar(75) not null
)

select * from projects

insert into projects(name) values ('Amsterdam')

insert into projects(name) values ('Moscow')



create table devices(
id serial primary key not null,
serial_number varchar (50) not null,
project_id integer references projects(id) not null
)

select * from devices

insert into devices(serial_number, project_id) values('4BCD', 1)

insert into devices(serial_number, project_id) values('4BCC', 1)

insert into devices(serial_number, project_id) values('4BCE', 1)


insert into devices(serial_number, project_id) values('2XYZ', 2)

insert into devices(serial_number, project_id) values('2HIJ', 2)

insert into devices(serial_number, project_id) values('2MNP', 2)



create table events (
id serial primary key not null,
devices_id integer references devices(id) not null,
date date not null,
type varchar(70) not null check (type in ('EVENT', 'WARNING','ERROR')),
is_read boolean default false not null
)

select * from events

insert into events(devices_id, date, type, is_read) values(1, '2022-02-18', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(1, '2022-02-18', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(1, '2022-02-15', 'ERROR', false)

insert into events(devices_id, date, type, is_read) values(1, '2022-02-14', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(1, '2022-02-13', 'ERROR', false)

insert into events(devices_id, date, type, is_read) values(1, '2022-02-12', 'WARNING', false)



insert into events(devices_id, date, type, is_read) values(2, '2022-02-18', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-17', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-15', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-14', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-13', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-12', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-11', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-10', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(2, '2022-02-08', 'WARNING', false)


insert into events(devices_id, date, type, is_read) values(3, '2022-02-18', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(3, '2022-02-17', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(3, '2022-02-15', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(3, '2022-02-14', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(3, '2022-02-13', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(3, '2022-02-12', 'EVENT', false)


insert into events(devices_id, date, type, is_read) values(4, '2022-02-18', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(4, '2022-02-17', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(4, '2022-02-18', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(4, '2022-02-17', 'EVENT', false)


insert into events(devices_id, date, type, is_read) values(5, '2022-02-18', 'ERROR', false)

insert into events(devices_id, date, type, is_read) values(5, '2022-02-17', 'EVENT', false)

insert into events(devices_id, date, type, is_read) values(5, '2022-02-18', 'WARNING', false)

insert into events(devices_id, date, type, is_read) values(5, '2022-02-17', 'EVENT', false)
