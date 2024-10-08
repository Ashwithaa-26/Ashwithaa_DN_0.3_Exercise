CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_number_of_payments NUMBER;
    v_monthly_installment NUMBER;
BEGIN
    -- Convert annual interest rate to a monthly rate (in decimal form)
    v_monthly_rate := p_interest_rate / 12 / 100;

    -- Calculate the total number of monthly payments
    v_number_of_payments := p_duration_years * 12;

    -- Calculate the monthly installment using the formula for an amortizing loan
    v_monthly_installment := p_loan_amount * v_monthly_rate /
                            (1 - POWER(1 + v_monthly_rate, -v_number_of_payments));
    
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
