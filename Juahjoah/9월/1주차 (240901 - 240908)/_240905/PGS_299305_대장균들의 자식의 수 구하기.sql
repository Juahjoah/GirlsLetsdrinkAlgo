-- 서브 쿼리로 COUNT로 세야하는 부모 별 각 자식의 ID를 출력함.
-- GROUP BY로는 해결할 수 없을까?

SELECT ID, COALESCE(EC.COUNT, 0) AS CHILD_COUNT
  FROM ECOLI_DATA
  -- 기존 테이블에 JOIN을 활용하여 서브쿼리 결과 값를 결합
  LEFT JOIN ( 
      -- PARENT_ID 별로 자식 개체 수를 집계
      SELECT PARENT_ID, COUNT(*) AS COUNT
      FROM ECOLI_DATA
      GROUP BY PARENT_ID
  ) AS EC
  ON ECOLI_DATA.ID = EC.PARENT_ID
  ORDER BY ECOLI_DATA.ID;


# 왜 COALESCE을 사용했는가?
    # COALESCE는 NULL을 다른 값으로 대체하는 함수. 여기서는 자식이 없는 부모의 경우 COUNT가 NULL이 되기 때문에 0으로 대체해주는 것!
# COALESCE와 ISNULL, NVL의 차이점은 무엇인가?
    # COALESCE는 ANSI 표준 SQL 함수
    # COALESCE는 인수 목록에서 첫 번째 NULL이 아닌 값을 반환
        # 범용성과 호환성: 다양한 데이터베이스 시스템에서 사용할 수 있으며, SQL 표준을 따름.
        # 유연성: 두 개 이상의 인자를 받을 수 있으며, 첫 번째 NULL이 아닌 값을 반환.
    # IFNULL은 MySQL과 같은 일부 시스템에서 사용
    # NVL은 Oracle에서 사용
    # ISNULL은 SQL Server에서 사용되는 함수



-- 1차 시도 답안
# SELECT ID, 
#   (SELECT COUNT(ISNULL(PARENT_ID, 0)) AS CHILD_COUNT
#      FROM ECOLI_DATA AS ED
#     WHERE ED.PARENT_ID = ECOLI_DATA.ID
#     GROUP BY PARENT_ID
#    )
#   FROM ECOLI_DATA
#   ORDER BY ID;