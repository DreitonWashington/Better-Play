create table genre(
	id bigint auto_increment not null primary key,
    name varchar(25) not null,
    description varchar(255),
    isActive boolean,
    createdAt datetime
)engine=InnoDB default charset=utf8mb4;

insert into genre (id,name,isActive,createdAt) values (1,"Animação",true,"2023-06-09 10:06:51");
insert into genre (id,name,isActive,createdAt) values (2,"Ação",true,"2023-06-09 10:16:04");
insert into genre (id,name,isActive,createdAt) values (3,"Sci-fi",true,"2023-06-09 10:20:20");
insert into genre (id,name,isActive,createdAt) values (4,"Comédia",true,"2023-06-09 10:44:17");
insert into genre (id,name,isActive,createdAt) values (5,"Teste",true,"2023-06-10 12:30:17");