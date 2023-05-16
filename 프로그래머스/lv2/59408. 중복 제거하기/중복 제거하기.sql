-- 코드를 입력하세요
# SELECT COUNT(DISTINCT NAME)
# FROM ANIMAL_INS
# WHERE NAME IS NOT NULL 

# SELECT COUNT(NAME)
# FROM (SELECT NAME FROM ANIMAL_INS GROUP BY NAME) AS A
# WHERE NAME IS NOT NULL

SELECT COUNT(*)
FROM (SELECT DISTINCT NAME
			FROM ANIMAL_INS) AS A
WHERE NAME IS NOT NULL
