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


create table users (
	"user_id" serial primary key,
	"username" text unique not null,
	"password" text not null,
	"first_name" text,
	"last_name" text
);




begin;
insert into "media" ("price", "type", "name", "copyright_owner", "release_date", "rating", "max_age" , "min_age")
			values  (10.00, 'movie', 'Hot Fuzz', 'Simon Pegg', '2009-01-01', 9, 65, 13),
			        (1.00, 'movie', 'Cats', 'Lloyd Weber', '2019-10-01', 1, 65, 13),
			        (5.99, 'movie', 'Harry Potter and the Philosopher''s Stone', 'JK Rolwing', '2001-11-01', 10, 100, 1)
			       returning "media_id";
			       
insert into movie ("runtime", "main_media")
  			values( 122.00,  1),
  			      (300.00, 2),
  			      (159.00, 3);
  			     
insert into crew ("name")
			values ('Daniel Radcliffe'),
				   ('Emma Watson'),
				   ('Rupert Grint'),
				   ('Simon Pegg'),
				   ('Nick Frost'),
				   ('Taylor Swift'),
				   ('Idris Elba'),
				   ('Judy Dench');
			
insert into movie_crew values (1, 4),
							  (1, 5),
							  (2, 6),
							  (2, 7),
							  (2, 8),
							  (3, 1),
							  (3, 2),
							  (3, 3);
							 
commit;
  			     

select m.price , m."type" , m."name" , m.copyright_owner , m.release_date, m.rating, m.max_age , m.min_age , m.media_id , m2.runtime , m2.movie_id , array_agg(c."name") as credits from media m 
			inner join movie m2 on m.media_id = m2.main_media 
			inner join movie_crew mc on m2.movie_id = mc.movie_id 
			inner join crew c on mc.crew_id = c.crew_id
			group by m.media_id, m2.movie_id;
		
		
create view all_movies as select m.price , m."type" , m."name" , m.copyright_owner , m.release_date, m.rating, m.max_age , m.min_age , m.media_id , m2.runtime , m2.movie_id , array_agg(c."name") as credits from media m 
			inner join movie m2 on m.media_id = m2.main_media 
			inner join movie_crew mc on m2.movie_id = mc.movie_id 
			inner join crew c on mc.crew_id = c.crew_id
			group by m.media_id, m2.movie_id;
		
		
		
select * from all_movies;

select * from media m;

insert into users ("username", "password", "first_name", "last_name")
			values ('AB', 'password', 'Alec', 'Batson');
