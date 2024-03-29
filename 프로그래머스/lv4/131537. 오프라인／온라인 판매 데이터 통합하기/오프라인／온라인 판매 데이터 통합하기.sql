-- 코드를 입력하세요
# SELECT DISTINCT DATE_FORMAT(O.SALES_DATE, '%Y-%m') AS SALES_DATE, F.PRODUCT_ID, CASE WHEN O.USER_ID THEN O.USER_ID ELSE "NULL" END AS USER_ID, O.SALES_AMOUNT
# FROM OFFLINE_SALE F
# JOIN ONLINE_SALE O
# WHERE '2022-03'=DATE_FORMAT(O.SALES_DATE, '%Y-%m')
# ORDER BY SALES_DATE, PRODUCT_ID, USER_ID

# SELECT DATE_FORMAT(O.SALES_DATE, '%Y-%m') AS SALES_DATE, F.PRODUCT_ID, USER_ID, F.SALES_AMOUNT
# FROM OFFLINE_SALE F
# LEFT OUTER JOIN ONLINE_SALE O ON F.PRODUCT_ID=O.PRODUCT_ID
# WHERE '2022-03'=DATE_FORMAT(O.SALES_DATE, '%Y-%m')
# ORDER BY SALES_DATE, PRODUCT_ID, USER_ID

(SELECT DATE_FORMAT(O.SALES_DATE, '%Y-%m-%d') AS SALES_DATE, O.PRODUCT_ID, USER_ID, O.SALES_AMOUNT
FROM ONLINE_SALE O
WHERE '2022-03'=DATE_FORMAT(O.SALES_DATE, '%Y-%m'))

UNION ALL

(SELECT DATE_FORMAT(F.SALES_DATE, '%Y-%m-%d') AS SALES_DATE, F.PRODUCT_ID, NULL AS USER_ID, F.SALES_AMOUNT
FROM OFFLINE_SALE F
WHERE '2022-03'=DATE_FORMAT(F.SALES_DATE, '%Y-%m'))
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID