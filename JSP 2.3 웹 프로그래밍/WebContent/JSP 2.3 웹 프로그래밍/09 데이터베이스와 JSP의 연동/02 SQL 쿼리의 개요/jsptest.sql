CREATE TABLE member(
	id VARCHAR2(50) CONSTRAINT mem_id_pk PRIMARY KEY,
	passwd VARCHAR2(16) CONSTRAINT mem_pass_nn NOT NULL,
	name VARCHAR2(10) CONSTRAINT mem_name_nn NOT NULL,
	reg_date DATE CONSTRAINT mem_reg_date_nn NOT NULL,
	address VARCHAR2(100) CONSTRAINT mem_addr_nn NOT NULL,
	tel VARCHAR2(13) CONSTRAINT mem_tel_nn NOT NULL
);

INSERT INTO member
VALUES ('kingdora@dragon.com', '1234', '김개동', SYSDATE, '서울시', '01011112222');
INSERT INTO member
VALUES ('hongkd@aaa.com', '1111', '홍길동', SYSDATE, '경기도', '01022223333');

DROP TABLE member PURGE;

SELECT * FROM MEMBER;


ALTER TABLE member
MODIFY passwd VARCHAR2(60);

DESC member;

CREATE TABLE board
(
	num NUMBER CONSTRAINT board_num_pk PRIMARY KEY,
	writer VARCHAR2(50) CONSTRAINT board_writer_nn NOT NULL,
	subject VARCHAR2(50) CONSTRAINT board_sub_nn NOT NULL,
	passwd VARCHAR2(60) CONSTRAINT board_pass_nn NOT NULL,
	reg_date DATE CONSTRAINT board_reg_date_nn NOT NULL,
	readcount NUMBER CONSTRAINT board_readcount_nn NOT NULL,
	ref NUMBER CONSTRAINT board_ref_nn NOT NULL,
	re_step NUMBER CONSTRAINT board_re_step_nn NOT NULL,
	re_level NUMBER CONSTRAINT board_re_level_nn NOT NULL,
	content CLOB CONSTRAINT board_content_nn NOT NULL,
	ip VARCHAR2(30) CONSTRAINT board_ip_nn NOT NULL,
);

CREATE SEQUENCE board_seq
INCREMENT BY 1
START WITH 1;


SELECT * FROM BOARD;
