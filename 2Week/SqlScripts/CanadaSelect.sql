set schema 'chinook';




--select, you can use select and a value/function cll on its own

select now();

--when actualkly getting data, we always start with select "columns" from "table_name"
--frequently we use a * to match all columns

select * from "Artist";

--to narrow down a query we can utilize a where clause
select * from "Artist" where "ArtistId" = 10;
--operators you can use, = < > * / + - and or not (),  in is similar to = but for multiple values on the right
--like-> partial string comparison
--_ to match a single wildcard letter, % to match any number of Wildcard letters
-- 'A%' - will match naything that starts with a capitol A
-- A%D - will match starting capitol A and ending capitol D
select * from "Artist" where "Name" ='Def Leppard';


--I want to know every album made by band that sarts with the letter R
--sub query
--I can run a query and use that query in another select statement


select * from "Album" where "ArtistId" in (select "ArtistId" from "Artist" where "Name" like 'R%');

-- additional clauses to be used with select
-- easiest to discuss is order by -> put at the end of a query and it takes in a column or a few columns, uses those to order the results

select * from "Track" order by "Milliseconds" asc;

-- additional clause next is group by
-- group by is used on columns that will have many repeat values
-- is takes all of the rows that have the same value and smushes them into a new single row
-- if you want any other columns to stick around, you need to run them through an aggregate function

--aggregate function takes many values and turns them into a singler value -> avg, max , min , count


--what is the longest song of each price point in tracks
select  max("Milliseconds"), "UnitPrice" from "Track" group by "UnitPrice";

--marketing team, how much cities spend, which cities buy the most of our stuff
select avg("Total"), "BillingCountry" from "Invoice" group by "BillingCountry" order by avg("Total" ) desc;

--one more clause, called having
--having functions basically exactly the same as where, but having happens at a different time
--first clause to execute is where clause, then we group by, then we apply having, then order by
--having exists to apply restrictions after grouping

select avg("Total"), "BillingCountry" from "Invoice" 
	group by "BillingCountry"
	having avg("Total") > 6
	order by avg("Total" ) desc;





