INSERT INTO product_type (id, type) VALUES (1, 'animals');
INSERT INTO product_type (id, type) VALUES (2, 'food');

INSERT INTO products (id, name, type_id) VALUES (1, 'cat', 1);
INSERT INTO products (id, name, type_id) VALUES (2, 'meet', 2);

INSERT INTO users (id, login, password, email, role) VALUES (1, 'Mike', '1234', 'mike@ya.ru', 'manager');
INSERT INTO users (id, login, password, email, role) VALUES (2, 'Sara', '1234', 'sara@ya.ru', 'customer');
COMMIT;