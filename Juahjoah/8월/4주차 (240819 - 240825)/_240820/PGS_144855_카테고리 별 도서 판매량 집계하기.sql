-- 카테고리 별 도서 판매량 집계하기

-- JOIN으로 테이블을 합치는 것을 우선적으로 생각

SELECT A.CATEGORY, SUM(SALES) AS TOTAL_SALES
  FROM BOOK AS A JOIN BOOK_SALES AS B ON A.BOOK_ID = B.BOOK_ID
  WHERE B.SALES_DATE LIKE "2022-01-%"
  GROUP BY A.CATEGORY
  ORDER BY CATEGORY ASC;

-- GROUP BY : 그룹화할 열을 지정해 그룹화
  --  GROUP BY 구문은 특정 열의 값에 따라 행들을 그룹화하여 집계 함수(SUM(), COUNT(), AVG() 등)를 적용할 때 사용
  --  GROUP BY 구문을 사용하면 특정 열의 값이 같은 행들을 하나로 묶어 집계 함수를 적용
    --  GROUP BY 구문은 SELECT 구문의 마지막에 위치하며, WHERE 구문 다음에 사용
