create database spring;

use spring;

create table employee(
id int primary key,
employeeName varchar(50),
employeeAddress varchar(200),
employeePhone int,
employeeSalary int
);

select * from employee;