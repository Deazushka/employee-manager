insert into profession (Prf_Id, Prf_Profession, Prf_Salary) values
(1, 'Programmer', 20),
(2, 'Manager', 30),
(3, 'Lead Manager', 20),
(4, 'Designer', 30),
(5, 'Manager', 20),
(6, 'Lead Manager', 30),
(7, 'Top Leader', 20);

insert into department (Dep_Id, Dep_Name) values
(1,'IT'),
(2,'HR');

insert into employee (Emp_Id, Emp_Name, Emp_Passport_Number, Emp_Department, Emp_Profession, Emp_Bonus) values
(1, 'Ranga', 'E1234567', 1, 1, 5),
(2,  'Ravi', 'A1234568', 2, 2, 6),
(3, 'Agnesh', 'HB30872', 1, 3, 7),
(4, 'Boris', 'HB14242', 2, 4, 8),
(5, 'Rosa', 'BT231455', 1, 5, 9),
(6, 'Simon', 'M515122', 2, 6, 10),
(7, 'Greg', 'SA148812', 1, 7, 11);

insert into vacation (Vac_Employee, Vac_Date_From, Vac_Date_To, Vac_Approved_By) values
(1, '2018-01-21', '2018-01-22', 3),
(2, '2018-01-22', '2018-01-23', 7),
(3, '2018-01-23', '2018-01-24', 6),
(4, '2018-01-24', '2018-01-25', 3),
(5, '2018-01-22', '2018-01-23', 7),
(6, '2018-01-23', '2018-01-24', 6),
(7, '2018-01-24', '2018-01-25', 3);