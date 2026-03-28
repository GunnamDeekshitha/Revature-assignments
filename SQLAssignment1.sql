create database EcommerceDB;
use EcommerceDB;

create table customers(
CustomerID int,
CustomerName varchar(30),
City varchar(30),
Email varchar(30)
);

create table Products(
ProductId int,
ProductName varchar(20),
Category varchar(20),
Price decimal(10,2)
);

create table Orders(
OrderId int,
CustomerId int,
OrderDate date,
TotalAmount decimal(10,2)
);

create table OrderItems(
OrderItemId int,
OrderId int,
ProductId int,
Quantity int
);
-- Section B: Constraints
alter table customers add primary key (CustomerId) ;
alter table Products add primary key (ProductId);
alter table Orders add primary key (OrderId);
alter table OrderItems add primary key (OrderItemId);

alter table Orders add constraint fk_customer foreign key (CustomerId) references Customers(CustomerId);
alter table OrderItems add constraint fk_order foreign key (OrderId) references Orders(OrderId);
alter table OrderItems add constraint fk_products foreign key (ProductId) references Products(ProductId);

-- Section C: Data Insertion
insert into Customers values
(1,'Anita','Chennai','anita@gmail.com'),
(2,'Arjun','Bangalore','arjun@gmail.com'),
(3,'Meena','Delhi','meena@gmail.com'),
(4,'Rahul','Mumbai','rahul@gmail.com'),
(5,'Kiran','Chennai','kiran@gmail.com'),
(6,'Asha','Bangalore',NULL);

insert into Products values
(101,'Mobile','Electronics',15000),
(102,'Laptop','Electronics',55000),
(103,'Chair','Furniture',3000),
(104,'Table','Furniture',7000),
(105,'Headphones','Accessories',2000);

insert into Orders values
(201,1,'2024-01-10',20000),
(202,2,'2024-02-15',60000),
(203,1,'2024-03-05',15000),
(204,3,'2024-03-20',30000),
(205,4,'2024-04-01',8000);

insert into OrderItems values
(301,201,101,1),
(302,202,102,1),
(303,203,103,2),
(304,204,104,3),
(305,205,105,2),
(306,202,105,1);

-- Section D: Arithmetic Operators
SELECT OrderItemId,Quantity*1000 AS EstimatedTotal FROM OrderItems;
SELECT ProductName,Price+500 AS NewPrice FROM Products;
SELECT ProductName,Price-200 AS ReducedPrice FROM Products;
SELECT OrderItemId,Quantity*2 AS DoubleQuantity FROM OrderItems;
SELECT OrderId,TotalAmount/2 AS HalfAmount FROM Orders;

-- Section E: Comparison Operators
SELECT * FROM Orders WHERE TotalAmount>10000;
SELECT * FROM Products WHERE Price<5000;
SELECT * FROM Orders WHERE TotalAmount>=25000;
SELECT * FROM Products WHERE Price<=8000;
SELECT * FROM Customers WHERE City='Chennai';
SELECT * FROM Customers WHERE City!='Delhi';

-- Section F: Logical Operators
SELECT CustomerId,CustomerName from Customers where city='Bangalore' and CustomerName like 'A%';
select ProductId,ProductName from Products where category='Electronics' or category='Furniture';
select * from Orders where TotalAmount>5000 and TotalAmount<70000;
SELECT * FROM Customers WHERE City!='Mumbai';
SELECT * FROM Products WHERE Category!='Accessories';

-- Section G: Special Operators
SELECT * FROM Products WHERE Category IN ('Electronics','Furniture');
SELECT * FROM Customers WHERE City NOT IN ('Chennai','Bangalore');
SELECT * FROM Orders WHERE TotalAmount BETWEEN 5000 AND 60000;
SELECT * FROM Orders WHERE TotalAmount NOT BETWEEN 5000 AND 60000;
SELECT * FROM Customers WHERE CustomerName LIKE '%a';
SELECT * FROM Products WHERE ProductName LIKE 'M%';
SELECT * FROM Customers WHERE Email IS NULL;
SELECT * FROM Customers WHERE Email IS NOT NULL;

-- Section H: WHERE Clause
SELECT * FROM Customers WHERE City='Chennai';
SELECT * FROM Orders WHERE OrderDate>'2024-02-01';
SELECT * FROM Products WHERE Price>10000;
SELECT * FROM OrderItems WHERE Quantity=1;
SELECT * FROM Customers WHERE Email IS NULL;

-- Section I: ORDER BY
SELECT orderId,TotalAmount from Orders order by TotalAmount desc;
SELECT CustomerName from Customers order by CustomerName;
SELECT ProductName,Price from Products order by Price desc;
SELECT OrderId,OrderDate from Orders order by OrderDate asc;

-- Section J: GROUP BY
select CustomerId,count(OrderId) as totalorders from orders group by CustomerId;
select CustomerId,sum(TotalAmount) as totalrevenue from orders group by CustomerId;
select CustomerId,avg(TotalAmount) as AvgOrder from orders group by CustomerId;
select ProductId, sum(Quantity) as TotalQuantity from OrderItems group by ProductId;
select Category,count(*) as ProductCount from Products group by Category;

-- Section K: HAVING
select CustomerId,sum(TotalAmount) as totalrevenue from orders group by CustomerId having totalrevenue>50000; 
select CustomerId,count(OrderId) as totalorders from orders group by CustomerId having totalorders>1;
select ProductId, sum(Quantity) as TotalQuantity from OrderItems group by ProductId having TotalQuantity>1;
select Category,count(*) as ProductCount from Products group by Category having ProductCount>1;
select CustomerId,avg(TotalAmount) as AvgOrder from orders group by CustomerId having AvgOrder>20000;

-- Section L: Join-Based Queries
select c.CustomerName,o.TotalAmount from Customers c join orders o on c.CustomerId=o.CustomerId;
select p.ProductName,oi.Quantity from Products p join OrderItems oi ON p.ProductID = oi.ProductID;
select c.CustomerName,o.OrderDate,o.TotalAmount from Customers c join Orders o ON c.CustomerID=o.CustomerID;
select oi.OrderId,p.ProductName,oi.Quantity from OrderItems oi join Products p ON oi.ProductID=p.ProductID;
select c.CustomerName,o.OrderId,p.ProductName,oi.Quantity
FROM Customers c join Orders o ON c.CustomerID=o.CustomerID
join OrderItems oi ON o.OrderID=oi.OrderID
join Products p ON oi.ProductID=p.ProductID;

-- Section M: Reporting Questions
SELECT CustomerId,SUM(TotalAmount) AS Revenue FROM Orders GROUP BY CustomerId ORDER BY Revenue DESC;
SELECT ProductId,SUM(Quantity) AS TotalSold FROM OrderItems GROUP BY ProductId ORDER BY TotalSold DESC;
SELECT * FROM Customers WHERE Email IS NULL;
SELECT MONTH(OrderDate) AS Month, SUM(TotalAmount) FROM Orders GROUP BY MONTH(OrderDate);
SELECT * FROM Orders WHERE TotalAmount>20000;
SELECT * FROM Products WHERE ProductID NOT IN (SELECT ProductID FROM OrderItems);
SELECT * FROM Customers WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders);
SELECT CustomerId,SUM(TotalAmount) AS Revenue FROM Orders GROUP BY CustomerId ORDER BY Revenue DESC LIMIT 3;
SELECT p.Category,SUM(oi.Quantity) FROM Products p JOIN OrderItems oi ON p.ProductID=oi.ProductID GROUP BY p.Category;
SELECT CustomerId, AVG(TotalAmount) FROM Orders GROUP BY CustomerId;

