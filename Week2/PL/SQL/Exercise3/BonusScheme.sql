CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) IS
    v_current_salary employees.salary%TYPE;
BEGIN
    -- Update salary by adding the bonus percentage
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department_id = p_department_id;

    COMMIT;
END UpdateEmployeeBonus;
/
