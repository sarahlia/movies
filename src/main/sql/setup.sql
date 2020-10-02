CREATE DATABASE IF NOT EXISTS movie_db;

CREATE USER movie_user@localhost IDENTIFIED BY '$ometh1ng';
GRANT ALL ON movie_db.* TO movie_user@localhost;