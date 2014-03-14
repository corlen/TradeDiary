# --- First database schema

# --- !Ups

CREATE TABLE stock_book
(
  id bigint NOT NULL,
  name varchar(255) NOT NULL,
  CONSTRAINT stock_book_pkey PRIMARY KEY (id)
)

CREATE TABLE stock_broker
(
  id bigint NOT NULL,
  name character varying(255),
  odd_lot_market_fee numeric,
  default_lot_market_fee numeric,
  CONSTRAINT stock_broker_pkey PRIMARY KEY (id)
)




# --- !Downs

drop table if exists stock_book;

drop table if exists stock_broker;