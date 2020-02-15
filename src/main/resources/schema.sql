drop table IF EXISTS AUTHORS cascade;
drop table IF EXISTS BOOKS cascade;
drop table IF EXISTS GENRES cascade;
drop table IF EXISTS COMMENTS cascade;
drop table IF EXISTS AUTHORS_BOOKS cascade;
drop table IF EXISTS GENRES_BOOKS cascade;

create TABLE "AUTHORS" (
  "ID" SERIAL PRIMARY KEY NOT NULL,
  "FIRST_NAME" varchar NOT NULL,
  "LAST_NAME" varchar NOT NULL,
  "CREATED_AT" datetime NOT NULL DEFAULT (now())
);

create TABLE "GENRES" (
  "ID" SERIAL PRIMARY KEY NOT NULL,
  "GENRE_NAME" varchar NOT NULL,
  "CREATED_AT" datetime NOT NULL DEFAULT (now())
);

create TABLE "BOOKS" (
  "ID" SERIAL PRIMARY KEY NOT NULL,
  "BOOK_TITLE" varchar NOT NULL,
  "CREATED_AT" datetime NOT NULL DEFAULT (now())
);

CREATE TABLE "COMMENTS" (
  "ID" SERIAL PRIMARY KEY NOT NULL,
  "COMMENT_TEXT" varchar NOT NULL,
  "CREATED_AT" datetime NOT NULL DEFAULT (now()),
  "BOOK_ID" int
);

create TABLE "AUTHORS_BOOKS" (
  "AUTHOR_ID" int,
  "BOOK_ID" int
);

create TABLE "GENRES_BOOKS" (
  "BOOK_ID" int,
  "GENRE_ID" int
);

alter table "AUTHORS_BOOKS" add FOREIGN KEY ("AUTHOR_ID") REFERENCES "AUTHORS" ("ID");

alter table "AUTHORS_BOOKS" add FOREIGN KEY ("BOOK_ID") REFERENCES "BOOKS" ("ID");

alter table "GENRES_BOOKS" add FOREIGN KEY ("BOOK_ID") REFERENCES "BOOKS" ("ID");

alter table "GENRES_BOOKS" add FOREIGN KEY ("GENRE_ID") REFERENCES "GENRES" ("ID");

ALTER TABLE "COMMENTS" ADD FOREIGN KEY ("BOOK_ID") REFERENCES "BOOKS" ("ID");