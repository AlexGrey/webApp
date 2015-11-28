-- create table
CREATE TABLE client (
  uid serial primary key,
  name varchar(200)
);

CREATE TABLE pet (
  uid SERIAL PRIMARY KEY,
  client_id INT NOT NULL REFERENCES client(uid),
  nick VARCHAR(200)
);

-- add new client
INSERT INTO client (name) VALUES ('vanya');

-- add new pet
INSERT INTO pet (client_id, nick) VALUES (1, 'sparky');


-- select pet with client
SELECT pet.nick, client.name FROM pet AS pet
INNER JOIN client AS client ON client_id = pet.client_id;

