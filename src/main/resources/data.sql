-- GRUPOS
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Amigos');
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Trabalho');
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Família');

-- CATEGORIAS
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Importante');
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Contato Novo');
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Cliente');

-- CONTATOS
INSERT INTO TBL_CONTACTS ( firstname, lastname, birth_date, note, is_favorite) VALUES
  ( 'Ana', 'Silva', '1995-08-10', 'Prefere contato por e-mail.', TRUE),
  ( 'Carlos', 'Pereira', '1989-04-15', 'Atende só à tarde.', FALSE),
  ( 'Fernanda', 'Souza', '2001-12-01', '', TRUE);

-- EMAILS
INSERT INTO TBL_EMAILS ( label, email, contact_id) VALUES
  ( 'pessoal', 'ana.silva@gmail.com', 1),
  ( 'trabalho', 'ana@empresa.com', 1),
  ('pessoal', 'carlos89@hotmail.com', 2),
  ( 'trabalho', 'fernanda@corp.com', 3);

-- TELEFONES
INSERT INTO TBL_PHONES ( label, phone_number, contact_id) VALUES
  ( 'celular', '(11) 99999-0001', 1),
  ('residencial', '(11) 4002-8922', 1),
  ( 'celular', '(21) 98888-1234', 2),
  ( 'celular', '(11) 97777-4567', 3);

-- ENDEREÇOS
INSERT INTO TBL_ADDRESSES ( number, complement, street, neighborhood, city, state, country, postal_code, contact_id) VALUES
  ( '100', 'Apt 12', 'Rua 1', 'Centro', 'São Paulo', 'SP', 'Brasil', '01000-000', 1),
  ( '250', '', 'Rua 2', 'Jardins', 'Rio de Janeiro', 'RJ', 'Brasil', '22000-000', 2),
  ( '50', 'Casa 3', 'Rua 3', 'Bela Vista', 'Campinas', 'SP', 'Brasil', '13000-000', 3);

-- RELAÇÃO CONTATO ↔ GRUPO
INSERT INTO CONTACt_GROUP (contact_id, group_id) VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3);

-- RELAÇÃO CONTATO ↔ CATEGORIA
INSERT INTO CONTACT_CATEGORY (contact_id, category_id) VALUES
  (1, 1),
  (2, 2),
  (3, 1),
  (3, 3);
