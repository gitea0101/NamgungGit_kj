Insert into  answern (Anum, Answer)
Values (1, '만족한다.')
;

Insert into  answern (Anum, Answer)
Values (2, '보통이다.')
;

Insert into  answern (Anum, Answer)
Values (3, '불만이다.')
;

select * from answern;

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
Values (4, 'A/S 서비스에 만족 하십니까?')
;

select * from questionn;


Insert into user(UserNum, Name)
Values (1,'남궁기태')
;
Insert into user(UserNum, Name)
Values (2,'김세화')
;
Insert into user(UserNum, Name)
Values (3,'정지환')
;

select * from user;

Insert into qatable(Qnum, Anum, QANum)
Values (1,1,1)
;

select * from qatable;


Insert into qaseq(UserNum, QANum)
Values (1, 1)
;

select * from qaseq;