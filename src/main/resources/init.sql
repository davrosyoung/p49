CREATE TABLE id_generation (
    id_name  TEXT NOT NULL,
    id_value NUMERIC,
    PRIMARY KEY (id_name)
);
INSERT INTO id_generation VALUES ('BaseEntity', 0);

CREATE TABLE account
(
    id integer primary key,
    code      text not null,
    parent_id integer,
    created timestamp,
    updated timestamp
);

CREATE TABLE account_user (
    id integer primary key,
    account_id integer,
    login text not null,
    first_name text not null,
    surname text not null,
    description text,
    email text,
    mobile text,
    created timestamp,
    updated timestamp
);

ALTER TABLE account_user ADD FOREIGN KEY (account_id) REFERENCES account(id);
 CREATE INDEX account_user_account_id_idx ON account_user(account_id);
