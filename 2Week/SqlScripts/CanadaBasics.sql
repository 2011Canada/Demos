



--this is how you write a comment in sql
create table if not exists Users (--we can drop this table and re create it or we can alter the original
	small_num int2,
	norm_num int4,
	norm_num2 int,
	big_num int8
);


drop table users cascade; -- this drops users and constraints if it exists

create table users();

alter table users 
	add column small_num int2,
	add column norm_num int4 unique;
	
create table "types" (
	basic_text varchar,
	super_basic_text char(10),
	best_text text, --is a dynamic sized, optimized text storage field, that pg recommends you use
	id serial, --auto incrementing int4, when you don't input a value in a serial, it places its own value one above the last one it placed
	my_time_field timestamp, -- ISO style string timestamp
	most_numbers numeric(10,2),--first number is total number of digits allowed, second number is how many can be after a decimal place
	t_or_f boolean
);

create table "constraints"(
	important_value int not null,
	unique_value int unique,
	rating int check (rating < 11 and rating > 0),
	def_value int default 9,
	pk int primary key, --not null + unique, primary key is a unique value that identify each row
	fk int references "users" (norm_num) on update cascade --table_name (column_in_that_table)
);



insert into "users" values (1, 1),
						   (2,2);
						  
insert into "constraints" (important_value, unique_value, rating, pk, fk) 
						 values (0, 0, 5, 1,  1);

						
delete from "users" where norm_num = 2;