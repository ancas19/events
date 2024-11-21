---Events project.
create table if not exists people(
	person_id serial primary key,
	names varchar(255) not null,
	surnames varchar(255) not null,
	phone_number varchar(255) not null,
	created_user varchar(255) not null,
	updated_user varchar(255),
	created_at timestamp not null default current_timestamp,
	updated_at timestamp
);

create  table if not exists roles(
	role_id serial primary key,
	name varchar(255) not null,
	description varchar(255) not null,
	created_user varchar(255) not null,
	updated_user varchar(255),
	created_at timestamp not null default current_timestamp,
	updated_at timestamp
);
create index idx_name_roles on roles(name);

create table if not exists permissions(
	permission_id serial primary key,
	name varchar(255) not null,
	description varchar(255) not null,
	created_user varchar(255) not null,
	updated_user varchar(255),
	created_at timestamp not null default current_timestamp,
	updated_at timestamp
);
create index idx_name_permissions on permissions(name);


create table if not exists permissions_roles(
	id serial primary key,
	permission_id int not null,
	role_id int  not null,
	foreign key (permission_id) references permissions(permission_id),
	foreign key (role_id) references roles(role_id)
);


create table if not exists users(
	user_id serial primary key,
	username varchar(255) not null,
	email varchar(255) not null,
	verify_email varchar(5) not null,
	change_password varchar(5) not null,
	role_id int not null,
	person_id int not null,
	created_user varchar(255) not null,
	updated_user varchar(255),
	created_at timestamp not null default current_timestamp,
	updated_at timestamp,
	foreign key (role_id) references roles(role_id),
	foreign key (person_id) references people(person_id)
);

create index idx_username_users on users(username);
create index idx_email_users on users(email);


create table if not exists historical_passwords(
	historial_id serial primary key,
	user_id int not null,
	password varchar(255) not null,
	active varchar(5) not null,
	created_user varchar(255) not null,
	updated_user varchar(255),
	created_at timestamp not null default current_timestamp,
	updated_at timestamp ,
	foreign key  (user_id) references users(user_id)
);




