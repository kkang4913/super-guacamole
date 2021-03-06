/*
 *	SEQUENCE : 순차적으로 정수 값을 자동으로 생성하는 객체 / 자동 번호 발생기 역할을 함
 */
DROP SEQUENCE SEQ_TEST;
CREATE SEQUENCE SEQ_TEST
		START WITH 	 300
		INCREMENT BY   5  
		MAXVALUE 	 310
		MINVALUE     290
		CYCLE
		NOCACHE;
		
SELECT SEQ_TEST.CURRVAL FROM DUAL; -- 객체 생성 직후에는 현재 값이 없다

SELECT SEQ_TEST.NEXTVAL FROM DUAL; --NEXT 부터 실행해야한다.


SELECT NVL(NULL, '0') FROM DUAL;

CREATE SEQUENCE SEQ_TEST CACHE 100; 

COMMIT;