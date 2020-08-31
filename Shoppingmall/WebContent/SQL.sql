CREATE TABLE member(
	id VARCHAR2(50) CONSTRAINT mem_id_pk PRIMARY KEY,
	passwd VARCHAR2(60) CONSTRAINT mem_pass_nn NOT NULL,
	name VARCHAR2(10) CONSTRAINT mem_name_nn NOT NULL,
	reg_date DATE CONSTRAINT mem_reg_date_nn NOT NULL,
	address VARCHAR2(100) CONSTRAINT mem_addr_nn NOT NULL,
	tel VARCHAR2(13) CONSTRAINT mem_tel_nn NOT NULL
);

INSERT INTO member
VALUES(
'whdnjsdyd111@naver.com', '$2a$10$HZ.LUGjgGgE0OWYhXDayx.5uuqYeA8iDd4gDZ5lzXdSpKzLYW4yBq', '조원용',  SYSDATE, '대구광역시',   01068480083);
 
INSERT INTO member
VALUES(
'kingdora@dragon.com',    '$2a$10$dpzBwCuiffdnI8hfsIHhWOl3Agsp0aSAItAi69NhhImkHHoNvFhBi', '김개동',  SYSDATE, '서울시',     01011112222);
 
INSERT INTO member
VALUES(
'hongkd@aaa.com',         '$2a$10$T4uzKAz0MrbsUMXZ8xqc9.KGwTQkW9F0qJyI2VUwbycnC9mze/Qjq', '홍킬동',  SYSDATE, '경기도',     01022223333);


CREATE TABLE manager (
	managerId VARCHAR2(50) CONSTRAINT manager_id_pk PRIMARY KEY,
	managerPassword VARCHAR2(60) CONSTRAINT manager_pw_nn NOT NULL
);

INSERT INTO manager
VALUES('bookmaster@shop.com', 123456);


CREATE TABLE book (
	book_id NUMBER CONSTRAINT book_id_pk PRIMARY KEY,
	book_kind VARCHAR2(3) CONSTRAINT book_kind_nn NOT NULL,
	book_title VARCHAR2(100) CONSTRAINT book_title_nn NOT NULL,
	book_price NUMBER CONSTRAINT book_price_nn NOT NULL,
	book_count NUMBER CONSTRAINT book_count_nn NOT NULL,
	author VARCHAR2(40) CONSTRAINT book_author_nn NOT NULL,
	publishing_com VARCHAR2(30) CONSTRAINT book_com_nn NOT NULL,
	publishing_date VARCHAR2(15) CONSTRAINT book_pub_date_nn NOT NULL,
	book_image VARCHAR2(16) DEFAULT 'nothing.jpg',
	book_content CLOB CONSTRAINT book_content_nn NOT NULL,
	discount_rate NUMBER DEFAULT 10,
	reg_date TIMESTAMP CONSTRAINT book_reg_date_nn NOT NULL
);


CREATE TABLE qna(
	qna_id NUMBER CONSTRAINT qna_id_pk PRIMARY KEY,
	book_id NUMBER CONSTRAINT qna_book_id_fk REFERENCES book(book_id),
	book_title VARCHAR2(100) CONSTRAINT qna_book_title_nn NOT NULL,
	qna_writer VARCHAR2(50) CONSTRAINT qna_writer_fk REFERENCES member(id),
	qna_content CLOB CONSTRAINT qna_content_nn NOT NULL,
	group_id NUMBER CONSTRAINT qna_groud_id_nn NOT NULL,
	qora NUMBER CONSTRAINT qna_qora_nn NOT NULL,
	reply NUMBER CONSTRAINT qna_reply_nn NOT NULL,
	reg_date TIMESTAMP CONSTRAINT qna_date_nn NOT NULL
);


CREATE TABLE bank(
	account VARCHAR2(30) CONSTRAINT bank_acc_pk PRIMARY KEY,
	bank VARCHAR2(12) CONSTRAINT bank_bank_nn NOT NULL,
	name VARCHAR2(10) CONSTRAINT bank_name_nn NOT NULL
);

INSERT INTO bank
VALUES('11111-111-11111', '내일은행', '오내일');


CREATE TABLE cart(
	cart_id NUMBER CONSTRAINT cart_id_pk PRIMARY KEY,
	buyer VARCHAR2(50) CONSTRAINT cart_buyer_fk REFERENCES member(id),
	book_id NUMBER CONSTRAINT cart_book_id_fk REFERENCES book(book_id),
	buy_price NUMBER CONSTRAINT cart_price_nn NOT NULL,
	buy_count NUMBER CONSTRAINT cart_count_nn NOT NULL,
	book_image VARCHAR2(16) DEFAULT 'nothing.jpg'
);


CREATE TABLE buy(
	buy_id NUMBER CONSTRAINT buy_id_nn NOT NULL,
	buyer VARCHAR2(50) CONSTRAINT buy_buyer_fk REFERENCES member(id),
	book_id NUMBER CONSTRAINT buy_book_id_fk REFERENCES book(book_id),
	book_title VARCHAR2(100) CONSTRAINT buy_book_title_nn NOT NULL,
	buy_price NUMBER CONSTRAINT buy_price_nn NOT NULL,
	buy_count NUMBER CONSTRAINT buy_count_nn NOT NULL,
	book_image VARCHAR2(16) DEFAULT 'nothing.jpg',
	buy_date TIMESTAMP CONSTRAINT buy_date_nn NOT NULL,
	account VARCHAR2(50) CONSTRAINT buy_acc_fk REFERENCES bank(account),
	deliveryName VARCHAR2(12) CONSTRAINT buy_delName_nn NOT NULL,
	deliveryTel VARCHAR2(20) CONSTRAINT buy_delTel_nn NOT NULL,
	deliveryAddress VARCHAR2(100) CONSTRAINT buy_delAdd_nn NOT NULL,
	sanction VARCHAR2(20) DEFAULT '상품 준비중'
);