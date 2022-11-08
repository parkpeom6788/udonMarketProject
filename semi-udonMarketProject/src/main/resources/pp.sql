select b.board_no,b.title,b.content,to_char(b.time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , b.hits , m.id
from  udon_market_board b inner join  udon_market m on  b.id = m.id  where b.board_no = 1;
select * from udon_market_board;
select * from udon_member;

select b.board_no,b.title,b.content,to_char(b.time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , b.hits , m.id
from  udon_market_board b inner join  udon_market m on  b.id = m.id  where
b.board_no = '1';

조회수 증가 
update udon_market_board set hits = hits + 1 where board_no = 1;

select * from udon_market_board where id = 'java4';

select board_no , title, content , to_char(time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , hits from udon_market_board where board_no = 18;

select * from udon_market_board;

select *AWS_TEST

-- 회원 수정을 위한 조인 
select b.board_no , b.title , b.content , to_char(b.time_posted,'yyyy.MM.DD HH24.MI:SS') as time_posted , b.content 
from udon_market_board b , udon_market m 
where b.id = m.id;

update udon_market_board set title = '수정됐나' , content = '수정됏나' where board_no = 2;
select * from udon_market_board where board_no = 2; 
select * from udon_market_board;

select IMAGE_NAME  from udon_market_board where BOARD_NO = 17;

select count(*) from udon_like where id = 'java' and board_no = '2';

select * from udon_market_board;
select * from udon_member;

CREATE TABLE udon_like (
	board_no ,
	id ,
	CONSTRAINT udon_like_board_no_fk FOREIGN KEY(board_no) REFERENCES udon_market_board(board_no) ,
	CONSTRAINT udon_like_id_fk FOREIGN KEY(id) REFERENCES udon_member(id) 
)

-- 좋아요 했는지 확인 -> boolean
select id , board_no from udon_like where id = 'java2' and  board_no = '30';
-- 좋아요 추가
insert into udon_like(id,board_no) values('java','30');
insert into udon_like(id,board_no) values('java2','30');
insert into udon_like(id,board_no) values('java3','30');

-- 좋아요 삭제
delete from udon_like where id = 'java' and board_no = '30';

-- 좋아요 개수 조회
select count(*) from udon_like where board_no = '30';  

commit

-- 좋아요 체크
select * from udon_like;
select COUNT(*) from udon_like where id = 'java4' and  board_no = 27;
delete from udon_like where id = 'java4' and board_no = '24';




