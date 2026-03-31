create database BankingDB;
use BankingDB;

CREATE TABLE Customers(CustomerId INT PRIMARY KEY AUTO_INCREMENT,CustomerName VARCHAR(100) NOT NULL,Gender VARCHAR(10),DateOfBirth DATE,PhoneNumber VARCHAR(15),Email VARCHAR(100),
City VARCHAR(50),State VARCHAR(50),CustomerStatus ENUM('Active','Inactive') DEFAULT 'Active'
);

CREATE TABLE Branches(BranchId INT PRIMARY KEY AUTO_INCREMENT,BranchName VARCHAR(100),BranchCode VARCHAR(20),City VARCHAR(50),State VARCHAR(50),IFSCCode VARCHAR(20));

CREATE TABLE Accounts(AccountId INT PRIMARY KEY AUTO_INCREMENT,CustomerId INT,BranchId INT,AccountNumber VARCHAR(30) UNIQUE,AccountType ENUM('Savings', 'Current', 'Fixed Deposit'),
OpenDate DATE,Balance DECIMAL(12,2),AccountStatus ENUM('Active', 'Closed', 'Frozen') DEFAULT 'Active',FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),FOREIGN KEY (BranchId) REFERENCES Branches(BranchId)
);

CREATE TABLE Transactions(TransactionId INT PRIMARY KEY AUTO_INCREMENT,AccountId INT,TransactionDate DATETIME,TransactionType ENUM('Deposit', 'Withdrawal', 'Transfer'),Amount DECIMAL(12,2),
Description VARCHAR(255),FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)
);

CREATE TABLE Loans(LoanId INT PRIMARY KEY AUTO_INCREMENT,CustomerId INT,BranchId INT,LoanType ENUM('Home Loan', 'Car Loan', 'Personal Loan', 'Education Loan'),LoanAmount DECIMAL(12,2),
InterestRate DECIMAL(5,2),LoanStartDate DATE,LoanStatus ENUM('Approved', 'Pending', 'Closed') DEFAULT 'Pending',FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
FOREIGN KEY (BranchId) REFERENCES Branches(BranchId)
);

CREATE TABLE AccountAudit(AuditId INT PRIMARY KEY AUTO_INCREMENT,AccountId INT,ActionType VARCHAR(50),OldBalance DECIMAL(12,2),NewBalance DECIMAL(12,2),ActionDate DATETIME,
Remarks VARCHAR(255),FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)
);

INSERT INTO Customers(CustomerName,Gender,DateOfBirth,PhoneNumber,Email,City,State,CustomerStatus)
VALUES 
('Amit','Male','1995-05-10','9876543210','amit@gmail.com','Chennai', 'TN', 'Active'),
('Priya','Female','1998-08-15','9123456780','priya@gmail.com','Vellore','TN','Active'),
('Rahul','Male','1992-03-20','9012345678','rahul@gmail.com','Bangalore','KA','Inactive');

INSERT INTO Branches(BranchName,BranchCode,City,State,IFSCCode)
VALUES
('Chennai Main','CH001','Chennai','TN','IFSC001'),
('Vellore Branch','VL001','Vellore','TN','IFSC002'),
('Bangalore Branch','BL001','Bangalore','KA','IFSC003');

INSERT INTO Accounts(CustomerId,BranchId,AccountNumber,AccountType,OpenDate,Balance,AccountStatus)
VALUES
(1,1,'ACC1001','Savings','2020-01-01',50000,'Active'),
(2,2,'ACC1002','Current','2021-06-15',30000,'Active'),
(3,3,'ACC1003','Savings','2019-03-10',70000,'Active'),
(1,2,'ACC1004','Savings','2022-02-01',20000,'Active');

INSERT INTO Transactions(AccountId,TransactionDate,TransactionType,Amount,Description)
VALUES
(1,NOW(),'Deposit',10000,'Initial Deposit'),
(2,NOW(),'Withdrawal',5000,'ATM Withdrawal'),
(3,NOW(),'Deposit',20000,'Salary'),
(1,NOW(),'Transfer',5000,'Transfer to friend');

