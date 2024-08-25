-- 코드를 입력하세요
-- FOOD_PRODUCT : 식품의 정보를 담음 (중복 X)
-- 식품 ID, 식품 이름, 식품코드, 식품분류, 식품 가격
-- FOOD_ORDER : 식품의 주문 정보를 담음 (중복 O)
-- 주문 ID, 제품 ID, 주문량, 생산일자, 입고일자, 출고일자, 공장 ID, 창고 ID
# SELECT FD.식품ID, FD.식품 이름, 총매출
# WHERE 생산일자 2022년 5월
# ORDER BY 총매출 내림차순, 식품 ID 오름차순
-- JOIN 
-- ON 식품ID = 제품ID
-- 총매출? 

SELECT FD.PRODUCT_ID, FD.PRODUCT_NAME,FD.PRICE * FO.AMOUNT AS TOTAL_SALES
FROM FOOD_PRODUCT AS FD
JOIN (SELECT PRODUCT_ID, AMOUNT 
FROM FOOD_ORDER
WHERE DATE_FORMAT(PRODUCE_DATE, "%Y-%m") = '2022-05') AS FO
ON FD.PRODUCT_ID = FO.PRODUCT_ID
GROUP BY FD.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, FD.PRODUCT_ID