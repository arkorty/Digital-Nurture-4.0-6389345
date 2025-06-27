CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department       IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER 
)
IS
    v_rows_updated NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Starting bonus update for ' || p_department || ' department with ' || (p_bonus_percentage * 100) || '% bonus...');

    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage)
    WHERE Department = p_department;

    v_rows_updated := SQL%ROWCOUNT;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update completed. Total employees updated in ' || p_department || ' department: ' || v_rows_updated);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred during employee bonus update: ' || SQLERRM);
END UpdateEmployeeBonus;
/