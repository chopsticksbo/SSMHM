create table book_student(
    book_id int comment '书籍id',
    student_id int comment '学生id',
    primary key(book_id,student_id),
    foreign key(book_id) references book(id),
    foreign key(student_id) references student4course(id)
);

insert into book_student(book_id,student_id) values(1,1);
insert into book_student(book_id,student_id) values(1,2);
insert into book_student(book_id,student_id) values(2,2);
