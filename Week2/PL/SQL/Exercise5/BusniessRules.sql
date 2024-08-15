CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance accounts.balance%TYPE;
BEGIN
    -- Retrieve the current balance for the account
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = :NEW.account_id
    FOR UPDATE;

    -- Ensure that the withdrawal does not exceed the balance
    IF :NEW.amount < 0 THEN
        IF ABS(:NEW.amount) > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal.');
        END IF;
    END IF;

    -- Ensure that deposits are positive
    IF :NEW.amount > 0 THEN
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END CheckTransactionRules;
/
