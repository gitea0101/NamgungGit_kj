
CREATE TABLE AnswerN
(
  Anum   INT          NOT NULL,
  Answer VARCHAR(200) NULL    ,
  PRIMARY KEY (Anum)
) COMMENT '답항';

CREATE TABLE QAseq
(
  UserNum INT NOT NULL COMMENT '사용자번호',
  QANum   INT NOT NULL COMMENT '결과'
) COMMENT '설문';

CREATE TABLE QAtable
(
  Qnum  INT NOT NULL,
  Anum  INT NOT NULL,
  QANum INT NOT NULL,
  PRIMARY KEY (QANum)
) COMMENT '설문지';

CREATE TABLE QuestionN
(
  Qnum     INT          NOT NULL COMMENT '문항인수',
  Question VARCHAR(200) NULL     COMMENT '질문',
  PRIMARY KEY (Qnum)
) COMMENT '문항인수';

CREATE TABLE User
(
  UserNum INT          NOT NULL COMMENT '사용자번호',
  Name    VARCHAR(200) NULL     COMMENT '이름',
  PRIMARY KEY (UserNum)
) COMMENT '사용자명';

ALTER TABLE QAtable
  ADD CONSTRAINT FK_QuestionN_TO_QAtable
    FOREIGN KEY (Qnum)
    REFERENCES QuestionN (Qnum);

ALTER TABLE QAseq
  ADD CONSTRAINT FK_User_TO_QAseq
    FOREIGN KEY (UserNum)
    REFERENCES User (UserNum);

ALTER TABLE QAseq
  ADD CONSTRAINT FK_QAtable_TO_QAseq
    FOREIGN KEY (QANum)
    REFERENCES QAtable (QANum);

ALTER TABLE QAtable
  ADD CONSTRAINT FK_AnswerN_TO_QAtable
    FOREIGN KEY (Anum)
    REFERENCES AnswerN (Anum);
