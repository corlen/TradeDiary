# --- Sample dataset
# --- !Ups

insert into stock_broker (id, name, odd_lot_market_fee, default_lot_market_fee) values (1, 'Ativa Trade', 4.40, 15);
insert into stock_book (id, name) values (1, 'Carteira de Dividendos');

insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (1, 'PETR4F', '2013-08-10 00:00:00.000', 13.56, 25, null, null, 1, 1);
insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (2, 'PETR4F', '2013-09-23 00:00:00.000', 14.45, 13, null, null, 1, 1);
insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (3, 'PETR4F', '2013-10-25 00:00:00.000', 11.08, 50, null, null, 1, 1);
insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (4, 'GFSA3F', '2013-02-27 00:00:00.000', 3.65, 15, null, null, 1, 1);
insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (5, 'GFSA3F', '2013-04-28 00:00:00.000', 2.98, 23, null, null, 1, 1);
insert into trade_log (id, stock_name, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id) values (6, 'GFSA3F', '2013-06-27 00:00:00.000', 3.89, 11, null, null, 1, 1);


# --- !Downs
delete from trade_log;
delete from stock_broker;
delete from stock_book;