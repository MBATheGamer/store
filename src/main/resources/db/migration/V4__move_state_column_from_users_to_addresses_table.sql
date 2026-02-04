-- Drop state column from users table
ALTER TABLE users DROP state;

-- Add state column to addresses table
ALTER TABLE addresses
ADD state VARCHAR(255);