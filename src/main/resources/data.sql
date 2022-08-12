--Address
INSERT INTO ADDRESS (address_id,land_mark,area,house_no,pincode,state,town_city) VALUES (3,'easter corner','moshi','45','412105','Maharashtra','pune');

INSERT INTO ADDRESS (address_id,land_mark,area,house_no,pincode,state,town_city) VALUES (4,'town park','moshi goan','02','412105','Maharashtra','pcmc');

INSERT INTO ADDRESS (address_id,land_mark,area,house_no,pincode,state,town_city) VALUES (5,'sai hira','dudulgoan','311','412101','Maharashtra','pcmc');

INSERT INTO ADDRESS (address_id,land_mark,area,house_no,pincode,state,town_city) VALUES (6,'tree town','bhosari','L52','412111','Maharashtra','pcmc');

--User
INSERT INTO CONSUMER (consumer,issued_date,meter_number,sanctioned_load,type_connection,user_name,voltage_level,address_id) VALUES (1,'2008-11-11',1,1.0,'Resdential','umesh','LT',3);
INSERT INTO CONSUMER (consumer,issued_date,meter_number,sanctioned_load,type_connection,user_name,voltage_level,address_id) VALUES (2,'2008-11-11',2,1.0,'Resdential','sagar','LT',4);
INSERT INTO CONSUMER (consumer,issued_date,meter_number,sanctioned_load,type_connection,user_name,voltage_level,address_id) VALUES (3,'2008-11-11',3,1.0,'Resdential','utkal','LT',5);
INSERT INTO CONSUMER (consumer,issued_date,meter_number,sanctioned_load,type_connection,user_name,voltage_level,address_id) VALUES (4,'2008-11-11',4,1.0,'Resdential','Aniket','LT',6);

--Bill

INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (4,333,101,1,1.0,true,0,101,101,1);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (5,333,401,1,1.0,true,101,401,300,1);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (6,333,501,1,1.0,true,401,501,100,1);

INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (7,333,101,2,1.0,true,0,101,101,2);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (8,333,401,2,1.0,true,101,401,300,2);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (9,333,501,2,1.0,true,401,501,100,2);

INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (10,333,101,2,1.0,true,0,101,101,3);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (11,333,401,2,1.0,true,101,401,300,3);
INSERT INTO UNIQUE_BILL (bill,amount,current_reading,meter_no,multiply,paid,previous_reading,total_unit,unit,cp_fk) VALUES (12,333,501,2,1.0,true,401,501,100,3);



