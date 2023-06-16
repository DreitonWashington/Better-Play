create table videos(
	id bigint auto_increment not null primary key,
    title varchar(200) not null,
    description varchar(450),
    category_id bigint,
    year_launched int,
    duration int,
    rating int,
    censure varchar(25),
    published boolean,
    thumb_file varchar(200),
    thumb_half varchar(200),
    banner_file varchar(200),
    trailer_file varchar(200),
    video_file varchar(200),
    createdAt datetime
)engine=InnoDB default charset=utf8mb4;

alter table videos add foreign key (category_id) references category(id);

insert into videos (title,description, category_id,year_launched,duration,rating,censure,published,video_file,createdAt) values ("Dungeons&Dragons","Em um mundo repleto de dragões, elfos, anões, orcs e outras criaturas fantásticas, sobreviver é sempre um grande desafio. Raven Hightower é um humano que se arrisca entre os lugares mais perigosos e misteriosos desse universo, sempre com a ajuda de outros aventureiros que, assim como ele, estão dispostos a combater o mal e a derrotar as mais terríveis criaturas que surgem em seus caminhos."
,1,2023,120,5,"L",true,"C:/Users/dreit/OneDrive/Área de Trabalho/workspace-eclipse-ee/Servers/Server-BetterPlay-config/filmes","2023-06-15 19:03:00");

