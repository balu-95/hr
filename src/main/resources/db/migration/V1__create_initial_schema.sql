-- create Department table
create table Department (
   DepartmentId SERIAL primary key,
   DepartmentName varchar(255) not null
 ); 
 
 --create Location table
 create table Location (
    LocationId serial primary key,
    LocationName varchar(255) not null
 );
 
 --create JobRole table
 create table JobRole (
    RoleId serial primary key,
    RoleName varchar(255) not null,
    RoleDescription text,
    SalaryRange varchar(255),
    Responsibilities text,
    Requirements text,
    Benefits text
 );
 
 --create JobPackage table
 create table JobPackage (
    PackageId serial primary key,
    RoleId int not null,
    DepartmentId int not null,
    LocationId int not null,
    constraint fk_package_role foreign key (RoleId) references JobRole(RoleId),
    constraint fk_package_department foreign key (DepartmentId) references Department(DepartmentId),
    constraint fk_package_location foreign key (LocationId) references Location(LocationId)
 );
 
 
 --create JobOpenig table
 create table JobOpening (
    OpeningId serial primary key,
    PackageId int not null,
    PostingDate timestamp not null default CURRENT_TIMESTAMP,
    ClosingDate timestamp,
    CustomTitle varchar(255),
    CustomDescription text,
    CustomSalary varchar(255),
    CustomBenefits text,
    constraint fk_opening_package foreign key (PackageId) references JobPackage(PackageId)
 );
 
 --create Employee table
 create table Employee (
    EmployeeId serial primary key,
    Name varchar(255) not null,
    Email varchar(255) not null,
    DepartmentId int not null,
    constraint fk_employee_department foreign key (DepartmentId) references Department(DepartmentId)
);

--create Candidate table
create table Candidate (
   CandidateId serial primary key,
   Name varchar(255) not null,
   Email varchar(255) not null,
   MobileNumber varchar(15),
   Resume text
 );   
 
 
 
 create table ApplicationStatus (
    StatusId serial primary key,
    StatusName varchar(255) not null
 );
 
 
 create table Interviewer (
    InterviewerId serial primary key,
    Name varchar(255) not null,
    Email varchar(255) not null,
    DepartmentId int not null,
    constraint fk_interviewer_department foreign key (DepartmentId) references Department(DepartmentId)
);

create table Application (
   ApplicationId serial primary key,
   CandidateId int not null,
   OpeningId int not null,
   StatusId int not null,
   ApplicationDate timestamp not null default CURRENT_TIMESTAMP,
   constraint fk_application_candidate foreign key (CandidateId) references Candidate(CandidateId),
   constraint fk_application_opening foreign key (OpeningId) references JobOpening(OpeningId),
   constraint fk_application_status foreign key (StatusId) references ApplicationStatus(StatusId)
);


create table Interview (
   InterviewId serial primary key,
   ApplicationId int not null,
   InterviewerId int not null,
   InterviewDate timestamp not null,
   Feedback text,
   InterviewRound int not null,
   ApplicationStatusId int not null,
   CONSTRAINT fk_interview_application FOREIGN KEY (ApplicationID) REFERENCES Application(ApplicationID),
   CONSTRAINT fk_interview_interviewer FOREIGN KEY (InterviewerID) REFERENCES Interviewer(InterviewerID),
   CONSTRAINT fk_interview_status FOREIGN KEY (ApplicationStatusID) REFERENCES ApplicationStatus(StatusID)
);             
    
    
 
          