-- findMarketAllList() 전체 상점 리스트 조회
SELECT market_name, info FROM udon_market;

-- findMarketListSortByItem() 카테고리별 상점 리스트 조회
SELECT market_name, info FROM udon_market WHERE item='과일';

-- findMarketListByName() 상점 이름으로 검색 조회
SELECT market_name, info FROM udon_market WHERE market_name LIKE '%과%';
