DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    title varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    body TEXT DEFAULT NULL,
    slug varchar(60) DEFAULT NULL,
    post_status varchar(20) CHECK (post_status IN ('DRAFT', 'PUBLISHED')),
    created_on DATE DEFAULT NULL,
    updated_on DATE DEFAULT NULL
);

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    post_id int NOT NULL,
    title varchar(200) NOT NULL,
    author_name varchar(200) NOT NULL,
    body TEXT DEFAULT NULL,
    created_on DATE DEFAULT NULL,
    updated_on DATE DEFAULT NULL,
    FOREIGN KEY (post_id) REFERENCES posts(id)
);
