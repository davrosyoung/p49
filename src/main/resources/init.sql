CREATE TABLE account
(
    id integer primary key,
    code      text not null,
    parent integer,
    created timestamp,
    updated timestamp
);

CREATE TABLE "user" (
    id integer primary key,
    account_id integer,
    login text not null,
    first_name text not null,
    surname text not null,
    description text,
    email text,
    mobile text
);