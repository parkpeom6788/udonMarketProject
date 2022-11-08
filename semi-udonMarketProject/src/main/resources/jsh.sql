-- findMarketAllList() 전체 상점 리스트 조회
SELECT id, market_name, info FROM udon_market;

-- findMarketListSortByItem() 카테고리별 상점 리스트 조회
SELECT id, market_name, info FROM udon_market WHERE item='과일';

-- findMarketListByName() 상점 이름으로 검색 조회
SELECT id, market_name, info FROM udon_market WHERE market_name LIKE '%과%';

-- findBoardList() 상점게시판 리스트 조회
SELECT b.board_no, b.title, TO_CHAR(b.time_posted,'YYYY/MM/DD') AS time_posted, b.hits, m.id, m.market_name, m.market_address, m.market_tel, m.info, m.item, m.market_no
FROM udon_market_board b
INNER JOIN udon_market m ON b.id = m.id
WHERE b.id='java4'
ORDER BY b.board_no DESC;

-- findMarketInfo() 상점게시판에서 상점 소개글 조회
SELECT market_name, market_address, market_tel, item, info, market_no FROM udon_market WHERE id='java';

-- pagination ( findBoardList() 에 pagination 추가 )
	-- step 1
	SELECT ROW_NUMBER() OVER(ORDER BY board_no DESC), board_no, title, TO_CHAR(time_posted,'YYYY/MM/DD') AS time_posted
	FROM udon_market_board
	WHERE id='java4';
	-- step2
	SELECT board_no, title, time_posted
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY board_no DESC) AS rnum, board_no, title, TO_CHAR(time_posted,'YYYY/MM/DD') AS time_posted, id
		FROM udon_market_board
		WHERE id='java4'
	) 
	WHERE rnum BETWEEN 1 AND 5;

-- totalPostCount() 페이징처리에 사용
SELECT COUNT(*) FROM udon_market_board WHERE id='java4';

-- findCommentList() 댓글 조회하기
SELECT comment_no, comment_content, TO_CHAR(comment_time_posted, 'YYYY.MM.DD. HH24:MI') AS comment_time_posted, id, board_no
FROM udon_comment
WHERE board_no = 40
ORDER BY comment_no DESC;

-- udon_comment 테이블의 comment_content 의 타입을 VARCHAR2(100) 에서 CLOB으로 변경
ALTER TABLE udon_comment ADD content CLOB;
ALTER TABLE udon_comment DROP COLUMN comment_content;
ALTER TABLE udon_comment RENAME COLUMN content TO comment_content;
-- NOT NULL 제약조건 추가는 ADD 가 아니라 MODIFY 를 사용함
	ALTER TABLE udon_comment MODIFY comment_content NOT NULL;

SELECT * FROM udon_comment;
COMMIT

-- 장문의 댓글이 어떻게 보이는 지 확인
	--INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 꼭 드셔보세요~',SYSDATE,1,'java');
		-- ORA-12899: value too large for column "SCOTT"."UDON_COMMENT"."COMMENT_CONTENT" (actual: 107, maximum: 100)
		-- 데이터 타입을 VARCHAR2(100) 에서 CLOB 으로 변경함 -> INSERT 성공함
		INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 꼭 드셔보세요~',SYSDATE,1,'java');
	
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요.',SYSDATE,1,'java');
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 댓글수정삭제 테스트 다른 아이디',SYSDATE,1,'java2');
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 정말이야',SYSDATE,1,'java');
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 정말이야.',SYSDATE,1,'java');
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 정말이야. 아',SYSDATE,1,'java');
	INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 정말이야. 아아',SYSDATE,1,'java');
	-- INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'안녕하세요. 마늘상점의 채소들은 정말 싱싱하고 맛있어요. 정말이야. 아아아',SYSDATE,1,'java');
		-- ORA-12899: value too large for column "SCOTT"."UDON_COMMENT"."COMMENT_CONTENT" (actual: 103, maximum: 100)
SELECT * FROM udon_comment;
COMMIT

-- writeComment() 댓글작성하기
INSERT INTO udon_comment(comment_no,comment_content,comment_time_posted,board_no,id) VALUES(udon_comment_seq.nextval,'댓글등록이 되나요?',SYSDATE,1,'java');
SELECT * FROM udon_comment;
COMMIT

-- findCommentByCommentNo() 댓글번호로 댓글 조회
	-- step1. 해당 게시판에서 회원이 가장 최근에 단 댓글의 댓글번호 조회하기
	SELECT comment_no
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY comment_no DESC) AS rnum, comment_no
		FROM udon_comment
		WHERE id='java' AND board_no=151
	)
	WHERE rnum=1;
	-- step2. 댓글번호로 댓글 조회
	SELECT comment_no, comment_content, TO_CHAR(comment_time_posted, 'YYYY.MM.DD. HH24:MI') AS comment_time_posted, id, board_no
	FROM udon_comment
	WHERE comment_no = 54; 


-- 게시판 내에서 회원 아이디로 가장 최근 댓글 조회
	-- step1
	SELECT ROW_NUMBER() OVER(ORDER BY comment_no DESC) AS rnum, id, comment_content, TO_CHAR(comment_time_posted, 'YYYY.MM.DD. HH24:MI') AS comment_time_posted, board_no
	FROM udon_comment
	WHERE id='java' AND board_no=151;
	-- step2
	SELECT comment_content, comment_time_posted, id, board_no
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY comment_no DESC) AS rnum, id, comment_content, TO_CHAR(comment_time_posted, 'YYYY.MM.DD. HH24:MI') AS comment_time_posted, board_no
		FROM udon_comment
		WHERE id='java' AND board_no=151
	)
	WHERE rnum=1;

-- deleteComment() 댓글 삭제하기
DELETE FROM udon_comment WHERE comment_no=57;

-- updateComment() 댓글 수정하기
UPDATE udon_comment SET comment_content='댓글이 수정되나요?' WHERE comment_no=5;
SELECT * FROM udon_comment;
COMMIT

-- 좋아요 조회
SELECT * FROM udon_like;
DELETE FROM udon_like WHERE board_no=10;
select id from udon_like where id = 'java6' and  board_no = 24;
commit









