drop table if exists Joueur;

CREATE TABLE Joueur (
 id_joueur INT( 11 ) primary key NOT NULL AUTO_INCREMENT,
 nom VARCHAR( 20 ) NOT NULL ,
 mdp VARCHAR( 50 ) NOT NULL ,
 pays VARCHAR( 20 ) NOT NULL ,
 bucks INT( 6 ) NOT NULL , 
 white TINYINT( 1 ) NOT NULL ,
 black TINYINT( 1 ) NOT NULL ,
 lady TINYINT( 1 ) NOT NULL ,
 magnet TINYINT( 1 ) NOT NULL ,
 plasma TINYINT( 1 ) NOT NULL ,
 pretty TINYINT( 1 ) NOT NULL ,
 golem TINYINT( 1 ) NOT NULL ,
 regulus_bullzeeb TINYINT( 1 ) NOT NULL ,
 brain TINYINT( 1 ) NOT NULL 
) ENGINE = INNODB;
