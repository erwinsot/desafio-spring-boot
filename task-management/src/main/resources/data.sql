-- Usuario administrador
INSERT INTO usuarios (
 username, password, nombre, email, rol
) VALUES (

             'admin',
             '$2a$10$8xMFIr/5NqckIb20asHnbulPSKDEu5kbr8ioXjTDtL0RbbFT2AYMK', -- admin123
             'Administrador',
             'admin@example.com',
             'ROLE_ADMIN'
         );

-- Usuario estándar 1
INSERT INTO usuarios (
   username, password, nombre, email, rol
) VALUES (

             'user1',
             '$2a$10$4FCUb/xly6xhtnF94QqWJuhNZgfMfRoUg9uORZC0RPVVz6RS2xnOi', -- user123
             'Usuario Uno',
             'user1@example.com',
             'ROLE_USER'
         );

-- Usuario estándar 2
INSERT INTO usuarios (
  username, password, nombre, email, rol
) VALUES (

             'user2',
             '$2a$10$nZiHfMwZpeOtJc6tJ9bJr.6S4rM1SC2M33DVGJAv7ujbHQUWdksz2', -- user456
             'Usuario Dos',
             'user2@example.com',
             'ROLE_USER'
         );

-- Usuario estándar 3
INSERT INTO usuarios (
     username, password, nombre, email, rol
) VALUES (

             'user3',
             '$2a$10$wT2W9vpWpZq4rBQcJY6r2e5H7Evzr1kSLX6xzzC2TXZqxttHlQAY2', -- pass789
             'Usuario Tres',
             'user3@example.com',
             'ROLE_USER'
         );


-- Precargar estados de tarea
-- Estado: Pendiente
INSERT INTO estados_tarea (id, name, description) VALUES
    (1, 'PENDIENTE', 'La tarea ha sido creada pero aún no ha comenzado.');

-- Estado: En progreso
INSERT INTO estados_tarea (id, name, description) VALUES
    (2, 'EN_PROGRESO', 'La tarea se encuentra actualmente en desarrollo.');

-- Estado: Completada
INSERT INTO estados_tarea (id, name, description) VALUES
    (3, 'COMPLETADA', 'La tarea ha sido finalizada con éxito.');

-- Estado: Cancelada
INSERT INTO estados_tarea (id, name, description) VALUES
    (4, 'CANCELADA', 'La tarea ha sido cancelada y no se completará.');

