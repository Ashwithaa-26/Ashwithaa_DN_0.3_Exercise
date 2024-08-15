DECLARE
    CURSOR cur_customers IS
        SELECT customer_id, age, loan_interest_rate
        FROM customers
        WHERE age > 60;
    v_customer_id customers.customer_id%TYPE;
    v_loan_interest_rate customers.loan_interest_rate%TYPE;
BEGIN
    FOR rec IN cur_customers LOOP
        v_customer_id := rec.customer_id;
        v_loan_interest_rate := rec.loan_interest_rate - 1; -- Applying 1% discount
        
        UPDATE customers
        SET loan_interest_rate = v_loan_interest_rate
        WHERE customer_id = v_customer_id;
    END LOOP;
    COMMIT;
END;
/