INSERT INTO Loans(CustomerId,BranchId,LoanType,LoanAmount,InterestRate,LoanStartDate,LoanStatus)
VALUES
(1,1,'Home Loan',500000,7.5,'2022-01-01','Approved'),
(2,2,'Personal Loan',100000,10.0,'2023-01-01','Approved');

INSERT INTO AccountAudit(AccountId,ActionType,OldBalance,NewBalance,ActionDate,Remarks)
VALUES
(1,'Deposit',40000,50000,NOW(),'Added money'),
(2,'Withdrawal',35000,30000,NOW(),'ATM withdrawal');

-- Find customers whose account balance is greater than the average account balance.
select CustomerId,CustomerName from customers where CustomerId in(select CustomerId from Accounts where balance>(select avg(balance) from accounts));

-- Find customers who have taken loans greater than the maximum personal loan amount.
select * from customers where customerId in(select customerId from loans where loanamount>(select max(loanamount) from loans where LoanType='Personal Loan'));

-- Display account details of customers who belong to branches located in the same city as 'Chennai'.
select * from Accounts where branchId in (Select branchId from branches where city='Chennai');

-- Find customers who do not have any loan.
select * from customers where customerid not in (select customerid from loans);

-- Find customers whose total transaction amount is greater than the total transaction amount of customer with CustomerId = 1.
select customerid from accounts where accountid in (select accountid from transactions group by accountid having sum(amount)>(select sum(amount) from transactions where accountid in(
select accountid from accounts where Customerid=1)));

-- Display branch details where the number of accounts is greater than the average number of accounts across all branches.
select * from branches where branchid in(select branchid from accounts group by branchid having count(*)>(select avg(accountcount)from(select count(*) as accountcount
from accounts group by branchid) as temp));

-- Find accounts whose balance is equal to the second highest balance.
select * from accounts where balance=(select distinct balance from accounts order by balance desc limit 1 offset 1);

-- Find the customer(s) who opened the earliest account.
select * from customers where customerid in(select customerid from accounts where opendate=(select min(opendate) from accounts));

-- Find loan details for customers who also have a savings account.
select * from loans where customerid in(select customerid from accounts where accounttype='Savings');

-- Find customers who have more than one account using a subquery.
select * from customers where customerid in(select customerid from accounts group by customerid having count(*)>1);

-- view tasks
-- 1
create view vw_CustomerAccountDetails as
select c.customerid,c.customername,a.accountid,a.balance,a.accountstatus from customers c join accounts a where c.customerid=a.customerid;
select * from vw_CustomerAccountDetails;

-- 2
create view vw_BranchAccountSummary as
select b.branchname,count(a.branchid) as totalaccounts,sum(a.balance) as total_balance from branches b join accounts a on b.branchid=a.branchid group by b.branchname;
select * from vw_BranchAccountSummary;

-- 3
create view vw_loancustomerdetails as select c.customername, l.loantype,l.loanamount,l.interestrate,l.loanstatus,b.branchname
from loans l join customers c on l.customerid=c.customerid
join branches b on l.branchid=b.branchid;
select * from vw_loancustomerdetails;

-- 4
create view vw_HighValueAccounts as select * from accounts where balance>100000;
select * from vw_HighValueAccounts;

 -- 5
create view vw_dailytransactions as select a.accountnumber, t.transactiondate, t.transactiontype, t.amount, t.description from transactions t
join accounts a on t.accountid=a.accountid;
select * from vw_dailytransactions;

-- 6
create view vw_activecustomers as select * from customers where customerstatus='Active';
select * from vw_activecustomers;

-- 7
create view vw_approvedloans as select * from loans where loanstatus='Approved';
select * from vw_approvedloans;

-- 8
create view vw_customeraccountbranch as select c.customername,a.accountnumber,a.balance,b.branchname from customers c
join accounts a on c.customerid=a.customerid
join branches b on a.branchid=b.branchid;

