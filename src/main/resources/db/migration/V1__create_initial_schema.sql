-- CREATE Department TABLE
CREATE TABLE Department (
   DepartmentId SERIAL PRIMARY KEY,
   DepartmentName VARCHAR(255) NOT NULL
 ); 
 
 --CREATE Location TABLE
 CREATE TABLE Location (
    LocationId SERIAL PRIMARY KEY,
    LocationName VARCHAR(255) NOT NULL
 );
 
 --CREATE JobRole TABLE
 CREATE TABLE JobRole (
    RoleId SERIAL PRIMARY KEY,
    RoleName VARCHAR(255) NOT NULL,
    RoleDescription TEXT,
    SalaryRange VARCHAR(255),
    Responsibilities TEXT,
    Requirements TEXT,
    Benefits TEXT
 );
 
 --CREATE JobPackage TABLE
 CREATE TABLE JobPackage (
    PackageId SERIAL PRIMARY KEY,
    RoleId INT NOT NULL,
    DepartmentId INT NOT NULL,
    LocationId INT NOT NULL,
    CONSTRAINT fk_package_role FOREIGN KEY (RoleId) REFERENCES JobRole(RoleId),
    CONSTRAINT fk_package_department FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId),
    CONSTRAINT fk_package_location FOREIGN KEY (LocationId) REFERENCES Location(LocationId)
 );
 
 
 --CREATE JobOpenig TABLE
 CREATE TABLE JobOpening (
    OpeningId SERIAL PRIMARY KEY,
    PackageId INT NOT NULL,
    PostingDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ClosingDate TIMESTAMP,
    CustomTitle VARCHAR(255),
    CustomDescription TEXT,
    CustomSalary VARCHAR(255),
    CustomBenefits TEXT,
    CONSTRAINT fk_opening_package FOREIGN KEY (PackageId) REFERENCES JobPackage(PackageId)
 );
 
 --CREATE Employee TABLE
 CREATE TABLE Employee (
    EmployeeId SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    DepartmentId INT NOT NULL,
    CONSTRAINT fk_employee_department FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
);

--CREATE Candidate TABLE
CREATE TABLE Candidate (
   CandidateId SERIAL PRIMARY KEY,
   Name VARCHAR(255) NOT NULL,
   Email VARCHAR(255) NOT NULL,
   MobileNumber VARCHAR(15),
   Resume TEXT
 );   
 
 
 
 CREATE TABLE ApplicationStatus (
    StatusId SERIAL PRIMARY KEY,
    StatusName VARCHAR(255) NOT NULL
 );
 
 
 CREATE TABLE Interviewer (
    InterviewerId SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    DepartmentId INT NOT NULL,
    CONSTRAINT fk_interviewer_department FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
);

CREATE TABLE Application (
   ApplicationId SERIAL PRIMARY KEY,
   CandidateId INT NOT NULL,
   OpeningId INT NOT NULL,
   StatusId INT NOT NULL,
   ApplicationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT fk_application_candidate FOREIGN KEY (CandidateId) REFERENCES Candidate(CandidateId),
   CONSTRAINT fk_application_opening FOREIGN KEY (OpeningId) REFERENCES JobOpening(OpeningId),
   CONSTRAINT fk_application_status FOREIGN KEY (StatusId) REFERENCES ApplicationStatus(StatusId)
);


CREATE TABLE Interview (
   InterviewId SERIAL PRIMARY KEY,
   ApplicationId INT NOT NULL,
   InterviewerId INT NOT NULL,
   InterviewDate TIMESTAMP NOT NULL,
   Feedback TEXT,
   InterviewRound INT NOT NULL,
   ApplicationStatusId INT NOT NULL,
   CONSTRAINT fk_interview_application FOREIGN KEY (ApplicationID) REFERENCES Application(ApplicationID),
   CONSTRAINT fk_interview_interviewer FOREIGN KEY (InterviewerID) REFERENCES Interviewer(InterviewerID),
   CONSTRAINT fk_interview_status FOREIGN KEY (ApplicationStatusID) REFERENCES ApplicationStatus(StatusID)
);   
