create database if not exists bank;

use bank;

drop table if exists users;

CREATE TABLE users (
  id INT NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  PRIMARY KEY (id)
);

drop table if exists transactions;

CREATE TABLE transactions (
  id INT NOT NULL auto_increment,
  user_id integer NOT NULL,
  date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  amount int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

drop table if exists account;

CREATE TABLE account (
  user_id int,
  balance int NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


INSERT INTO users (name, password) VALUES ('venkanna', '12345678');

INSERT INTO account (user_id, balance) VALUES (1, 200000);

INSERT INTO transactions (user_id, amount) VALUES
  (1, 1000),
  (1, 100),
  (1, 220),
  (1, 120),
  (1, 300),
  (1, 30),
  (1, 70),
  (1, 155),
  (1, 399),
  (1, 699),
  (1, 555)

select sum(amount) from transactions where user_id = 1;

select * from transactions;