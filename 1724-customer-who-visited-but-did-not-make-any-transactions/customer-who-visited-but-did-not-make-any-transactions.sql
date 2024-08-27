# Write your MySQL query statement below
SELECT customer_id, COUNT(*) AS count_no_trans
FROM Visits v
WHERE NOT EXISTS(
    SELECT 1
    FROM Transactions t
    WHERE v.visit_id = t.visit_id
)
GROUP BY v.customer_id;
