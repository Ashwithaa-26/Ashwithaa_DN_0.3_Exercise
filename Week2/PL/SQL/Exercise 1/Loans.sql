DECLARE
    CURSOR cur_loans IS
        SELECT l.loan_id, c.customer_id, c.name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
    v_loan_id loans.loan_id%TYPE;
    v_customer_id customers.customer_id%TYPE;
    v_customer_name customers.name%TYPE;
    v_due_date loans.due_date%TYPE;
BEGIN
    FOR rec IN cur_loans LOOP
        v_loan_id := rec.loan_id;
        v_customer_id := rec.customer_id;
        v_customer_name := rec.name;
        v_due_date := rec.due_date;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name || ', your loan (ID: ' || v_loan_id || ') is due on ' || TO_CHAR(v_due_date, 'DD-MON-YYYY') || '. Please ensure timely payment.');
    END LOOP;
END;
/
