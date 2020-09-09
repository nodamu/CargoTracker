    insert into voyage (id,voyage_number) values(3,'0100S');
    insert into voyage (id,voyage_number) values(4,'0101S');
    insert into voyage (id,voyage_number) values(5,'0102S');

    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1355,'CNHGH','CNHKG',3,'2019-08-28','2019-08-25');
    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1356,'JNTKO','CNHGH',4,'2019-09-10','2019-09-01');
    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1357,'USNYC','JNTKO',5,'2019-09-25','2019-09-15');

