drop table if exists Joueur;

CREATE TABLE Joueur (
 id_joueur INT( 11 ) primary key NOT NULL AUTO_INCREMENT,
 nom VARCHAR( 20 ) NOT NULL ,
 mdp VARCHAR( 50 ) NOT NULL ,
 pays VARCHAR( 20 ) NOT NULL ,
 nb_parties INT( 11 ) NOT NULL,
 nb_parties_win INT ( 11 )
) ENGINE = INNODB;
