create database cloudnote;
use cloudnote;

create table User(
user_id int not null AUTO_INCREMENT,
user_name varchar(80),
user_passwd varchar(80),
user_email varchar(80),
user_time DATETIME,
primary key (user_id)
);

create table Note(
note_id int not null AUTO_INCREMENT,
user_id int not null,
note_title varchar(80),
note_context varchar(10240),
note_date DATETIME
primary key(note_id),
foreign key(user_id) references User(user_id)
);
