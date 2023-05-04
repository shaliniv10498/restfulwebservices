insert into user_details(id, birth_date, name)
values(1001,current_date(),'shalini' );

insert into user_details(id, birth_date, name)
values(1002,current_date(),'priya' );

insert into user_details(id, birth_date, name)
values(1003,current_date(),'reeya' );

insert into post(id, description, user_id)
values(0001, 'Shalini wants to learn fullstack development', 1001);

insert into post(id, description, user_id)
values(0002, 'Shalini wants to learn DevOps', 1001);

insert into post(id, description, user_id)
values(0003, 'Priya wants to learn SQL', 1002);

insert into post(id, description, user_id)
values(0004, 'Reeya wants to learn development', 1003);

