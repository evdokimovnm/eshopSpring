INSERT INTO product_type (id, type) VALUES (1, 'Animals');
INSERT INTO product_type (id, type) VALUES (2, 'Food');

INSERT INTO products (id, name, type_id) VALUES (1, 'cat', 1);
INSERT INTO products (id, name, type_id) VALUES (2, 'meet', 2);
COMMIT;