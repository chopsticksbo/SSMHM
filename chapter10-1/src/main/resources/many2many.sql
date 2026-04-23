create database if not exists many2many;
use many2many;
create table if not exists course
(
    id   int primary key auto_increment,
    name varchar(20)
);
insert into course(name)
values ('java');
insert into course(name)
values ('mysql');
insert into course(name)
values ('spring');
insert into course(name)
values ('mybatis');
insert into course(name)
values ('hibernate');
create table if not exists student
(
    id   int primary key auto_increment,
    name varchar(20)
);
insert into student(name)
values ('李四');
insert into student(name)
values ('王五');
insert into student(name)
values ('赵六');
insert into student(name)
values ('王二');
insert into student(name)
values ('王三');
insert into student(name)
values ('张三');
create table if not exists student_course
(
    student_id int,
    course_id  int,
    primary key (student_id, course_id),
    foreign key (student_id) references student (id),
    foreign key (course_id) references course (id)
);
insert into student_course(student_id,course_id)
values (1,1);
insert into student_course(student_id,course_id)
values (1,2);
insert into student_course(student_id,course_id)
values (2,2);
