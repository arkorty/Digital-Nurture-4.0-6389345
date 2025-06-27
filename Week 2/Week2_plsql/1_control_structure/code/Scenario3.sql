DECLARE

    CURSOR c_due_loans IS
        SELECT
            L.LoanID,
            C.Name AS CustomerName,
            L.EndDate
        FROM
            Loans L
        JOIN
            Customers C ON L.CustomerID = C.CustomerID
        WHERE
            L.EndDate BETWEEN SYSDATE AND (SYSDATE + 30); 

    v_loan_id        Loans.LoanID%TYPE;
    v_customer_name  Customers.Name%TYPE;
    v_end_date       Loans.EndDate%TYPE;
    v_found_reminders BOOLEAN := FALSE;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Checking for loans due in the next 30 days...');

    OPEN c_due_loans;


    LOOP
        FETCH c_due_loans INTO v_loan_id, v_customer_name, v_end_date;
        EXIT WHEN c_due_loans%NOTFOUND;

        v_found_reminders := TRUE;


        DBMS_OUTPUT.PUT_LINE('--- LOAN REMINDER ---');
        DBMS_OUTPUT.PUT_LINE('Dear ' || v_customer_name || ',');
        DBMS_OUTPUT.PUT_LINE('Your Loan ID: ' || v_loan_id || ' is due on ' || TO_CHAR(v_end_date, 'YYYY-MM-DD') || '.');
        DBMS_OUTPUT.PUT_LINE('Please ensure timely repayment to avoid penalties.');
        DBMS_OUTPUT.PUT_LINE('---------------------');
    END LOOP;


    CLOSE c_due_loans;

    IF NOT v_found_reminders THEN
        DBMS_OUTPUT.PUT_LINE('No loans found due in the next 30 days.');
    END IF;

    DBMS_OUTPUT.PUT_LINE('Loan reminder process completed.');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
