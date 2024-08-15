CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN accounts.account_id%TYPE,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance accounts.balance%TYPE;
BEGIN
    -- Retrieve the balance for the given account
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;

    -- Check if the balance is sufficient
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/
