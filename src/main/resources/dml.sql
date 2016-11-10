INSERT INTO author (first_name, last_name, middle_name) VALUES ('Michael', 'Bulgakov', 'Afanasievich');
INSERT INTO author (first_name, last_name) VALUES ('George', 'Orwell');
INSERT INTO author (first_name, last_name, middle_name) VALUES ('Arkady', 'Strugatsky', 'Natanovich');
INSERT INTO author (first_name, last_name, middle_name) VALUES ('Boris', 'Strugatsky', 'Natanovich');
INSERT INTO author (first_name, last_name, middle_name) VALUES ('Leo', 'Tolstoy', 'Nikolaevich');

INSERT INTO category (name) VALUES ('Fantastic');
INSERT INTO category (name) VALUES ('Novel');

INSERT INTO book (name, category_id) VALUES ('The Master and Margarita', 1);
INSERT INTO book (name, category_id) VALUES ('The Master and Margarita', 1);
INSERT INTO book (name, category_id) VALUES ('The Master and Margarita', 1);
INSERT INTO book (name, category_id) VALUES ('1984', 1);
INSERT INTO book (name, category_id) VALUES ('1984', 1);
INSERT INTO book (name, category_id) VALUES ('Definitely Maybe', 1);
INSERT INTO book (name, category_id) VALUES ('War and Peace', 2);

INSERT INTO book_author (book_id, author_id) VALUES (1, 1);
INSERT INTO book_author (book_id, author_id) VALUES (2, 1);
INSERT INTO book_author (book_id, author_id) VALUES (3, 1);
INSERT INTO book_author (book_id, author_id) VALUES (4, 2);
INSERT INTO book_author (book_id, author_id) VALUES (5, 2);
INSERT INTO book_author (book_id, author_id) VALUES (6, 3);
INSERT INTO book_author (book_id, author_id) VALUES (6, 4);
INSERT INTO book_author (book_id, author_id) VALUES (7, 5);

INSERT INTO cell (name, book_id) VALUES ('f0001', 3);
INSERT INTO cell (name, book_id) VALUES ('f0002', 7);
INSERT INTO cell (name, book_id) VALUES ('f0003', 1);
INSERT INTO cell (name, book_id) VALUES ('f0004', 6);
INSERT INTO cell (name, book_id) VALUES ('f0005', 4);
INSERT INTO cell (name, book_id) VALUES ('f0006', 5);
INSERT INTO cell (name) VALUES ('f0007');
INSERT INTO cell (name) VALUES ('f0008');

INSERT INTO user (nickname, password) VALUES ('ivanivanov86@mail.ru', 'ivan86ivanov');
INSERT INTO user (nickname, password) VALUES ('petrpetrov91@mail.ru', 'petrovPet9');
INSERT INTO user (nickname, password) VALUES ('alex78alex@rambler.ru', 'alex78ynvyc8');
INSERT INTO user (nickname, password) VALUES ('mariyaplehana', 'mapl');
INSERT INTO user (nickname, password) VALUES ('lizatholotar', 'lizolot');
INSERT INTO user (nickname, password) VALUES ('root', 'root');

INSERT INTO client (first_name, last_name , phone_number, user_id) VALUES ('Ivan', 'Ivanov', '0612896178', 1);
INSERT INTO client (first_name, last_name , phone_number, user_id) VALUES ('Peter', 'Petrov', '0612896178', 2);
INSERT INTO client (first_name, last_name , phone_number, user_id) VALUES ('Alexander', 'Ivanov', '0889438722', 3);

INSERT INTO admin (first_name, last_name , middle_name, user_id) VALUES ('Maria', 'Plekhanov', 'Igorevna', 4);
INSERT INTO admin (first_name, last_name , middle_name, user_id) VALUES ('Elizabeth', 'Zolotar', 'Petrovna', 5);
INSERT INTO admin (first_name, last_name , middle_name, user_id) VALUES ('Edward', 'Arsenyev', 'Vladimirovich', 6);

INSERT INTO journal (book_id, client_id , admin_id, date_issue, date_return, date_fact_return) VALUES (6, 3, 1, '2016-05-22 14:38:45', '2016-06-01 14:38:45', '2016-05-28 14:38:45');
INSERT INTO journal (book_id, client_id , admin_id, date_issue, date_return, date_fact_return) VALUES (1, 2, 2, '2016-05-23 14:38:45', '2016-06-02 14:38:45', '2016-05-25 14:38:45');
INSERT INTO journal (book_id, client_id , admin_id, date_issue, date_return) VALUES (2, 1, 2, '2016-05-24 14:38:45', '2016-06-03 14:38:45');

INSERT INTO role (name) VALUES ('Reader'), ('Administrator'), ('Director');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1), (2, 1), (3, 1);
INSERT INTO user_role (user_id, role_id) VALUES (4, 1), (4, 2), (5, 1), (5, 2), (6, 1), (6, 2), (6, 3);

