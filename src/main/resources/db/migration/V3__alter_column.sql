-- Modify the column type of Resume to BYTEA
ALTER TABLE candidate
ALTER COLUMN resume TYPE BYTEA
USING resume::bytea;
