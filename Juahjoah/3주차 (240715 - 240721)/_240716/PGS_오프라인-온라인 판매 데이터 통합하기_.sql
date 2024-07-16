-- 오프라인/온라인 판매 데이터 통합하기

-- 테이블을 합치는 경우, JOIN을 우선적으로 생각해 문제를 풀었다.
-- JOIN을 사용하면 두 테이블을 합칠 수 있으나, 이 경우에는 테이블의 구조가 다르기 때문에 UNION을 사용해야 한다.

-- 온라인 판매 데이터 선택
SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
  -- FROM A.ONLINE_SALE JOIN B.OFFLINE_SALE ON A.PRODUCT_ID
  FROM ONLINE_SALE
  WHERE SALES_DATE LIKE "2022-03-%"
  UNION ALL
-- 오프라인 판매 데이터 선택, USER_ID는 NULL로 표시
SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
  FROM OFFLINE_SALE
  WHERE SALES_DATE LIKE "2022-03-%"
  
  ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;


-- JOIN : 새로운 열로 결합한다. (수평결합)
-- UNION : 새로운 행으로 결합한다. (수직결합)
-- UNION ALL : 중복을 제거하지 않고 모든 행을 결합한다.


-- 트러블 슈팅
  -- Unknown column 'SALES_DATE' in 'order clause'
  -- DATE_FORMAT을 활용해 날짜 형식을 변경했더니, 해당 오류가 발생했다.
  -- ORDER BY 구문에서 SALES_DATE 컬럼을 찾을 수 없다는 것을 나타낸다.
    -- DATE_FORMAT 함수를 사용하여 날짜 형식을 변경하면서, 해당 결과 컬럼의 이름을 명시적으로 지정하지 않았기 때문이다.

  -- ORDER BY 절에는 SELECT 절에서 사용한 열 이름만 사용할 수 있다.
    -- SELECT 절에서 사용한 열 이름이 아닌 다른 열 이름을 사용하면 오류가 발생한다.
    -- DATE_FORMAT 함수를 사용하여 날짜 형식을 변경하면서, 해당 결과 컬럼의 이름을 명시적으로 지정하지 않았기 때문이다.
-- SELECT 절에서 사용한 열 이름을 사용하지 않고 다른 열 이름을 사용하려면 별칭을 사용해야 한다.