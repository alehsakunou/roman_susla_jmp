INSERT INTO "user" ("id", "uid", "email", "password")   VALUES (1, 'mort', 'catmorte@gmail.com', '$2a$10$tjeOD1nih1Av44UTQDW5ce9tPXIXA.elq31zKP1m5L9Qmr8FeUDZW');
INSERT INTO "role" ("id", "uid", "description")         VALUES (1, 'ADMIN', 'head of the project');
INSERT INTO "user_role" ("user_id", "role_id")          VALUES (1, 1);
