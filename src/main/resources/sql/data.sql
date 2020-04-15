-- Employee
insert into employee (employee_id, employee_name, age)
values (1, '山田太郎', 30);

-- ユーザーマスタのアドミン権限ユーザー 
insert into m_user (user_id, password, user_name, birthday, age, marriage, role)
values ('yamada@xxx.co.jp', 'password', '山田太郎', '1990-01-01', 28, 0, 'ROLE ADMIN')

-- ユーザーマスタの一般権限ユーザー
insert into m_user (user_id, password, user_name, birthday, age, marriage, role)
values ('tamura@xxx.co.jp', 'password', '田村達也', '1896-11-05', 31, 1, 'ROLE GENERAL');

