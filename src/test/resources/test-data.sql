insert into AUTHORS (first_name,last_name) values ('author1', 'one');
insert into AUTHORS (first_name,last_name) values ('author2', 'two');
insert into AUTHORS (first_name,last_name) values ('author3', 'three');

insert into GENRES (genre_name) values ('romantical');
insert into GENRES (genre_name) values ('documental');
insert into GENRES (genre_name) values ('humorous');


insert into BOOKS (book_title) values ('book-1');
insert into BOOKS (book_title) values ('book-2');
insert into BOOKS (book_title) values ('book-3');

insert into COMMENTS (comment_text,book_id) values
('comment1',1),('comment2',1),('comment3',1);

insert into AUTHORS_BOOKS (author_id,book_id) values (1,1);
insert into AUTHORS_BOOKS (author_id,book_id) values (1,2);
insert into AUTHORS_BOOKS (author_id,book_id) values (2,2);
insert into AUTHORS_BOOKS (author_id,book_id) values (3,1);
insert into AUTHORS_BOOKS (author_id,book_id) values (3,3);

insert into GENRES_BOOKS (book_id,genre_id) values (1,2);
insert into GENRES_BOOKS (book_id,genre_id) values (2,2);
insert into GENRES_BOOKS (book_id,genre_id) values (2,1);
insert into GENRES_BOOKS (book_id,genre_id) values (3,3);