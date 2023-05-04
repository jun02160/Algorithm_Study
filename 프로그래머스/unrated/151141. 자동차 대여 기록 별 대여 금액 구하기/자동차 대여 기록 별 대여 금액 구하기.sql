-- 코드를 입력하세요
SELECT HISTORY_ID, (DATEDIFF(END_DATE, START_DATE)+1)*ROUND((DAILY_FEE * (CASE 
                                                                         WHEN DATEDIFF(END_DATE, START_DATE)+1 < 7 THEN 1
                                                                         WHEN DATEDIFF(END_DATE, START_DATE)+1 < 30 THEN 0.95
                                                                         WHEN DATEDIFF(END_DATE, START_DATE)+1 < 90 THEN 0.92
                                                                         ELSE 0.85 END))) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID=C.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE=P.CAR_TYPE
WHERE P.CAR_TYPE='트럭' 
GROUP BY HISTORY_ID
ORDER BY FEE DESC, HISTORY_ID DESC