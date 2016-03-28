CREATE TABLE "user" (id SERIAL PRIMARY KEY, uid VARCHAR(64) UNIQUE NOT NULL, email VARCHAR(256) UNIQUE NOT NULL, password CHAR(60) NOT NULL);

CREATE TABLE "role" (
   id             SERIAL PRIMARY KEY
  ,  uid          VARCHAR(90) UNIQUE NOT NULL
  ,  description  VARCHAR(256) NOT NULL
);

CREATE TABLE  "user_role"  (
   user_id        INTEGER REFERENCES  "user" ( id ) ON UPDATE CASCADE ON DELETE CASCADE
  ,  role_id      INTEGER REFERENCES  "role"  ( id ) ON UPDATE CASCADE ON DELETE CASCADE
  , CONSTRAINT  USER_ROLE_PRIMARY_KEY  PRIMARY KEY ( user_id ,  role_id )
);


