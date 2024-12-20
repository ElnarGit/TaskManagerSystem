CREATE TABLE users (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_role VARCHAR(32) NOT NULL,
    status VARCHAR(32) NOT NULL
);


CREATE TABLE tasks (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    task_status VARCHAR(32) NOT NULL,
    priority VARCHAR(32) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author_id INT NOT NULL REFERENCES users(id) ON DELETE SET NULL,
    assignee_id INT REFERENCES users(id) ON DELETE SET NULL
);
