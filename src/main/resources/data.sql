
insert into App_User (id,username,password,enabled) values (1,'ali','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);
insert into App_User (id,username,password,enabled) values (2,'raza','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);
insert into App_User (id,username,password,enabled) values (3,'memon','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);
insert into App_User (id,username,password,enabled) values (4,'adeel','{SHA-256}d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1',true);

insert into Privilege (id,name) values(1,'READ_PRIVILEGE');
insert into Privilege (id,name) values(2,'WRITE_PRIVILEGE');
insert into Privilege (id,name) values(3,'DELETE_PRIVILEGE');

insert into Role (id,name) values(1,'ROLE_USER');
insert into Role (id,name) values(2,'ROLE_ADMIN');
insert into Role (id,name) values(3,'ROLE_STAFF');
insert into Role (id,name) values(4,'ROLE_SPECIAL_USER');

insert into role_privilege (role_id,privilege_id) values(1,1);
insert into role_privilege (role_id,privilege_id) values(2,1);
insert into role_privilege (role_id,privilege_id) values(2,2);
insert into role_privilege (role_id,privilege_id) values(2,3);

insert into user_roles (user_id,role_id) values(1,1);
insert into user_roles (user_id,role_id) values(2,2);
insert into user_roles (user_id,role_id) values(3,3);
insert into user_roles (user_id,role_id) values(4,4);