# init database
CREATE MEMORY TABLE options(ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,LABEL VARCHAR(20))
CREATE MEMORY TABLE votes(ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,result VARCHAR(20))
INSERT INTO OPTIONS(LABEL) VALUES('赞成')
INSERT INTO OPTIONS(LABEL) VALUES('反对')
INSERT INTO OPTIONS(LABEL) VALUES('弃权')