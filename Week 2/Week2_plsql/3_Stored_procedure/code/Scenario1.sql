CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    CURSOR c_savings_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings';

    v_account_id    Accounts.AccountID%TYPE;
    v_current_balance Accounts.Balance%TYPE;
    v_interest_rate CONSTANT NUMBER := 0.01; 
    v_new_balance   Accounts.Balance%TYPE;
    v_rows_updated  NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Starting monthly interest processing for savings accounts...');

    OPEN c_savings_accounts;
    LOOP
        FETCH c_savings_accounts INTO v_account_id, v_current_balance;
        EXIT WHEN c_savings_accounts%NOTFOUND;

        v_new_balance := v_current_balance * (1 + v_interest_rate);

        UPDATE Accounts
        SET Balance = v_new_balance,
            LastModified = SYSDATE
        WHERE AccountID = v_account_id;

        v_rows_updated := v_rows_updated + SQL%ROWCOUNT;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' - Old Balance: ' || v_current_balance || ', New Balance: ' || ROUND(v_new_balance, 2));
    END LOOP;
    CLOSE c_savings_accounts;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest process completed. Total savings accounts updated: ' || v_rows_updated);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred during monthly interest processing: ' || SQLERRM);
END ProcessMonthlyInterest;
/
