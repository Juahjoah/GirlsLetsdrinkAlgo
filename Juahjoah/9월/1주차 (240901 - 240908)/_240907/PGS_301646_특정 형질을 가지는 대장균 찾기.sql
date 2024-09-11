-- 개체의 형질을 이진수로 변환해 갖고 있는 형질을 확인

-- 1) CONV 함수와 SUBSTRING 함수를 사용 확인
SELECT COUNT(*) AS COUNT
  FROM ECOLI_DATA
 WHERE (
     SUBSTRING(CONV(GENOTYPE, 10, 2), -1, 1) = 1 OR    -- 뒤에서 1번째 자리의 값이 1인 경우 : 1번 형질을 갖고 있음
     SUBSTRING(CONV(GENOTYPE, 10, 2), -3, 1) = 1       -- 뒤에서 3번째 자리의 값이 1인 경우 : 3번 형질을 갖고 있음 
 ) AND
       SUBSTRING(CONV(GENOTYPE, 10, 2), -2, 1) = 0;    -- 뒤에서 2번째 자리의 값이 0인 경우 : 2번 형질을 갖고 있지 않음

-- 2) LIKE를 활용해 이진수 상태의 값을 확인
SELECT COUNT(*) AS COUNT
  FROM ECOLI_DATA
 WHERE (
     CONV(GENOTYPE, 10, 2) LIKE "%1" OR
     CONV(GENOTYPE, 10, 2) LIKE "%100"
 ) AND
       CONV(GENOTYPE, 10, 2) NOT LIKE "%11";

-- 3) 비트연산자 활용
SELECT COUNT(*) AS COUNT
  FROM ECOLI_DATA
 WHERE ( GENOTYPE & 1 = 1 OR
         GENOTYPE & 4 = 4
        ) AND
        GENOTYPE & 2 = 0;

```
-- CONV 함수 : CONV(N, from_base, to_base) : N을 from_base로 변환한 후 to_base로 변환
-- SUBSTRING 함수 : SUBSTRING(str, pos, len) : str에서 pos 위치부터 len 길이만큼의 문자열을 반환
-- 비트연산자 : & (AND), | (OR), ^ (XOR), ~ (NOT) : 비트단위 연산자
    -- 1. 비트 AND (&): 두 이진수를 비교하여 둘 다 1인 비트에 대해 1을 반환
        -- 예: 1011 & 1101 = 1001
    -- 2. 비트 OR (|): 두 이진수 중 하나라도 1인 비트에 대해 1을 반환
        -- 예: 1011 | 1101 = 1111
    -- 3. 비트 XOR (^): 두 이진수의 비트가 다를 경우 1을 반환
        -- 예: 1011 ^ 1101 = 0110
    -- 4. 비트 NOT (~): 모든 비트를 반전 (1은 0으로, 0은 1로).
        -- 예: ~1011 (이진수 표현에 따라 다를 수 있음)
    -- 5. 비트 시프트:
        -- a. 왼쪽 시프트 (<<): 모든 비트를 왼쪽으로 지정된 수만큼 이동, 오른쪽은 0으로 채움.
        --    왼쪽 시프트는 값을 2의 지정 제곱만큼 곱하는 효과
        -- b. 오른쪽 시프트 (>>): 모든 비트를 오른쪽으로 지정된 수만큼 이동, 왼쪽은 최상위 비트(부호 비트)의 복사본이나 0으로 채워짐.
        --    오른쪽 시프트는 값을 2의 지정 제곱으로 나누는 효과
  
```
