-- login sql
SELECT member_type,name,member_no,address,tel
FROM udon_member WHERE id='java' and password='a';

--registerMarket sql
INSERT INTO udon_market(id,market_name,market_address,market_tel,item,info,market_no) 
VALUES(?, ?, ?, ?, ?, ?, ?);

SELECT * FROM udon_market;
SELECT * FROM udon_member;

--findMemberById sql
SELECT password,member_type,name,member_no,address,tel FROM udon_member WHERE id='java';

--updateMember sql
UPDATE udon_member SET password='aa',name='주주',tel='010-1111-1456' WHERE id='1111';