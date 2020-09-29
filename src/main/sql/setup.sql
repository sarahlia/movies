CREATE DATABASE IF NOT EXISTS mov_db;

CREATE USER mov_user@localhost IDENTIFIED BY '$ometh1ng';
GRANT ALL ON mov_db.* TO mov_user@localhost;