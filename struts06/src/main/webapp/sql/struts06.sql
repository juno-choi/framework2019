 CREATE TABLE STRUTS06 
   (	NUM NUMBER NOT NULL ENABLE, 
	NAME VARCHAR2(20 BYTE), 
	SUB VARCHAR2(20 BYTE), 
	CONTENT VARCHAR2(2000 BYTE), 
	NALJA DATE, 
	 CONSTRAINT STRUTS06_PK PRIMARY KEY (NUM) ENABLE
   );
   CREATE SEQUENCE STRUTS06_SEQ;
   --dummy
   insert into struts06 values (struts06_seq.nextval,'tester','test1','test content1',sysdate);
   insert into struts06 values (struts06_seq.nextval,'tester','test2','test content2',sysdate);
   insert into struts06 values (struts06_seq.nextval,'tester','test3','test content3',sysdate);
   insert into struts06 values (struts06_seq.nextval,'tester','test4','test content4',sysdate);
   commit;