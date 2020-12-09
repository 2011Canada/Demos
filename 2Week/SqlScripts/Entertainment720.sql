drop schema if exists entertainment720 cascade;
create schema entertainment720;
set schema 'entertainment720';




--all of the generic fields
--every row will have a one to one with either a movie or book or a something table
create table "media"( 
	"price" numeric(10,2) not null,
	"type" text not null,
	"name" text not null, 
	"copyright_owner" text,
	"release_date" timestamp,
	"rating" int check ("rating" > 0 and "rating" <= 10),
	"max_age" int check("max_age" > "min_age"),
	"min_age" int check("min_age" > 0),
	"media_id" serial primary key--constraint primary key media_pk_constraint ("type", "name") a natural composite key
);


create table movie(
	"runtime" numeric(10,2),
	"movie_id" serial primary key,
	"main_media" int unique references "media" ("media_id")
);

create table crew(
	"name" text,
	"crew_id" serial primary key
);

--to put all of the crew memebers in a movies credits
--join table
create table movie_crew ( 
	"movie_id" int references movie ("movie_id"),
	"crew_id" int references crew ("crew_id"),
	constraint  movie_crew_pk primary key ("movie_id", "crew_id")
);


create table book( 
	"author" text,
	"num_pages" int,
	"book_id" serial primary key,
	"main_media" int unique references "media" ("media_id")
);


