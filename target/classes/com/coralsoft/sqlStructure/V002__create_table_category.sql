create table category(
	id bigint auto_increment primary key not null,
    name varchar(25) not null,
    description varchar(255),
    isActive boolean,
    createdAt datetime
)engine=InnoDB default charset=utf8mb4;