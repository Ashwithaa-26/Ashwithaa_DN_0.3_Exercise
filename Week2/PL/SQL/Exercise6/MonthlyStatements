DECLARE
    CURSOR cur_transactions IS
        SELECT customer_id, account_id, transaction_date, amount
        FROM transactions
        WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM transaction_date) = EXTRACT(YEAR FROM SYSDATE);

    v_customer_id transactions.customer_id%TYPE;
    v_account_id transactions.account_id%TYPE;
    v_transaction_date transactions.transaction_date%TYPE;
    v_amount transactions.amount%TYPE;
BEGIN
    OPEN cur_transactions;
    LOOP
        FETCH cur_transactions INTO v_customer_id, v_account_id, v_transaction_date, v_amount;
        EXIT WHEN cur_transactions%NOTFOUND;

        -- Print statement for each transaction
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_transaction_date);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('------------------------');
    END LOOP;
    CLOSE cur_transactions;
END;
/
