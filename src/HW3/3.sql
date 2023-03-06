CREATE DATABASE company;


CREATE TABLE Employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          department VARCHAR(100) NOT NULL,
                          salary NUMERIC(10, 2) NOT NULL
);


-- 1
INSERT INTO Employee (name, department, salary)
VALUES ('Mia Johnson', 'Marketing', 67000),
	 ('James Wilson', 'Sales', 52000),
	 ('Linda Garcia', 'Marketing', 62000),
	 ('Anthony Rodriguez', 'Engineering', 83000),
	 ('Elizabeth Martinez', 'Sales', 47000),
	 ('Kevin Lee', 'Marketing', 72000),
	 ('Ava Hernandez', 'Engineering', 78000),
	 ('Samuel Davis', 'Finance', 91000),
	 ('Sophia Wilson', 'Human Resources', 53000),
	 ('Benjamin Brown', 'Information Technology', 87000);


-- 2
SELECT department, AVG(salary) AS avg_salary
FROM Employee
GROUP BY department;

-- 3
SELECT department, name, salary
FROM Employee
WHERE (department, salary) IN (
    SELECT department, MAX(salary)
    FROM Employee
    GROUP BY department
);


-- 4
SELECT name, department, salary
FROM Employee
WHERE salary < (
    SELECT AVG(salary)
    FROM Employee
);
