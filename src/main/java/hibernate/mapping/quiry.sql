create table terminal(
  id varchar(5),
  vin varchar(5)
);

create table company(
  id varchar(5),
  name varchar(5)
);

create table terminal_company(
  id varchar(5),
  terminal_id varchar(5),
  company_id varchar(5)
);
