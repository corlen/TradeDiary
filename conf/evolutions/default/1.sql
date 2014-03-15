# --- First database schema

# --- !Ups

CREATE TABLE stock_book
(
  id bigint NOT NULL,
  name varchar(255) NOT NULL,
  CONSTRAINT stock_book_pkey PRIMARY KEY (id)
);

CREATE TABLE stock_broker
(
  id bigint NOT NULL,
  name character varying(255),
  odd_lot_market_fee numeric,
  default_lot_market_fee numeric,
  CONSTRAINT stock_broker_pkey PRIMARY KEY (id)
);

CREATE TABLE trade_log
(
   id bigint NOT NULL,
   stock_name character varying(255) NOT NULL,
   entry_date date NOT NULL,
   entry_quote numeric,
   quantity bigint NOT NULL,
   exit_date date,
   exit_quote numeric,
   stock_book_id bigint,
   stock_broker_id bigint,
   CONSTRAINT trade_log_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE stock_book_sequence start with 1;
CREATE SEQUENCE stock_broker_sequence start with 1;
CREATE SEQUENCE trade_log_sequence start with 1;

alter table trade_log
    add constraint fk_trade_log_stock_book_1
    foreign key (stock_book_id)
    references stock_book (id)
    on delete restrict on update restrict;

alter table trade_log
    add constraint fk_trade_log_stock_broker_1
    foreign key (stock_broker_id)
    references stock_broker (id)
    on delete restrict on update restrict;

# --- !Downs

drop table if exists stock_book;
drop table if exists stock_broker;
drop table if exists trade_log;

drop sequence if exists stock_book_sequence;
drop sequence if exists stock_broker_sequence;
drop sequence if exists trade_log_sequence;