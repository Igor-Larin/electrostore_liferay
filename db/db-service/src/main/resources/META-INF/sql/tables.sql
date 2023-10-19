create table electronics (
	electronic_id LONG not null primary key,
	name VARCHAR(75) null,
	price INTEGER,
	electronic_count INTEGER,
	is_present BOOLEAN,
	is_archive BOOLEAN,
	description VARCHAR(75) null,
	electrotype_id LONG
);

create table electrotype (
	electrotype_id LONG not null primary key,
	name VARCHAR(75) null
);

create table electrotype_employee (
	emp_id LONG not null,
	electro_id LONG not null,
	primary key (emp_id, electro_id)
);

create table employees (
	employee_id LONG not null primary key,
	name VARCHAR(75) null,
	lastname VARCHAR(75) null,
	midname VARCHAR(75) null,
	birthdate DATE null,
	sex BOOLEAN,
	position_id LONG
);

create table positiontype (
	id LONG not null primary key,
	name VARCHAR(75) null
);

create table purchases (
	purchase_id LONG not null primary key,
	purchase_date DATE null,
	electronic_id LONG,
	purchasetype_id LONG,
	employee_id LONG
);

create table purchasetype (
	purchasetype_id LONG not null primary key,
	name VARCHAR(75) null
);