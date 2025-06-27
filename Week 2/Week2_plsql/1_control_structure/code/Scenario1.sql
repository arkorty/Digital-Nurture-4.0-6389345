DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB
        FROM Customers;

    v_customer_id   Customers.CustomerID%TYPE;
    v_dob           Customers.DOB%TYPE;
    v_age_years     NUMBER;
    v_rows_updated  NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Starting loan interest rate discount process...');

    OPEN c_customers;

    LOOP
        FETCH c_customers INTO v_customer_id, v_dob;
        EXIT WHEN c_customers%NOTFOUND;

        v_age_years := TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || ', DOB: ' || TO_CHAR(v_dob, 'YYYY-MM-DD') || ', Age: ' || v_age_years);

        IF v_age_years >= 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;

            v_rows_updated := SQL%ROWCOUNT;

            IF v_rows_updated > 0 THEN
                DBMS_OUTPUT.PUT_LINE('  --> Discount applied for Customer ID: ' || v_customer_id || '. Loans updated: ' || v_rows_updated);
            ELSE
                DBMS_OUTPUT.PUT_LINE('  --> Customer ID: ' || v_customer_id || ' is 60 or older but has no loans to update.');
            END IF;
        END IF;
    END LOOP;

    CLOSE c_customers;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rate discount process completed and changes committed.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE('Changes rolled back.');
END;
/
