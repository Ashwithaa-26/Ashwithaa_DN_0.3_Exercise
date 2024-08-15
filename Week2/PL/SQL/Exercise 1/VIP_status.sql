DECLARE
    CURSOR cur_customers IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000;
    v_customer_id customers.customer_id%TYPE;
BEGIN
    FOR rec IN cur_customers LOOP
        v_customer_id := rec.customer_id;
        
        UPDATE customers
        SET IsVIP = 'TRUE'
        WHERE customer_id = v_customer_id;
    END LOOP;
    COMMIT;
END;
/
