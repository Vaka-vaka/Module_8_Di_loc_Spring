create table roles (
	id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
	roles_name varchar(50) not null
);


create table users (
	id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
	email varchar(100) not null,
	password varchar(100),
	last_name varchar(100) not null,
	first_name varchar(100) not null
);


create table userS_roleS(
	userS_id uuid not null,
	roleS_id uuid not null,
	CONSTRAINT fk_users_userS_id FOREIGN KEY(userS_id) REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_roles_roleS_id FOREIGN KEY(roleS_id) REFERENCES roles(id) ON DELETE CASCADE
);


create table producers (
	id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
	producers_name varchar(250) not null
);


create table products (
	id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
	products_name varchar(250) not null,
	price decimal not null,
	producers_id UUID not null,
	CONSTRAINT fk_producers_id FOREIGN KEY(producers_id) REFERENCES producers(id) ON DELETE CASCADE);