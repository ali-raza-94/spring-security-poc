
insert into app_users (id,username,password,enabled) values (1,'ali','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);
insert into app_users (id,username,password,enabled) values (2,'raza','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);
insert into app_users (id,username,password,enabled) values (3,'memon','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);

insert into authority (id,authority) values(1,'ROLE_USER');
insert into authority (id,authority) values(2,'ROLE_ADMIN');

insert into user_authorities (user_id,authority_id) values(1,1);
insert into user_authorities (user_id,authority_id) values(2,2);
insert into user_authorities (user_id,authority_id) values(3,1);
insert into user_authorities (user_id,authority_id) values(3,2);