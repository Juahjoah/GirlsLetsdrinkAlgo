SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수
  FROM APPOINTMENT
  WHERE APNT_YMD LIKE "2022-05-%"
  GROUP BY MCDP_CD
  ORDER BY 5월예약건수, 진료과코드;


'''
SELECT MCDP_CD AS "진료과코드", COUNT(*) AS "5월예약건수"
  FROM APPOINTMENT
  WHERE APNT_YMD LIKE "2022-05-%"
  GROUP BY MCDP_CD
  ORDER BY "5월예약건수", "진료과코드";
'''

-- 큰따옴표(")는 MySQL에서 문자열 리터럴로 인식될 수 있기 때문에, 원하는 대로 컬럼별칭을 지정하지 못하고 오류가 발생할 수 있음. 
  -- 문자열 리터럴 : '문자열' 또는 "문자열"로 표현되는 문자열
-- MySQL에서 별칭을 사용할 때는 큰따옴표(") 대신 작은따옴표(')나 백틱(`)을 사용하는 것이 좋음.