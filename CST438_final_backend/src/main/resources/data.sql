-- Users
INSERT INTO users (username, password) VALUES ('user', '{noop}password');

-- Flags (you would need actual image URLs or paths here)
INSERT INTO flags (country, image_url) VALUES ('Canada', '/images/canada.png');
INSERT INTO flags (country, image_url) VALUES ('France', '/images/france.png');
-- ... add more flags as needed

-- Attempts (examples, assuming user ID and flag data are correct)
INSERT INTO attempts (user_id, flag, guessed_country, is_correct) VALUES (1, '/images/canada.png', 'Canada', TRUE);
INSERT INTO attempts (user_id, flag, guessed_country, is_correct) VALUES (1, '/images/france.png', 'Spain', FALSE);
-- ... add more attempts as needed
