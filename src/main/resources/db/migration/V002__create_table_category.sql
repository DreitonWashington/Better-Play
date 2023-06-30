create table category(
	id bigint auto_increment primary key not null,
    name varchar(25) not null,
    description varchar(255),
    isActive boolean,
    createdAt datetime
)engine=InnoDB default charset=utf8mb4;

insert into category (name,isActive,createdAt) values ("Filme",true,"2023-06-15 22:01:00");
insert into category (name,isActive,createdAt) values ("Série",true,"2023-06-15 22:01:00");
insert into category (name,isActive,createdAt) values ("Documentário",true,"2023-06-15 22:01:00");
insert into category (name,isActive,createdAt) values ("Documentário",true,"2023-06-15 22:01:00");