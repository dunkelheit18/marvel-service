DROP TABLE IF EXISTS COMICS;

CREATE TABLE COMICS(
	
	ID_COMICS INT AUTO_INCREMENT PRIMARY KEY,
	RESOURCE_COMICS VARCHAR (250),
	NAME_COMICS VARCHAR (50)
);

DROP TABLE IF EXISTS EVENTS;

CREATE TABLE EVENTS(
	
	ID_EVENTS INT AUTO_INCREMENT PRIMARY KEY,
	RESOURCE_EVENTS VARCHAR (250),
	NAME_EVENTS VARCHAR (50)
);

DROP TABLE IF EXISTS SERIES;

CREATE TABLE SERIES(
	
	ID_SERIES INT AUTO_INCREMENT PRIMARY KEY,
	RESOURCE_SERIES VARCHAR (250),
	NAME_SERIES VARCHAR (50)
);

DROP TABLE IF EXISTS STORIES;

CREATE TABLE STORIES(
	
	ID_STORIES INT AUTO_INCREMENT PRIMARY KEY,
	RESOURCE_STORIES VARCHAR (250),
	NAME_STORIES VARCHAR (50)
);

DROP TABLE IF EXISTS CHARACTERS;

CREATE TABLE CHARACTERS(
	
	ID_CHARACTERER INT AUTO_INCREMENT PRIMARY KEY,
	ID_COMICS INT,
	ID_EVENTS INT,
	ID_SERIES INT,
	ID_STORIES INT,
	NAME_CHARACTER VARCHAR(50)
);



