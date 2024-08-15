DECLARE
    CURSOR cur_accounts IS
        SELECT account_id, balance
        FROM accounts;

    v_account_id accounts.account_id%TYPE;
    v_balance accounts.balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Example fee amount
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_account_id, v_balance;
        EXIT WHEN cur_accounts%NOTFOUND;

        -- Deduct the annual fee
        UPDATE accounts
        SET balance = balance - v_annual_fee
        WHERE account_id = v_account_id;

        -- Output the update
        DBMS_OUTPUT.PUT_LINE('Annual fee applied to Account ID: ' || v_account_id);
    END LOOP;
    CLOSE cur_accounts;

    COMMIT;
END;
/