-- 9
create view vw_simple as select customerid,customername from customers;
select * from vw_simple;
update vw_simple set customername='Deekshu' where customerid=1;
insert into vw_simple(customerid,customername) values (4,'Bhargav');

-- 10
create view vw_branchsummary as select branchid,count(accountid) as totalaccounts,sum(balance) as totalbalance
from accounts group by branchid;
update vw_branchsummary set totalbalance = 100000 where branchid = 1;
-- not updatable

-- Stored procedure tasks
-- Create a procedure to display all customers.
delimiter //
create procedure getallcustomers()
begin
select * from customers;
end //
delimiter ;
call getallcustomers();

-- Create a procedure to display all accounts of a given customer.
delimiter //
create procedure getaccountsbycustomer(in p_customerid int)
begin
select * from accounts where customerid = p_customerid;
end //
delimiter ;
call getaccountsbycustomer(1);

-- Create a procedure to display total balance available in a given branch.
delimiter //
create procedure getbranchTotalBalance(IN p_branchid INT)
begin
select sum(balance) as totalbalance from accounts where branchid=p_branchid;
end //
delimiter ;
call getbranchTotalBalance(2);

-- Create a procedure to count how many loans are approved.
delimiter //
create procedure getApprovedloanCount(out p_totalcount int)
begin
select count(*) into p_totalcount from loans where loanstatus='Approved';
end //
delimiter ;
call getapprovedloancount(@total);
select @total;

-- Create a procedure to insert a new transaction.
delimiter //
create procedure addtransaction(in p_accountid int,in p_transactiontype varchar(20),in p_amount decimal(12,2),in p_description varchar(255))
begin
    insert into transactions(accountid,transactiondate,transactiontype,amount,description)
    values(p_accountid,now(),p_transactiontype,p_amount,p_description);
end //
delimiter ;
call addtransaction(1,'Deposit',5000,'Transaction');

-- Create a procedure to deposit money into an account.
delimiter //
create procedure depositamount(in p_accountid int,p_Amount decimal(10,2))
begin
insert into transactions(accountid,transactiondate,transactiontype,amount,description)
    values (p_accountid, now(),'Deposit',p_amount,'Amount Deposited');
    -- update account balance
    update accounts set balance = balance + p_amount where accountid = p_accountid;
end //
delimiter ;
call depositamount(1,15000);

-- Create a procedure to withdraw money from an account.
delimiter //
create procedure withdrawAmount(p_accountid int,p_amount decimal(10,2))
begin
declare current_balance decimal(12,2);
-- get current balance
select balance into current_balance from accounts where accountid = p_accountid;
-- check sufficient balance
if current_balance >= p_amount then
        insert into transactions(accountid,transactiondate,transactiontype,amount,description)
        values(p_accountid,now(),'Withdrawal',p_amount,'Amount Withdrawn');
        update accounts set balance=balance-p_amount where accountid=p_accountid;
    else
        select 'Insufficient Balance' as message;
    end if;
end //
delimiter ;
call withdrawamount(1,2000);

-- Create a procedure to get all loans of a particular customer.
delimiter //
create procedure getloansbycustomer(in p_customerid int)
begin
    select * from loans where customerid=p_customerid;
end //
delimiter ;
call getloansbycustomer(1);

-- Create a procedure to change account status.
delimiter //
create procedure changeaccountstatus(in p_accountid int,in p_newstatus varchar(20))
begin
    update accounts set accountstatus=p_newstatus where accountid=p_accountid;
end //
delimiter ;
call changeaccountstatus(1,'Closed');

-- Create a procedure using INOUT parameter to add service charge to a balance and return updated amount
delimiter //
create procedure addservicecharge(inout p_balance decimal(10,2))
begin
    set p_balance = p_balance + 100;
end //
delimiter ;
set @bal = 5000;
call addservicecharge(@bal);
select @bal;