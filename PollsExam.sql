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




