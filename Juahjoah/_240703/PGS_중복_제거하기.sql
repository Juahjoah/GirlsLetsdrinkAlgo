-- 중복, NULL 값 제거 하기
-- SELECT DISTINCT COUNT(ANIMAL_ID) AS COUNT
SELECT COUNT(DISTINCT NAME) AS COUNT
  FROM ANIMAL_INS;

-- COUNT 함수는 동일하게 사용하지만, Null을 제외하기 위해서는 원하는 컬럼명을 정확하게 지정해야 한다.
-- DISTINCT는 중복을 제거하는 역할을 한다. 다만, 중복을 제거할 때는 NULL 값도 중복으로 간주한다.
  -- DISTINCT : 중복을 없애주지만 정렬을 하지는 않는다.
  -- GROUP BY : 중복을 없애주고 정렬도 해준다.