CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN employees.employee_id%TYPE,
    p_percentage IN NUMBER
) IS
    v_current_salary employees.salary%TYPE;
    ex_employee_not_found EXCEPTION;
BEGIN
    -- Check if the employee exists
    SELECT salary INTO v_current_salary
    FROM employees
    WHERE employee_id = p_employee_id;

    -- Update the salary
    UPDATE employees
    SET salary = salary + (v_current_salary * p_percentage / 100)
    WHERE employee_id = p_employee_id;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/
