

-- Now, create the user_table
CREATE TABLE user_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


-- Finally, create the attempts table
CREATE TABLE IF NOT EXISTS attempts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    flag VARCHAR(255) NOT NULL,  
    guessed_country VARCHAR(255) NOT NULL, 
    is_correct BOOLEAN NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_table (id)
);
