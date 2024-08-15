CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    CURSOR cur_savings_accounts IS
        SELECT account_id, balance
        FROM accounts
        WHERE account_type = 'Savings';
    v_account_id accounts.account_id%TYPE;
    v_balance accounts.balance%TYPE;
    v_interest_amount NUMBER;
BEGIN
    FOR rec IN cur_savings_accounts LOOP
        v_account_id := rec.account_id;
        v_balance := rec.balance;

        -- Calculate 1% interest
        v_interest_amount := v_balance * 0.01;

        -- Update the account balance
        UPDATE accounts
        SET balance = balance + v_interest_amount
        WHERE account_id = v_account_id;
    END LOOP;

    COMMIT;
END ProcessMonthlyInterest;
/
