select b.board_no,b.title,b.content,to_char(b.time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , b.hits , m.id
from  udon_market_board b inner join  udon_market m on  b.id = m.id  where b.board_no = 1;
select * from udon_market_board;
select * from udon_member;
select b.board_no,b.title,b.content,to_char(b.time_posted,'YYYY.MM.DD HH24.MI.SS') as time_posted , b.hits , m.id
from  udon_market_board b inner join  udon_market m on  b.id = m.id  where
b.board_no = '1';

조회수 증가 
update udon_market_board set hits = hits + 1 where board_no = 1;