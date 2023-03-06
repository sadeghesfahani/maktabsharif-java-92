CREATE TABLE authors
(
    author_id SERIAL PRIMARY KEY,
    name      TEXT        NOT NULL,
    email     TEXT UNIQUE NOT NULL,
    password  TEXT        NOT NULL
);

CREATE TABLE articles
(
    article_id SERIAL PRIMARY KEY,
    title      TEXT NOT NULL,
    content    TEXT NOT NULL,
    pub_date   DATE NOT NULL,
    category   TEXT NOT NULL,
    author_id  INTEGER REFERENCES authors (author_id)
);

CREATE TABLE tags
(
    tag_id     SERIAL PRIMARY KEY,
    tag_name   TEXT NOT NULL,
    article_id INTEGER REFERENCES articles (article_id)
);


INSERT INTO authors (name, email, password)
VALUES ('Michael Brown', 'michael@example.com', 'password123'),
	 ('Emily Davis', 'emily@example.com', 'password456'),
	 ('David Wilson', 'david@example.com', 'password789');

INSERT INTO articles (title, content, pub_date, category, author_id)
VALUES ('The Importance of Regular Exercise for Mental Health',
        'Research has shown that regular exercise can have a significant positive impact on mental health. Learn more about the benefits of exercise and how to incorporate it into your daily routine.',
        '2023-02-22', 'Health', 4),
       ('The Future of Artificial Intelligence',
 	  'AI technology is rapidly advancing and changing the way we live and work. Explore the potential benefits and challenges of AI, and what the future might hold for this exciting field.',
 	  '2023-02-18', 'Technology', 5),
       ('Exploring the World of Astrophysics',
 	  'Take a journey through the universe and learn about the fascinating world of astrophysics. Discover the latest research and theories about the cosmos, from black holes to the big bang.',
  	  '2023-02-20', 'Science', 6);

INSERT INTO tags (tag_name, article_id)
VALUES ('exercise', 4),
	 ('mental health', 4),
	 ('AI', 5),
	 ('future technology', 5),
	 ('astrophysics', 6),
	 ('cosmology', 6);

-- 1
SELECT title, category
FROM articles;

-- 2
SELECT title
FROM articles
WHERE author_id = 2;

-- 3
SELECT articles.title, articles.content, authors.name, authors.email
FROM articles
         JOIN authors ON articles.author_id = authors.author_id
WHERE articles.author_id = 1;

-- 4
SELECT articles.title, articles.content, authors.name, authors.email, articles.category
FROM articles
         JOIN authors ON articles.author_id = authors.author_id
WHERE articles.author_id = 1;

-- 5
SELECT title, content
FROM articles
WHERE category = 'Health';


-- 6
SELECT articles.title, articles.content, tags.tag_name
FROM articles
         JOIN tags ON articles.article_id = tags.article_id
WHERE tags.tag_name = 'exercise';


-- 7
SELECT title, content
FROM articles
WHERE author_id = 1 AND category = 'Health';

-- 8
SELECT COUNT(*)
FROM articles
WHERE author_id = 1 AND category = 'Health';

-- 9
SELECT COUNT(*)
FROM tags
WHERE tag_name = 'AI';
