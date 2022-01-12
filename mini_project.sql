/*drop database mini_project_db;

create database mini_project_db;

use database mini_project_db;*/

create table user_info_tbl (user_id int primary key auto_increment not null, user_firstname varchar(100), user_lastname varchar(100), user_email varchar(100), user_mobile varchar(15), user_username varchar(100), user_password varchar(100));

create table hobby_tbl(hobby_id int primary key auto_increment, hobby_userid int, hobby_hobbyname varchar(100), foreign key (hobby_userid) references user_info_tbl (user_id));