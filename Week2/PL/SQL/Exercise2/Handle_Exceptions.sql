CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN accounts.account_id%TYPE,
    p_to_account_id IN accounts.account_id%TYPE,
    p_amount IN NUMBER
) IS
    ex_insufficient_funds EXCEPTION;
    v_balance_from accounts.balance%TYPE;
BEGIN
    -- Check if the source account has enough balance
    SELECT balance INTO v_balance_from
    FROM accounts
    WHERE account_id = p_from_account_id
    FOR UPDATE;

    IF v_balance_from < p_amount THEN
        RAISE ex_insufficient_funds;
    END IF;

    -- Deduct the amount from the source account
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    -- Add the amount to the destination account
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    COMMIT;

EXCEPTION
    WHEN ex_insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/
