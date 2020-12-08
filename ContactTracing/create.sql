/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  larsdepauw
 * Created: Nov 10, 2020
 */
drop table test;
drop table contact;
drop table burger;
drop table arts;
drop table groepen;
drop table gebruikers;

create table gebruikers (
gebruikersnaam varchar(20) primary key,
paswoord varchar(20) );

create table groepen (
gebruikersnaam varchar(20) references gebruikers primary key,
groep varchar(20) );


CREATE TABLE test (
  tid int NOT NULL ,
  testresultaat int,
  pid int NOT NULL,
  PRIMARY KEY (tid)
);

CREATE TABLE contact (
  cid int  NOT NULL,
  persoon1 int NOT NULL,
  persoon2 int NOT NULL,
  type int DEFAULT NULL,
  PRIMARY KEY (cid)
);

CREATE TABLE burger (
  gebruikersnaam varchar(20) references gebruikers,
  bid int  NOT NULL ,
  naam varchar(22),
  score int,
  telefoonnummer varchar(22),
  PRIMARY KEY (bid)
) ;

CREATE TABLE arts (
  aid int  NOT NULL ,
  naam int DEFAULT NULL,
  PRIMARY KEY (aid)
);

INSERT INTO arts (aid, naam)
VALUES (1, 1), (2, 2);

INSERT INTO test (tid, testresultaat, pid)
VALUES
	(1, 1, 1),
	(2, 0, 2),
	(3, 0, 3),
	(4, 0, 5);

insert into gebruikers values ('jef', 'jf');
insert into gebruikers values ('jos', 'js');
insert into gebruikers values ('bert', 'bt');
insert into gebruikers values ('thomas', 'ts');

insert into gebruikers values ('louis', 'ls');
insert into gebruikers values ('tim', 'tm');

insert into gebruikers values ('sara', 'sa');

INSERT INTO burger (gebruikersnaam,bid, naam, score, telefoonnummer)
VALUES
	('jef',1, 'Jef', 0, '0440126'),
	('jos',2, 'Jos', 0, '948372784'),
        ('bert',3, 'Bert', 0, '54651231'),
        ('thomas',4, 'Thomas',1, '490108'),
	('sara',5, 'Sara', 0, '458392093');


INSERT INTO contact (cid,persoon1,persoon2,type)
VALUES
        (1,1,2,1),
        (2,1,2,2),
        (3,1,2,3),
        (4,3,4,1),
        (5,5,2,1),
        (6,1,4,2),
        (7,3,2,2),
        (8,2,3,3),
        (9,4,2,3);

insert into groepen values ('jef', 'burger' );
insert into groepen values ('jos', 'burger' );
insert into groepen values ('bert', 'burger' );
insert into groepen values ('thomas', 'burger' );

insert into groepen values ('louis', 'arts' );
insert into groepen values ('tim', 'arts' );

insert into groepen values ('sara', 'admin' );