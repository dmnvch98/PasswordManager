CREATE TABLE IF NOT EXISTS credentials
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255)                NOT NULL,
    website    VARCHAR(255)                NOT NULL,
    username   VARCHAR(255)                NOT NULL,
    password   VARCHAR(255)                NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id    BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
