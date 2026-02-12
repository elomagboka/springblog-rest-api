DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    body LONGTEXT DEFAULT NULL,
    slug varchar(60) DEFAULT NULL,
    post_status ENUM ('DRAFT', 'PUBLISHED'),
    created_on date DEFAULT NULL,
    updated_on date DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE comments (
    id int NOT NULL AUTO_INCREMENT,
    post_id int NOT NULL,
    title varchar(200) NOT NULL,
    author_name varchar(200) NOT NULL,
    body LONGTEXT DEFAULT NULL,
    created_on date DEFAULT NULL,
    updated_on date DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
);