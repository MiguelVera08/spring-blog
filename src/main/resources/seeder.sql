USE post_db;

# DROP TABLE posts;
# DROP TABLE users;

INSERT INTO posts ( title, body, user_id)
VALUES
('Skateboard', 'Here is a Free Skateboard',1),
('Baseballs for sale', 'Free baseballs',1),
('Bud-Lights', 'come one come all for some free beer!!',1),
('Bailey', 'Getting rid of my pet crocodile',1),
('Lexie', 'Getting rid of my waifu pillow',1),
('Snickers', 'Selling Snickers by the dozen',1),
('Free Punches', 'come to my house to get punched',1),
('Barney', 'Vintage Barney episodes for sale',1),
('Bowser', 'Need help defeating bowser in Super Mario Bros.',1);

# INSERT INTO users (username, email, password) values
# ('TestMiguel','miguel@gmail.com', 'password');