drop seqeuence struts03_seq;
drop table struts03;
create table struts03(
	num number primary key,
	sub varchar2(50),
	content varchar2(1024)
);
create sequence struts03_seq;
--dummy
insert into struts03 values (struts03_seq.nextval, 'test01', 'test contet');
insert into struts03 values (struts03_seq.nextval, 'test02', 'test contet');
insert into struts03 values (struts03_seq.nextval, 'test03', 'test contet');
insert into struts03 values (struts03_seq.nextval, 'test04', 'test contet');
insert into struts03 values (struts03_seq.nextval, 'test05', 'test contet');
commit;

-- select num, sub from struts03 order by num desc; list
-- select num, sub, content from struts03 where num=?; detail
-- insert into struts03 values (struts03_seq.nextval, ?, ?); add
