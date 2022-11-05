create table udon_member (
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	member_no varchar2(100) not null,
	address varchar2(100) not null,
	tel varchar2(100) not null,
	member_type number default 0
)

select * from udon_member;

insert into udon_member (id,password,name,member_no,address,tel,member_type)
values('java','a','아이유','930101-222','오리','010-1111-1111',0) ;

insert into udon_member (id,password,name,member_no,address,tel,member_type)
values(?,?,?,?,?,?,?);



SELECT count(*) from udon_member where id='java';


Select count(*) from udon_market where market_no=?;

Select * from UDON_MARKET;


	Update UDON_MARKET set market_name = '1', market_tel ='010-0000-0000', info = 'ㅎㅎㅎ'
	where id = 'java';

delete from UDON_MARKET where market_no=?

update udon_member set member_type = member_type - 1 where id = 'java3';

Select id from UDON_MEMBER where name = '아이유' and member_no = '987654-211' and tel = '010-1111-1111';

Select id from UDON_MEMBER where name = ? and member_no = ? and tel = ?





