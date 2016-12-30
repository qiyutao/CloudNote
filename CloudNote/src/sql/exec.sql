create table User(
user_id int not null AUTO_INCREMENT,
user_name varchar(80),
user_passwd varchar(80),
user_email varchar(80),
user_time DATETIME,
primary key (user_id)
);
select * from note order by note_id desc;