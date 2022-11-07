CREATE TABLE udon_member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	member_no VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL,
	member_type NUMBER DEFAULT 0
)

DROP TABLE udon_member;

INSERT INTO udon_member(id,password,name,member_no,address,tel) VALUES('java','a','아이유','987654-211','판교','010-1111-1111');
INSERT INTO udon_member(id,password,name,member_no,address,tel) VALUES('java2','a','박보검','887654-111','판교','010-2111-1111');
INSERT INTO udon_member(id,password,name,member_no,address,tel) VALUES('java3','a','강하늘','787654-111','판교','010-3111-1111');
INSERT INTO udon_member(id,password,name,member_no,address,tel,member_type) VALUES('java4','a','김규빈','687654-111','판교','010-4111-1111',1);
INSERT INTO udon_member(id,password,name,member_no,address,tel,member_type) VALUES('java5','a','이강인','587654-111','판교','010-5111-1111',1);
INSERT INTO udon_member(id,password,name,member_no,address,tel,member_type) VALUES('java6','a','박채은','487654-211','판교','010-6111-1111',1);
SELECT * FROM udon_member;
COMMIT


CREATE TABLE udon_market(
	id VARCHAR2(100) PRIMARY KEY,
	market_name VARCHAR2(100) NOT NULL,
	market_address VARCHAR2(100) NOT NULL,
	market_tel VARCHAR2(100) NOT NULL,
	item VARCHAR2(100) CHECK (item IN('과일','채소','수산물')) NOT NULL,
	info VARCHAR2(100) NOT NULL,
	market_no VARCHAR2(100),
	CONSTRAINT undon_market_fk FOREIGN KEY(id) REFERENCES udon_member(id), 
	CONSTRAINT market_no_uniq  UNIQUE(market_no)
)

DROP TABLE udon_market;

INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) VALUES('java4','포도청과','판교','010-4111-1111','과일','맛있는과일상점','11111-11');
INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) VALUES('java5',',상추야채','판교','010-5111-1111','채소','맛있는채소상점','21111-11');
INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) VALUES('java6','광어수산','판교','010-6111-1111','수산물','싱싱한수산물상점','31111-11');
SELECT * FROM udon_market;
COMMIT

CREATE TABLE udon_market_board(
	board_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE NOT NULL,
	hits NUMBER DEFAULT 0,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT undon_market_board_fk FOREIGN KEY(id) REFERENCES udon_member(id)  
)
CREATE SEQUENCE undon_market_board_seq;

ALTER TABLE udon_market_board ADD image_name VARCHAR2(100) DEFAULT NULL;

DROP SEQUENCE undon_market_board_seq;
DROP TABLE udon_market_board;

INSERT INTO udon_market_board(board_no,title,content,time_posted,id) VALUES(undon_market_board_seq.nextval,'우동마켓','오늘은 목요일',SYSDATE,'java4');
INSERT INTO udon_market_board(board_no,title,content,time_posted,id) VALUES(undon_market_board_seq.nextval,'우동마켓1','오늘은 목요일',SYSDATE,'java4');
INSERT INTO udon_market_board(board_no,title,content,time_posted,id) VALUES(undon_market_board_seq.nextval,'우동마켓2','오늘은 목요일',SYSDATE,'java4');
INSERT INTO udon_market_board(board_no,title,content,time_posted,id) VALUES(undon_market_board_seq.nextval,'우동마켓3','오늘은 목요일',SYSDATE,'java4');
SELECT * FROM udon_market_board;
COMMIT

CREATE TABLE udon_comment(
	comment_no NUMBER PRIMARY KEY,
	comment_content CLOB NOT NULL,
	comment_time_posted DATE NOT NULL,
	board_no NUMBER NOT NULL,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT comment_board_no_fk FOREIGN KEY(board_no) REFERENCES udon_market_board(board_no) ON DELETE CASCADE,  
	CONSTRAINT comment_id_fk FOREIGN KEY(id) REFERENCES udon_member(id)  
)
CREATE SEQUENCE udon_comment_seq;

DROP SEQUENCE udon_comment_seq;
DROP TABLE udon_comment;

INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요',SYSDATE,1,'java');
INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요',SYSDATE,1,'java2');
INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요',SYSDATE,1,'java3');
INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요',SYSDATE,1,'java');
SELECT * FROM udon_comment;
COMMIT

CREATE TABLE udon_like (
	board_no PRIMARY KEY ,
	id NOT NULL,
	CONSTRAINT udon_like_board_no_fk FOREIGN KEY(board_no) REFERENCES udon_market_board(board_no),  
	CONSTRAINT udon_like_id_fk FOREIGN KEY(id) REFERENCES udon_member(id)  
)

SELECT * FROM udon_like;

COMMIT








