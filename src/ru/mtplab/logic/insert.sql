insert OR REPLACE into users (login, password) values ("farades", "123");

insert OR REPLACE into accounts (descr, user_name) values ("Зарплата", "farades");
insert OR REPLACE into accounts (descr, user_name) values ("Откаты", "farades");
insert OR REPLACE into accounts (descr, user_name) values ("Подработки", "farades");
insert OR REPLACE into accounts (descr, user_name) values ("Фриланс", "farades");

insert OR REPLACE into records (descr, amount, category_id, account_id) values ("Покупка машины", -100000, 2, 1);
insert OR REPLACE into records (descr, amount, category_id, account_id) values ("Аванс",           35000,   4, 1);

insert OR REPLACE into categories (name) values ("Еда"), ("Транспорт"), ("Здоровье"), ("Работа");
