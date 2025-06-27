ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'NO';


/*Pl/SQL block*/

DECLARE
    CURSOR c_customers_balance IS
        SELECT CustomerID, Balance
        FROM Customers;

    v_customer_id   Customers.CustomerID%TYPE;
    v_balance       Customers.Balance%TYPE;
    v_update_count  NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Starting VIP customer promotion process...');

    OPEN c_customers_balance;

    LOOP
        FETCH c_customers_balance INTO v_customer_id, v_balance;
        EXIT WHEN c_customers_balance%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Processing Customer ID: ' || v_customer_id || ', Balance: ' || v_balance);

        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'YES'
            WHERE CustomerID = v_customer_id;
            v_update_count := v_update_count + SQL%ROWCOUNT;
            DBMS_OUTPUT.PUT_LINE('  --> Customer ID: ' || v_customer_id || ' promoted to VIP status.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'NO'
            WHERE CustomerID = v_customer_id
            AND IsVIP <> 'NO';
            IF SQL%ROWCOUNT > 0 THEN
                DBMS_OUTPUT.PUT_LINE('  --> Customer ID: ' || v_customer_id || ' set to non-VIP status.');
            END IF;
        END IF;
    END LOOP;

    CLOSE c_customers_balance;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP customer promotion process completed. Total VIPs updated: ' || v_update_count);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE('Changes rolled back.');
END;
/
