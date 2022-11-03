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
ORDER BY b.board_no DESC;

-- findMarketInfo() 상점게시판에서 상점 소개글 조회
SELECT market_name, market_address, market_tel, item, info, market_no FROM udon_market WHERE id='java';








