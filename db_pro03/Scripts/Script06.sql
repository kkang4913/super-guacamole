CREATE TABLE accounts(
			ID 			VARCHAR2(20) 	PRIMARY KEY
		   ,PW 			VARCHAR2(20)
		   ,NAME 		VARCHAR2(20)
		   ,GENDER 		CHAR(1)
		   ,AGE 		NUMBER
		   ,CREATEDATE	DATE		
		  );
		   

INSERT INTO ACCOUNTS VALUES ('SS','11','강승호','M',18,NULL)

SELECT * FROM ACCOUNTS; 

DELETE FROM ACCOUNTS WHERE ID = 'test2';

DROP TABLE ACCOUNTS;