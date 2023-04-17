CREATE TABLE PROJECT
(
	ID INT NOT NULL PRIMARY KEY,
    DEPT VARCHAR(100) NOT NULL,
    CITY VARCHAR(100),
    NUMBER INT
)
/
CREATE TABLE EMPLOYEEDATA
(
	ID INT NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100),
    PHONE INT,
    ADDRESS INT NOT NULL,
    CONSTRAINT EMPLOYEEDATA_FK FOREIGN KEY(ADDRESS) REFERENCES PROJECT(ID)
)
/

CREATE TABLE example1
(
	ID INT NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100),
    PHONE INT,
    ADDRESS INT NOT NULL,
    CONSTRAINT EMPLOYEEDATA_FK FOREIGN KEY(ADDRESS) REFERENCES PROJECT(ID)
)
/