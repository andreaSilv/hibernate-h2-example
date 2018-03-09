DROP TABLE IF EXISTS User;

CREATE TABLE IF NOT EXISTS User(
id INT NOT NULL auto_increment, 
name VARCHAR(255) default NULL,
surname VARCHAR(255) default NULL,
PRIMARY KEY (id)
);