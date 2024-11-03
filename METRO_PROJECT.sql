use metro;
create database metro;
-- drop table login_details;
-- drop table registration_details;

create table registration_details(
id int primary key auto_increment,
emailId varchar(200) ,
password varchar(200),
firstName varchar(200),
lastName varchar(200),
gender varchar(200),
birthdayDate varchar(200),
mobileNumber long,
otp varchar(200),
noOfAttempts int ,
isAccountBlocked boolean,
userImage varchar(200),
imageType varchar(200)
);



create table login_details(
 id int auto_increment primary key,
firstName varchar(200),
loginTime datetime,
logoutTime datetime,
emailId varchar(200),
password varchar(200)
);

SELECT * FROM registration_details;
-- truncate registration_details;
SELECT * FROM login_details;
-- truncate login_details;

CREATE TABLE train_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    trainNumber varchar(200),
    trainType varchar(200),
    stationName VARCHAR(200)
);
-- truncate train_details;
	select * from train_details;
-- drop table train_details;
--  delete  from train_details where id=17;


CREATE TABLE time_details(
id INT auto_increment primary KEY,
fromDay varchar(200),
toDay varchar(200),
source varchar(200),
destination varchar(200),
sourceTime varchar(200),
destinationTime varchar(200),
trainType varchar(200)
);

SELECT * FROM time_details;
-- drop table time_details;
-- truncate time_details;
CREATE TABLE price_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    trainType varchar(200),
    source varchar(200),
    destination varchar(200),
    price varchar(200)
);

select* from price_details;
-- truncate price_details;



create table user_registration_details(
id int primary key auto_increment,
emailId varchar(200) ,
password varchar(200),
firstName varchar(200),
lastName varchar(200),
gender varchar(200),
birthdayDate varchar(200),
mobileNumber long,
otp varchar(200),
noOfAttempts int ,
isAccountBlocked boolean,
userImage varchar(200),
imageType varchar(200)
);

select * from user_registration_details;
-- truncate user_registration_details;


create table user_login_Details(
id int auto_increment primary key,
firstName varchar(200),
loginTime datetime,
logoutTime datetime,
emailId varchar(200),
password varchar(200)
);

