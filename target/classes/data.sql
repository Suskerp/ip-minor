DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
                       taskid INT AUTO_INCREMENT  PRIMARY KEY,
                       title VARCHAR(250) NOT NULL,
                       description VARCHAR(250),
                       duedate datetime NOT NULL
);
INSERT INTO tasks (title,description,dueDate) VALUES
('een', 'eerste taak', NOW()),
('TWEE', 'eerste taak', NOW()),
('Drie', NULL, NOW());


DROP TABLE IF EXISTS subtasks;

CREATE TABLE subtasks (
                       subtaskid INT AUTO_INCREMENT  PRIMARY KEY,
                       title VARCHAR(250) NOT NULL,
                       description VARCHAR(250),
                       parentid INT NOT NULL,
                       FOREIGN KEY (parentid) references tasks(taskid)
);
INSERT INTO subtasks (title,description,parentid) VALUES
('een', 'eerste subtaak',1),
('TWEE', 'tweede subtaak',1),
('Drie', NULL,3);


DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id LONG AUTO_INCREMENT  PRIMARY KEY,
                       username VARCHAR(250) NOT NULL,
                       password VARCHAR(250) NOT NULL,
                       role VARCHAR(250) NOT NULL,
);

