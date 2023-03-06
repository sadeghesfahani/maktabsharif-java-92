-- creating database
CREATE DATABASE maktab;


-- creating the table
CREATE TABLE persons (
                         person_id SERIAL PRIMARY KEY,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         gender CHAR(1) NOT NULL,
                         birthdate DATE NOT NULL,
                         score FLOAT NOT NULL,
                         mobile_number VARCHAR(20) NOT NULL
);

-- insert data
INSERT INTO persons (first_name, last_name, gender, birthdate, score, mobile_number)
VALUES
    ('Sina', 'Esfahani', 'M', '1990-05-15', 85.5, '09123456789'),
    ('Sina', 'Taghavizade', 'M', '1995-09-22', 5, '09123346788'),
    ('Armin', 'Farshbaf', 'M', '1987-02-03', 77.8, '09123456787'),
    ('Mina', 'Fattahi', 'F', '1992-11-18', 92.1, '09125356786'),
    ('Alireza', 'Khalife', 'M', '1994-06-27', 84.3, '09123456785'),
    ('Hannieh', 'Amini', 'F', '1996-12-01', 88.9, '09123456434'),
    ('Ahmadreza', 'Passandi', 'M', '2018-08-10', 9.6, '09123456783'),
    ('Elham', 'Rastpour', 'F', '1997-04-05', 95.0, '09123456782'),
    ('Reza', 'Mohammadi', 'M', '1993-01-29', 2.4, '09123456781'),
    ('Nazanin', 'Bonyadi', 'F', '2008-07-12', 91.7, '09123457880');


-- 1
SELECT * FROM persons WHERE first_name LIKE 'A%';

-- 2
SELECT * FROM persons WHERE last_name LIKE '%c';

-- 3
SELECT * FROM persons WHERE first_name LIKE '%b%' OR last_name LIKE '%b%';

-- 4
SELECT * FROM persons WHERE first_name LIKE '%m%' AND last_name LIKE '%m%';

-- 5
SELECT * FROM persons WHERE first_name LIKE '%b%' OR last_name LIKE '%b%' AND birthdate < DATE_TRUNC('year', NOW()) - INTERVAL '18 years';

-- 6
SELECT * FROM persons ORDER BY birthdate DESC LIMIT 1;

-- 7
SELECT * FROM persons ORDER BY birthdate LIMIT 1;

-- 8
SELECT AVG(EXTRACT(YEAR FROM AGE(NOW(), birthdate))) AS avg_age FROM persons;

-- 9
SELECT COUNT(*) FROM persons WHERE birthdate < DATE_TRUNC('year', NOW()) - INTERVAL '18 years';

-- 10
SELECT EXTRACT(YEAR FROM AGE(NOW(), birthdate)) AS age, COUNT(*) as count FROM persons GROUP BY age ORDER BY age;

-- 11
SELECT gender, AVG(EXTRACT(YEAR FROM AGE(NOW(), birthdate))) AS avg_age FROM persons GROUP BY gender;

-- 12
SELECT gender, COUNT(*) AS count FROM persons GROUP BY gender;

-- 13
SELECT EXTRACT(YEAR FROM AGE(NOW(), birthdate)) AS age, gender, AVG(score) AS avg_score
FROM persons
GROUP BY age, gender
ORDER BY age, gender;

-- 14
SELECT person_id, first_name, last_name, gender, birthdate,
       CASE WHEN score > 10 THEN 'passed' ELSE 'failed' END AS result
FROM persons;
