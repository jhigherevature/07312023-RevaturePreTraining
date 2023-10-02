drop table if exists orders;
drop table if exists customers;

create table customers(
	customer_id int primary key auto_increment,
	customer_name varchar(255) not null unique
);

create table orders(
	order_id int primary key auto_increment,
	customer_id int,
	order_total double,
	order_date DATE,
	foreign key (customer_id) references customers(customer_id)
);