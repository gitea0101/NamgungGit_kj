Insert into  qnum(Qnum, Question)
Values (1, '본 제품의 디자인은 만족 하십니까?')
;

Insert into  qnum(Qnum, Question)
Values (2, '본 제품의 가격은 만족 하십니까?')
;

Insert into  qnum(Qnum, Question)
Values (3, '본 제품의 성능에는 만족 하십니까?')
;

Insert into  qnum(Qnum, Question)
Values (4, 'A/S 서비스는 만족 하십니까?')
;

select Qnum, Question
from qnum
;

Insert into  answer(ANum, Answer)
Values (1, '만족한다.')
;

Insert into  answer(ANum, Answer)
Values (2, '보통이다.')
;

Insert into  answer(ANum, Answer)
Values (3, '불만족한다.')
;

select Anum, Answer from answer;

insert into userid(UserNum, Name)
Values(1, '남궁기태')
;

insert into userid(UserNum, Name)
Values(2, '김세화')
;

insert into userid(UserNum, Name)
Values(3, '정지환')
;

select * from userid;

insert into qa(UserNum,Qnum,ANum,QAnum)
Values (1,1,1,1)
;
insert into qa(UserNum,Qnum,ANum,QAnum)
Values (1,2,1,2)
;
insert into qa(UserNum,Qnum,ANum,QAnum)
Values (1,3,2,3)
;
insert into qa(UserNum,Qnum,ANum,QAnum)
Values (1,4,3,4)
;

select * from qa;


