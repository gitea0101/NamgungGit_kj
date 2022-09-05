
CREATE TABLE AnswerN
(
  Anum   INT          NOT NULL,
  Answer VARCHAR(200) NULL    ,
  PRIMARY KEY (Anum)
) COMMENT '답항';

CREATE TABLE QAseq
(
  UserNum INT NOT NULL,
  QANum   INT NOT NULL
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
  Qnum     INT          NOT NULL,
  Question VARCHAR(200) NULL    ,
  PRIMARY KEY (Qnum)
) COMMENT '문항인수';

CREATE TABLE User
(
  UserNum INT          NOT NULL,
  Name    VARCHAR(200) NULL    ,
  PRIMARY KEY (UserNum)
) COMMENT '사용자명';

ALTER TABLE QAtable
  ADD CONSTRAINT FK_QuestionN_TO_QAtable
    FOREIGN KEY (Qnum)
    REFERENCES QuestionN (Qnum);

ALTER TABLE QAtable
  ADD CONSTRAINT FK_AnswerN_TO_QAtable
    FOREIGN KEY (Anum)
    REFERENCES AnswerN (Anum);

ALTER TABLE QAseq
  ADD CONSTRAINT FK_User_TO_QAseq
    FOREIGN KEY (UserNum)
    REFERENCES User (UserNum);

ALTER TABLE QAseq
  ADD CONSTRAINT FK_QAtable_TO_QAseq
    FOREIGN KEY (QANum)
    REFERENCES QAtable (QANum);
