create table users(
	id bigint not null primary key auto_increment,
    email varchar(50) not null,
    password varchar(50) not null
)engine=InnoDB default charset=utf8mb4;

insert into users (email,password) values ("test@gmail.com","dGVzdGVuY29kZTY0");