-- GRUPOS
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Amigos');
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Trabalho');
INSERT INTO TBL_GROUPS ( name) VALUES ( 'Família');

-- CATEGORIAS
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Importante');
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Contato Novo');
INSERT INTO TBL_CATEGORIES ( name) VALUES ( 'Cliente');

-- CONTATOS
INSERT INTO TBL_CONTACTS (firstname, lastname, birth_date, note, is_favorite) VALUES
  ('João', 'Almeida', '1990-02-20', 'Gosta de ligações curtas.', FALSE),
  ('Mariana', 'Costa', '1998-11-05', '', TRUE),
  ('Lucas', 'Moraes', '1987-07-13', 'Cliente recorrente.', TRUE),
  ('Patrícia', 'Gomes', '1993-03-22', '', FALSE),
  ('Renato', 'Ferreira', '1985-10-10', 'Prefere WhatsApp.', TRUE),
  ('Juliana', 'Barbosa', '1992-12-30', 'Responde rápido.', FALSE),
  ('Thiago', 'Lima', '1999-09-09', '', FALSE),
  ('Camila', 'Ramos', '2000-01-01', 'Mora fora do país.', TRUE),
  ('Eduardo', 'Martins', '1979-08-17', '', FALSE),
  ('Larissa', 'Oliveira', '1994-06-06', '', TRUE),
  ('Felipe', 'Rocha', '1988-04-04', '', FALSE),
  ('Beatriz', 'Melo', '1991-05-15', '', TRUE),
  ('André', 'Cunha', '1986-03-18', '', FALSE),
  ('Vanessa', 'Rezende', '1995-12-25', '', TRUE),
  ('Bruno', 'Nascimento', '1980-07-30', '', FALSE),
  ('Isabela', 'Freitas', '1996-01-10', '', TRUE),
  ('Gustavo', 'Silveira', '1993-11-11', '', FALSE),
  ('Sabrina', 'Teixeira', '2001-02-02', '', TRUE),
  ('Ricardo', 'Souza', '1975-05-05', '', FALSE),
  ('Aline', 'Campos', '1983-09-09', '', TRUE),
  ( 'Ana', 'Silva', '1995-08-10', 'Prefere contato por e-mail.', TRUE),
  ( 'Carlos', 'Pereira', '1989-04-15', 'Atende só à tarde.', FALSE),
  ( 'Fernanda', 'Souza', '2001-12-01', '', TRUE);

-- EMAILS
INSERT INTO TBL_EMAILS (label, email, contact_id) VALUES
  ('pessoal', 'joao.a@gmail.com', 4),
  ('trabalho', 'mariana.c@empresa.com', 5),
  ('pessoal', 'lucas.m@hotmail.com', 6),
  ('trabalho', 'patricia.g@negocios.com', 7),
  ('pessoal', 'renato.f@gmail.com', 8),
  ('pessoal', 'juliana.b@hotmail.com', 9),
  ('trabalho', 'thiago.l@empresa.com', 10),
  ('pessoal', 'camila.r@outlook.com', 11),
  ('trabalho', 'eduardo.m@corp.com', 12),
  ('pessoal', 'larissa.o@gmail.com', 13),
  ('pessoal', 'felipe.r@gmail.com', 14),
  ('trabalho', 'beatriz.m@empresa.com', 15),
  ('pessoal', 'andre.c@outlook.com', 16),
  ('trabalho', 'vanessa.r@negocios.com', 17),
  ('pessoal', 'bruno.n@gmail.com', 18),
  ('trabalho', 'isabela.f@empresa.com', 19),
  ('pessoal', 'gustavo.s@gmail.com', 20),
  ('trabalho', 'sabrina.t@corp.com', 21),
  ('pessoal', 'ricardo.souza@hotmail.com', 22),
  ('trabalho', 'aline.campos@empresa.com', 23),
  ( 'pessoal', 'ana.silva@gmail.com', 1),
  ( 'trabalho', 'ana@empresa.com', 1),
  ('pessoal', 'carlos89@hotmail.com', 2),
  ( 'trabalho', 'fernanda@corp.com', 3);

-- TELEFONES
INSERT INTO TBL_PHONES (label, phone_number, contact_id) VALUES
  ('celular', '(11) 91234-0001', 4),
  ('celular', '(11) 91234-0002', 5),
  ('residencial', '(11) 4002-0012', 6),
  ('celular', '(21) 98765-4321', 7),
  ('celular', '(31) 99876-0000', 8),
  ('residencial', '(19) 3456-7890', 9),
  ('celular', '(41) 98765-1111', 10),
  ('celular', '(47) 99654-2222', 11),
  ('residencial', '(67) 3344-5566', 12),
  ('celular', '(48) 99887-3344', 13),
  ('celular', '(51) 99999-0101', 14),
  ('celular', '(71) 99876-2222', 15),
  ('residencial', '(85) 3232-2323', 16),
  ('celular', '(62) 99999-1212', 17),
  ('celular', '(95) 99111-9191', 18),
  ('celular', '(98) 99222-9292', 19),
  ('residencial', '(92) 3131-3131', 20),
  ('celular', '(34) 98765-0000', 21),
  ('celular', '(44) 99777-7777', 22),
  ('residencial', '(13) 4004-0004', 23),
  ( 'celular', '(11) 99999-0001', 1),
  ('residencial', '(11) 4002-8922', 1),
  ( 'celular', '(21) 98888-1234', 2),
  ( 'celular', '(11) 97777-4567', 3);

