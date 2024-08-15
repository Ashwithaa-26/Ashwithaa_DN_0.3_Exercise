DECLARE
    CURSOR cur_loans IS
        SELECT loan_id, interest_rate
        FROM loans;

    v_loan_id loans.loan_id%TYPE;
    v_interest_rate loans.interest_rate%TYPE;
    v_new_interest_rate NUMBER;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN cur_loans%NOTFOUND;

        -- Determine new interest rate based on policy (example: increase by 0.5%)
        v_new_interest_rate := v_interest_rate + 0.5;

        -- Update the loan interest rate
        UPDATE loans
        SET interest_rate = v_new_interest_rate
        WHERE loan_id = v_loan_id;

        -- Output the update
        DBMS_OUTPUT.PUT_LINE('Updated Interest Rate for Loan ID: ' || v_loan_id);
    END LOOP;
    CLOSE cur_loans;

    COMMIT;
END;
/
