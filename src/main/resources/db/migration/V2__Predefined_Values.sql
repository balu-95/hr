--Insert predefined values into Department table
Insert into Department (DepartmentName) values
('Engineering'),
('Human Resources'),
('Sales'),
('Marketing'),
('Finance');


--Insert predefined values into Location table
Insert into Location (LocationName) values
('New york'),
('San Fransico'),
('Austin'),
('Chicago'),
('Los Angels');


--Insert Predefined values into JobRole table
Insert into JobRole (RoleName, RoleDescription, SalaryRange, Responsibilities, Requirements, Benefits) values
('Software Engineer', 'Develop and maintain software applications.', '80k-120k', 'Coding, Testing, Reviewing', 'Bachelor''s degree in CS or related field', 'Health insurance, 401k'),
('HR Manager', 'Manage HR activities and personnel.', '60k-90k', 'Recruiting, Employee Relations', 'Bachelor''s degree in HR or related field', 'Health insurance, 401k'),
('Sales Representative', 'Drive sales and manage client relationships.', '50k-70k', 'Selling, Client Management', 'Bachelor''s degree in Business or related field', 'Health insurance, 401k'),
('Marketing Coordinator', 'Assist in the execution of marketing campaigns.', '40k-60k', 'Campaign planning, Content creation', 'Bachelor''s degree in Marketing or related field', 'Health insurance, 401k'),
('Financial Analyst', 'Analyze financial data and create reports.', '60k-80k', 'Financial modeling, Forecasting', 'Bachelor''s degree in Finance or related field', 'Health insurance, 401k');


-- Insert predefined values into ApplicationStatus table
Insert into ApplicationStatus (StatusName) values 
('Applied'), 
('In Review'), 
('Interview Scheduled'), 
('Offered'), 
('Rejected'),
('Withdrawn'),
('Hired');