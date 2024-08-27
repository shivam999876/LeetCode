# Write your MySQL query statement below
Select distinct customer_id, COUNT(DISTINCT visit_id) as count_no_trans
FROM Visits
where visit_id not in (
    SELECT visit_id FROM transactions
)
GROUP BY customer_id