-- LEFT, RIGHT JOIN 구분하기


SELECT A_OUT.ANIMAL_ID, A_OUT.NAME
--   FROM ANIMAL_OUTS AS A_OUT JOIN ANIMAL_INS AS A_IN ON A_IN.ANIMAL_ID = A_OUT.ANIMAL_ID
  FROM ANIMAL_OUTS AS A_OUT LEFT JOIN ANIMAL_INS AS A_IN ON A_IN.ANIMAL_ID = A_OUT.ANIMAL_ID
  WHERE A_IN.ANIMAL_ID IS NULL
  ORDER BY A_OUT.ANIMAL_ID;


-- LEFT JOIN은 왼쪽(첫 번째) 테이블의 모든 행을 반환하고, 오른쪽(두 번째) 테이블에서 일치하는 행이 있으면 그 값을 가져옴.
-- 만약 일치하는 값이 없다면 NULL로 반환함.

-- RIGHT JOIN은 오른쪽(두 번째) 테이블의 모든 행을 반환하고, 왼쪽(첫 번째) 테이블에서 일치하는 행이 있으면 그 값을 가져옴.
-- 만약 일치하는 값이 없다면 NULL로 반환함.

-- INNER JOIN은 두 테이블에서 일치하는 행만 반환함.

-- 현재 문제는 입양 기록은 있지만 보호소에 들어온 기록이 없는 동물을 찾는 것이 목표 = ANIMAL_OUTS 테이블에 존재하지만 ANIMAL_INS 테이블에는 없는 동물을 조회
-- 만약 RIGHT JOIN을 사용하면 ANIMAL_INS 테이블의 모든 데이터를 기준으로 하게 되므로, 보호소에 들어온 기록이 없는 동물을 찾는 것이 아니라, 입양된 기록이 없는 동물을 찾는 쿼리가 됨.