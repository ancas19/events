INSERT INTO permissions ( name, description, created_user,  created_at)
VALUES
('READ_USER_INFORMATION', 'View user information', 'ADMIN', current_timestamp),
('CREATE_USERS', 'Create new users', 'ADMIN', current_timestamp),
('UPDATE_USERS', 'Update existing users', 'ADMIN', current_timestamp),
('BLOCK_USERS', 'Remove users from the system', 'ADMIN', current_timestamp);


INSERT INTO roles ( name, description, created_user, created_at)
VALUES
( 'ADMIN', 'Full access to the system', 'ADMIN', current_timestamp),
( 'EMPLOYEE', 'Limited access for user management', 'ADMIN', current_timestamp),
( 'USER', 'Basic access', 'ADMIN', current_timestamp);


INSERT INTO permissions_roles (permission_id, role_id)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(1, 3),
(3, 3);