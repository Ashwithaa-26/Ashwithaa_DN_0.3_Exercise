CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN customers.customer_id%TYPE,
    p_name IN customers.name%TYPE,
    p_age IN customers.age%TYPE,
    p_balance IN customers.balance%TYPE
) IS
    ex_customer_exists EXCEPTION;
BEGIN
    -- Check if the customer already exists
    DECLARE
        v_existing_customer_id customers.customer_id%TYPE;
    BEGIN
        SELECT customer_id INTO v_existing_customer_id
        FROM customers
        WHERE customer_id = p_customer_id;

        RAISE ex_customer_exists;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            -- Continue with insertion if customer does not exist
            NULL;
    END;

    -- Insert the new customer
    INSERT INTO customers (customer_id, name, age, balance)
    VALUES (p_customer_id, p_name, p_age, p_balance);

    COMMIT;

EXCEPTION
    WHEN ex_customer_exists THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/
