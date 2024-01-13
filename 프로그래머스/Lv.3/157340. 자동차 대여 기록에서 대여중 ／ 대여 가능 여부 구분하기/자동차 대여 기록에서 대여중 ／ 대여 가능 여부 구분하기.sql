-- 코드를 입력하세요

# SELECT CAR_ID,
# case when START_DATE<='2022-10-16' and END_DATE>='2022-10-16' then '대여중'
#     else '대여가능'
#     end as AVAILABILITY
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by 1 DESC
# group by 1

# select car_id,
# case when 
# CASE WHEN CAR_ID IN 
#         (SELECT CAR_ID
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16')
#     THEN '대여중'
#     ELSE '대여 가능'
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY T1
# group by CAR_ID
# ORDER by CAR_ID

SELECT DISTINCT(CAR_ID),
    CASE WHEN CAR_ID IN 
            (SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16')
        THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID DESC;