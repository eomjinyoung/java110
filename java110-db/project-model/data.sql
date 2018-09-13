-- 회원 정보 
insert into p1_memb(mno, name, email, pwd, cdt)
values (1, 'user01', 'user01@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (2, 'user02', 'user02@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (3, 'user03', 'user03@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (4, 'user04', 'user04@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (5, 'user05', 'user05@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (6, 'user06', 'user06@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (7, 'user07', 'user07@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (8, 'user08', 'user08@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (9, 'user09', 'user09@test.com', password('1111'), now());
insert into p1_memb(mno, name, email, pwd, cdt)
values (10, 'user10', 'user10@test.com', password('1111'), now());

-- 학생 회원
insert into p1_stud(sno,schl,work) values(1,'비트대학교','N');
insert into p1_stud(sno,schl,work) values(2,'비트대학교','Y');
insert into p1_stud(sno,schl,work) values(3,'캠프대학교','Y');
insert into p1_stud(sno,schl,work) values(4,'캠프대학교','N');
insert into p1_stud(sno,schl,work) values(5,'오호라대학교','N');

-- 강사 회원
insert into p1_tchr(tno,hrpay,subj) values(6,10000,'자바,C,C++');
insert into p1_tchr(tno,hrpay,subj) values(7,12000,'자바,빅데이터');
insert into p1_tchr(tno,hrpay,subj) values(8,14000,'C,C++,안드로이드');

-- 매니저 회원 
insert into p1_mgr(mrno,posi) values(9,'대리');
insert into p1_mgr(mrno,posi) values(10,'과장');









