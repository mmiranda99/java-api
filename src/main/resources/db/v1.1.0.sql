-- UPs
ALTER TABLE est_schedule_user ADD COLUMN usr_code VARCHAR;

-- DOWNs

ALTER TABLE est_schedule_user DROP COLUMN usr_code;