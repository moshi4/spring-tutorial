if object_id('employee') is null
create table employee (
  employee_id int primary key,
  employee_name nvarchar(50),
  age int
);

if object_id('m_user') is null
create table m_user(
  user_id nvarchar(50) primary key,
  password nvarchar(100),
  user_name nvarchar(50),
  birthday date,
  age int,
  marriage bit,
  role nvarchar(50)
)
