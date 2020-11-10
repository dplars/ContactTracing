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

INSERT INTO burger (bid, naam, score, telefoonnummer)
VALUES
	(1, '1', 0, '0'),
	(2, 'Burger', 0, '948372784'),
	(3, '3', 0, '0'),
	(4, '4', 1, '0'),
	(5, 'Testnaam', 0, '458392093');

INSERT INTO test (tid, testresultaat, pid)
VALUES
	(1, 0, 3),
	(2, 0, 2),
	(3, 0, 1),
	(4, 0, 5);
