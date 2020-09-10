	insert into voyage (id,voyage_number) values(1,'0100S');
    insert into voyage (id,voyage_number) values(2,'0101S');
    insert into voyage (id,voyage_number) values(3,'0102S');

    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (100,'PUN','BLR',1,'2020-01-20','2020-01-19');
    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (101,'MUM','PUN',2,'2020-01-21','2020-01-20');
    insert into carrier_movement (id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (102,'DEL','MUM',3,'2020-01-22','2020-01-21');  
 