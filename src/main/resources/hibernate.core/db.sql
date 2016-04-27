create table contact(
  id SERIAL PRIMARY KEY ,
  first_name VARCHAR(60) NOT NULL ,
  last_name VARCHAR(40) NOT NULL ,
  birth_date DATE,
  version int not NULL DEFAULT 0
);

create table hobby(
  hobby_id VARCHAR(20) NOT NULL PRIMARY KEY
);

create table contact_tel_detail(
  id SERIAL PRIMARY KEY ,
  contact_id int NOT NULL ,
  tel_type varchar(20) NOT NULL ,
  tel_number VARCHAR(20) NOT NULL ,
  version int NOT NULL DEFAULT 0,
  CONSTRAINT FK_CONTACT_TEL_DETAIL_l FOREIGN KEY (contact_id) REFERENCES contact(id)
);

create TABLE contact_hobby_detail(
  contact_id int NOT NULL ,
  hobby_id  VARCHAR(20) NOT NULL ,
  CONSTRAINT PK PRIMARY KEY (contact_id, hobby_id),
  CONSTRAINT FK_CONTACT_НОВВУ_DETAIL_1 FOREIGN KEY (contact_id) REFERENCES contact(id) ON DELETE CASCADE ,
  CONSTRAINT fk_contact_hobby_detail_2 FOREIGN KEY (hobby_id) REFERENCES hobby(hobby_id)
);

ALTER TABLE contact_tel_detail ALTER COLUMN contact_id DROP NOT NULL ;