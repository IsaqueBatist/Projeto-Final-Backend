-- GRUPOS
INSERT INTO TBL_GROUPS (id, name) VALUES (1, 'Amigos');
INSERT INTO TBL_GROUPS (id, name) VALUES (2, 'Trabalho');
INSERT INTO TBL_GROUPS (id, name) VALUES (3, 'Família');

-- CATEGORIAS
INSERT INTO TBL_CATEGORIES (id, name) VALUES (1, 'Importante');
INSERT INTO TBL_CATEGORIES (id, name) VALUES (2, 'Contato Novo');
INSERT INTO TBL_CATEGORIES (id, name) VALUES (3, 'Cliente');

-- CONTATOS
INSERT INTO TBL_CONTACTS (id, firstname, lastname, birth_date, note, is_favorite) VALUES
  (1, 'Ana', 'Silva', '1995-08-10', 'Prefere contato por e-mail.', TRUE),
  (2, 'Carlos', 'Pereira', '1989-04-15', 'Atende só à tarde.', FALSE),
  (3, 'Fernanda', 'Souza', '2001-12-01', '', TRUE);

-- EMAILS
INSERT INTO TBL_EMAILS (id, label, email, contact_id) VALUES
  (1, 'pessoal', 'ana.silva@gmail.com', 1),
  (2, 'trabalho', 'ana@empresa.com', 1),
  (3, 'pessoal', 'carlos89@hotmail.com', 2),
  (4, 'trabalho', 'fernanda@corp.com', 3);

-- TELEFONES
INSERT INTO TBL_PHONES (id, label, phone_number, contact_id) VALUES
  (1, 'celular', '(11) 99999-0001', 1),
  (2, 'residencial', '(11) 4002-8922', 1),
  (3, 'celular', '(21) 98888-1234', 2),
  (4, 'celular', '(11) 97777-4567', 3);

-- ENDEREÇOS
INSERT INTO TBL_ADDRESSES (id, number, complement, neighborhood, city, state, country, postal_code, contact_id) VALUES
  (1, '100', 'Apt 12', 'Centro', 'São Paulo', 'SP', 'Brasil', '01000-000', 1),
  (2, '250', '', 'Jardins', 'Rio de Janeiro', 'RJ', 'Brasil', '22000-000', 2),
  (3, '50', 'Casa 3', 'Bela Vista', 'Campinas', 'SP', 'Brasil', '13000-000', 3);

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
