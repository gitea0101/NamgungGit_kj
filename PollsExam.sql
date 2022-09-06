Insert into  questionn(Qnum, Question)
Values (1, '본 제품의 디자인은 만족 하십니까?')
;

Insert into  questionn(Qnum, Question)
Values (2, '본 제품의 가격은 만족 하십니까?')
;

Insert into  questionn(Qnum, Question)
Values (3, '본 제품의 성능에는 만족 하십니까?')
;

Insert into  questionn(Qnum, Question)
Values (4, 'A/S 서비스는 만족 하십니까?')
;

select Qnum, Question
from questionn
;

Insert into  answern(ANum, Answer)
Values (1, '만족한다.')
;

Insert into  answern(ANum, Answer)
Values (2, '보통이다.')
;

Insert into  answern(ANum, Answer)
Values (3, '불만족한다.')
;

select Anum, Answer from answern;

insert into user(UserNum, Name)
Values(1, '남궁기태')
;

insert into user(UserNum, Name)
Values(2, '김세화')
;

insert into user(UserNum, Name)
Values(3, '정지환')
;

select * from user;

insert into qatable(Qnum,Anum,QANum)
values (1,1,1)
;
insert into qatable(Qnum,Anum,QANum)
values (1,2,2)
;
insert into qatable(Qnum,Anum,QANum)
values (1,3,3)
;
insert into qatable(Qnum,Anum,QANum)
values (2,1,4)
;
insert into qatable(Qnum,Anum,QANum)
values (2,2,5)
;
insert into qatable(Qnum,Anum,QANum)
values (2,3,6)
;
insert into qatable(Qnum,Anum,QANum)
values (3,1,7)
;
insert into qatable(Qnum,Anum,QANum)
values (3,2,8)
;
insert into qatable(Qnum,Anum,QANum)
values (3,3,9)
;
insert into qatable(Qnum,Anum,QANum)
values (4,1,10)
;
insert into qatable(Qnum,Anum,QANum)
values (4,2,11)
;
insert into qatable(Qnum,Anum,QANum)
values (4,3,12)
;


select * from qatable;