-- ENDEREÇOS
INSERT INTO TBL_ADDRESSES (number, complement, street, neighborhood, city, state, country, postal_code, contact_id) VALUES
  ('10', '', 'Rua Alpha', 'Centro', 'São Paulo', 'SP', 'Brasil', '01010-000', 4),
  ('20', 'Casa B', 'Rua Beta', 'Jardim América', 'Rio de Janeiro', 'RJ', 'Brasil', '22020-000', 5),
  ('35', '', 'Rua Gamma', 'Bela Vista', 'Belo Horizonte', 'MG', 'Brasil', '30130-000', 6),
  ('50', 'Apt 101', 'Rua Delta', 'Mooca', 'São Paulo', 'SP', 'Brasil', '03100-000', 7),
  ('70', '', 'Rua Épsilon', 'Centro', 'Campinas', 'SP', 'Brasil', '13020-000', 8),
  ('120', '', 'Rua Zeta', 'Aclimação', 'São Paulo', 'SP', 'Brasil', '01530-000', 9),
  ('40', 'Bloco A', 'Rua Eta', 'Liberdade', 'São Paulo', 'SP', 'Brasil', '01502-000', 10),
  ('99', '', 'Rua Theta', 'Savassi', 'Belo Horizonte', 'MG', 'Brasil', '30140-000', 11),
  ('65', '', 'Rua Iota', 'Centro', 'Curitiba', 'PR', 'Brasil', '80010-000', 12),
  ('88', 'Fundos', 'Rua Kappa', 'Icaraí', 'Niterói', 'RJ', 'Brasil', '24230-000', 13),
  ('33', '', 'Rua Lambda', 'Centro', 'Porto Alegre', 'RS', 'Brasil', '90010-000', 14),
  ('77', '', 'Rua Mu', 'Boa Viagem', 'Recife', 'PE', 'Brasil', '51020-000', 15),
  ('21', '', 'Rua Nu', 'Centro', 'Fortaleza', 'CE', 'Brasil', '60060-000', 16),
  ('55', '', 'Rua Xi', 'Centro', 'Goiânia', 'GO', 'Brasil', '74000-000', 17),
  ('18', '', 'Rua Omicron', 'Centro', 'Boa Vista', 'RR', 'Brasil', '69300-000', 18),
  ('91', '', 'Rua Pi', 'Centro', 'São Luís', 'MA', 'Brasil', '65000-000', 19),
  ('72', '', 'Rua Rho', 'Centro', 'Manaus', 'AM', 'Brasil', '69000-000', 20),
  ('30', '', 'Rua Sigma', 'Centro', 'Uberlândia', 'MG', 'Brasil', '38400-000', 21),
  ('61', '', 'Rua Tau', 'Centro', 'Maringá', 'PR', 'Brasil', '87000-000', 22),
  ('80', '', 'Rua Upsilon', 'Centro', 'Santos', 'SP', 'Brasil', '11000-000', 23),
  ( '100', 'Apt 12', 'Rua 1', 'Centro', 'São Paulo', 'SP', 'Brasil', '01000-000', 1),
  ( '250', '', 'Rua 2', 'Jardins', 'Rio de Janeiro', 'RJ', 'Brasil', '22000-000', 2),
  ( '50', 'Casa 3', 'Rua 3', 'Bela Vista', 'Campinas', 'SP', 'Brasil', '13000-000', 3);

-- RELAÇÃO CONTATO ↔ GRUPO
INSERT INTO CONTACt_GROUP (contact_id, group_id) VALUES
  (4, 1),
  (5, 2),
  (6, 3),
  (7, 2),
  (8, 1),
  (9, 3),
  (10, 1),
  (11, 2),
  (12, 3),
  (13, 2),
  (14, 1),
  (15, 3),
  (16, 1),
  (17, 2),
  (18, 3),
  (19, 1),
  (20, 2),
  (21, 1),
  (22, 2),
  (23, 3),
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3);

-- RELAÇÃO CONTATO ↔ CATEGORIA
INSERT INTO CONTACT_CATEGORY (contact_id, category_id) VALUES
  (4, 1),
  (5, 2),
  (6, 3),
  (7, 1),
  (8, 2),
  (9, 1),
  (10, 3),
  (11, 1),
  (12, 2),
  (13, 3),
  (14, 2),
  (15, 1),
  (16, 3),
  (17, 1),
  (18, 2),
  (19, 3),
  (20, 1),
  (21, 2),
  (22, 3),
  (23, 1),
  (1, 1),
  (2, 2),
  (3, 1),
  (3, 3);
