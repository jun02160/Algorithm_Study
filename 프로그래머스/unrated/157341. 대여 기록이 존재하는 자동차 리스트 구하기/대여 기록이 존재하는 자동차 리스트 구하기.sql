-- 코드를 입력하세요
SELECT DISTINCT CAR_RENTAL_COMPANY_CAR.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ON SUBSTR(START_DATE, 6, 2)="10"
WHERE CAR_TYPE="세단" AND CAR_RENTAL_COMPANY_CAR.CAR_ID = CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID
ORDER BY CAR_ID DESC