set schema 'chinook';




select * from "Album" a left join "Artist" a2 on a."ArtistId" = a2."ArtistId" order by a2."ArtistId"  desc;




select * from ("Artist" a inner join "Album" a2 on a."ArtistId" = a2."ArtistId") inner join "Track" t on a2."AlbumId" = t."AlbumId";



create view songs_total as (select a."ArtistId", a2."AlbumId", t."TrackId", 
							a."Name" as "Band Name", a2."Title" as "Album Title", t."Name" as "Song Name",
							t."Composer", t."GenreId", t."UnitPrice", t."Bytes", t."MediaTypeId", t."Milliseconds" 
							from ("Artist" a inner join "Album" a2 on a."ArtistId" = a2."ArtistId") inner join "Track" t on a2."AlbumId" = t."AlbumId");
							
						
select * from songs_total as st inner join "Genre" g on g."GenreId" = st."GenreId" where g."Name" = 'Rock'; 	
						
						

--set ops

select * from 
	(select c."City" , c."Country" from "Customer" c 
		intersect
	 select e."City" , e."Country" from "Employee" e) as mailing_list;
	
	 
select * from "Employee" e where "City" = 'Edmonton' and "Country" = 'Canada';

						