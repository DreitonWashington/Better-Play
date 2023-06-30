create table cast_member(
	id bigint auto_increment primary key not null,
    name varchar(200) not null,
    type varchar(20)
)engine=InnoDB default charset=utf8mb4;

insert into cast_member (name,type) values ("Robert Denin", "ACTOR");
insert into cast_member (name,type) values ("Julian Aln", "ACTOR");
insert into cast_member (name,type) values ("Maria Marry", "DIRECTOR");
insert into cast_member (name,type) values ("Peter Park", "ACTOR");
insert into cast_member (name,type) values ("Milles Minaj", "ACTOR");