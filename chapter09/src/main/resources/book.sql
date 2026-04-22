create table book(
    id int primary key not null auto_increment comment '主键',
    name varchar(20) comment '书名',
    price double comment '价格'
);
insert into book(name,price) values('java','100');
insert into book(name,price) values('mysql','200');
insert into book(name,price) values('spring','300');
insert into book(name,price) values('mybatis','400');
insert into book(name,price) values('hibernate','500');



