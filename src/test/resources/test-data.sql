insert into AUTHORS (first_name,last_name) values ('author1', 'one');
insert into AUTHORS (first_name,last_name) values ('author2', 'two');
insert into AUTHORS (first_name,last_name) values ('author3', 'three');

insert into GENRES (genre_name) values ('romantical');
insert into GENRES (genre_name) values ('documental');
insert into GENRES (genre_name) values ('humorous');


insert into BOOKS (book_title,genre_id,author_id) values ('book-1',1,1);
insert into BOOKS (book_title,genre_id,author_id) values ('book-2',1,2);
insert into BOOKS (book_title,genre_id,author_id) values ('book-3',2,2);
insert into BOOKS (book_title,genre_id,author_id) values ('book-1',2,3);
insert into BOOKS (book_title,genre_id,author_id) values ('book-2',3,3);
insert into BOOKS (book_title,genre_id,author_id) values ('book-3',3,1);