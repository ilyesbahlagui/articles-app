CREATE TABLE article (
  id INT NOT NULL AUTO_INCREMENT,
  libelle VARCHAR(100) NOT NULL,
  prix FLOAT(5) NOT NULL,
  PRIMARY KEY (id)
);
INSERT INTO article(libelle, prix) VALUES ('PS5', 550);
INSERT INTO article(libelle, prix) VALUES ('XBOX', 500);
INSERT INTO article(libelle, prix) VALUES ('SWITCH', 300);
INSERT INTO article(libelle, prix) VALUES ('PC', 2000);