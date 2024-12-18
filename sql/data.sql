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



INSERT INTO email_templates (subject, body)
VALUES (
    'VERIFY_CODE',
    '
<div style="max-width: 600px; margin: 20px auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <!-- Content Section -->
        <div style="text-align: center;">
            <h2 style="color: #3a87ad;">Verify Your Account</h2>
            <p style="margin: 10px 0; color: #5d5d5d;">
                Thank you for signing up with <strong>Events App</strong>! To complete your registration, please use the code below to verify your account:
            </p>
            <div style="display: inline-block; padding: 10px 15px; background-color: #d1f0ee; border: 1px solid #3a87ad; border-radius: 5px; font-size: 20px; font-weight: bold; color: #3a87ad; margin-top: 20px;">
                :code
            </div>
            <p style="margin: 10px 0; color: #5d5d5d;">If you didn’t sign up for this account, you can safely ignore this email.</p>

        </div>'
);
