SELECT EMPLOYEE_ID AS 사번
	  ,FIRST_NAME AS 이름
	  ,LAST_NAME AS 성
	  ,DEPARTMENT_ID AS 부서
FROM EMPLOYEES
ORDER BY 4 DESC NULLS LAST , 이름 DESC; --ASC 오름 DESC 내림



--GROUP BY

SELECT DEPARTMENT_ID
	, JOB_ID
	, COUNT(*)
	, SUM(SALARY)
	, AVG(SALARY)
	, MAX(SALARY)
	, MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID; 


SELECT DECODE(COMMISSION_PCT, NULL, 'NO', 'YES') AS "NULL유무"
	,COUNT(*) AS 수
FROM EMPLOYEES
GROUP BY DECODE(COMMISSION_PCT, NULL, 'NO', 'YES');

/*
 * 1980 년대, 1990년대 ,2000년대 별로 그룹을 묶어서 평균급여와 총인원 수를 구한다.
 */

SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1) AS 년도 
	,AVG(SALARY) AS 평균급여
	,COUNT(*) AS 인원
	FROM EMPLOYEES
GROUP BY TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1)
ORDER BY 년도;
/*
 * 커미션을 받는 직원 둥 가장 높은 급여액과 가장 낮은 급여액을 구한다.
 */

SELECT MAX(COMMISSION_PCT)
	  ,MIN(COMMISSION_PCT)
	  FROM EMPLOYEES
	  WHERE COMMISSION_PCT IS NOT NULL;

/*
 * DEPARTMENT 테이블에서 MANAGER_ID 가 NULL이 아닌 부서의 수와 아닌 부서의 수를 구한다.
 */
SELECT COUNT(*)
		,DECODE(MANAGER_ID, NULL, 'NO', 'YES') AS 관리자유무
		FROM EMPLOYEES
		GROUP BY DECODE(MANAGER_ID, NULL, 'NO', 'YES');
	 

/*
 * EMPLOYEE 테이블에서 급여 통계를 위해 급여 구역별 인원 수를 구한다.
 * 급여 구역은 2000부터 10000단위로 분류하도록 한다
 *  2000~ 3000 미만, 3000~ 4000 미만, 4000~ 5000미만
 */	

SELECT TRUNC(SALARY, -3) AS 급여
	,COUNT(*) AS 인원수
FROM EMPLOYEES
GROUP BY TRUNC(SALARY, -3)
ORDER BY 급여;
/*	
WHERE      HAVING
조건절	  그룹 조건절
*/
-- FROM -> WHERE -> GROUP -> HAVING -> SELECT ->ORDER 쿼리문 순서
SELECT TRUNC(SALARY, -3) AS 급여
	,COUNT(*) AS 인원수
FROM EMPLOYEES
GROUP BY TRUNC(SALARY, -3)
HAVING COUNT(*) >= 10
ORDER BY 급여;

SELECT TRUNC(SALARY, -3) AS 급여
		,COUNT(*) AS 인원수
FROM EMPLOYEES 
GROUP BY TRUNC(SALARY, -3)
HAVING COUNT(*) >=4
ORDER BY 1;

/*
 * 부서별 전화번호 사용 실태를 확인하기 위한 조회 쿼리를 작성한다.
 * 		전화 번호 앞자리 3자리에 따라 다음의 요금이 측정되어 있다.
 * 		515 : 월 500원
 * 		590 : 월 450원
 * 		650 : 월 400원
 * 		011 : 월 300원
 *  	603 : 월 600원
 * 	위의 요금을 참고하여 부서별 월별 통신비를 산출하도록 한다.
 */


SELECT DEPARTMENT_ID AS 부서
	  ,SUBSTR(PHONE_NUMBER,1,3) AS "앞자리 번호"
	  ,COUNT(*) AS "인원 수"
	  ,DECODE(SUBSTR(PHONE_NUMBER,1,3),  '515',500* COUNT(*) 
	  									,'590',450* COUNT(*) 
	  									,'650',400* COUNT(*)
	  									,'011',300* COUNT(*) 
	  									,'603',600* COUNT(*)) AS "총사용요금"
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID,SUBSTR(PHONE_NUMBER,1,3)
ORDER BY DEPARTMENT_ID;

ROLLUP, CUBE
	그룹별 산출한 결과에 대해서 추가 집계를 수행하는 함수
	
SELECT DEPARTMENT_ID
		,COUNT(*)
	FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY 1;
	
	
SELECT DEPARTMENT_ID
		,COUNT(*)
	FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID)
ORDER BY 1;

SELECT DEPARTMENT_ID
		,JOB_ID
		,COUNT(*)
	FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY 1;

SELECT DEPARTMENT_ID
		,JOB_ID
		,COUNT(*)
	FROM EMPLOYEES
GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
ORDER BY 1;




SELECT DEPARTMENT_ID
		,JOB_ID
		,COUNT(*)
		,  CASE WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 0 THEN '부서/직급별집계'
		 		WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 1 THEN '부서별집계'
		 		WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID) = 0 THEN '직급별집계'
		 		WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID) = 1 THEN '총집계'
		END AS 집계구분
	FROM EMPLOYEES
	WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
ORDER BY 1;


SELECT *
 FROM EMPLOYEES
WHERE DEPARTMENT_ID = 100
UNION ALL --합집합
SELECT *
 FROM EMPLOYEES
WHERE MANAGER_ID = 101;

SELECT *
 FROM EMPLOYEES
WHERE DEPARTMENT_ID = 100
UNION  --합집합
SELECT *
 FROM EMPLOYEES
WHERE MANAGER_ID = 101;

SELECT *
 FROM EMPLOYEES
WHERE DEPARTMENT_ID = 100
INTERSECT --교집합
SELECT *
 FROM EMPLOYEES
WHERE MANAGER_ID = 101;

SELECT *
 FROM EMPLOYEES
WHERE DEPARTMENT_ID = 100
MINUS --차집합
SELECT *
 FROM EMPLOYEES
WHERE MANAGER_ID = 101;

SELECT DEPARTMENT_ID
		,NULL AS JOB_ID
		,COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
UNION ALL
SELECT NULL AS DEPARTMENT_ID
	,JOB_ID
	,COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY JOB_ID;

SELECT DEPARTMENT_ID
	,JOB_ID
	,COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY GROUPING SETS(DEPARTMENT_ID,JOB_ID)
ORDER BY 1;






