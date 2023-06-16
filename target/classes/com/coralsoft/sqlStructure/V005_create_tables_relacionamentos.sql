create table videos_genres(
	id bigint auto_increment primary key,
	video_id bigint not null,
    genre_id bigint not null,
    foreign key (video_id) references videos(id),
    foreign key (genre_id) references genre(id)
)engine=InnoDB default charset=utf8mb4;

create table videos_cast_members(
	id bigint primary key not null auto_increment,
    video_id bigint not null,
    cast_member_id bigint not null,
    foreign key (video_id) references videos(id),
    foreign key (cast_member_id) references cast_member(id)
)engine=InnoDB default charset=utf8mb4;

create table comments(
	id bigint primary key auto_increment,
    description varchar(500),
    isActive boolean,
    video_id bigint,
    createdAt datetime,
    foreign key (video_id) references videos(id)
)engine=InnoDB default charset=utf8mb4;