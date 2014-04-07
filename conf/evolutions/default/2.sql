# --- Sample dataset
# --- !Ups

insert into stock_broker (id, name, odd_lot_market_fee, default_lot_market_fee) values (1, 'Ativa Trade', 4.40, 15);
insert into stock_book (id, name, description, color) values (1, 'Carteira de Dividendos', 'Blablablablabla blablalbalbl', '#FFFFFF');

insert into quote (code, last_value, last_update) values ('PETR4F', 10.10, '2014-03-21 17:57:33');
insert into quote (code, last_value, last_update) values ('GFSA3F', 3.68, '2014-03-21 17:59:34');

insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (1, 'PETR4F', '2013-08-10 00:00:00.000', 13.56, 25, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (2, 'PETR4F', '2013-09-23 00:00:00.000', 14.45, 13, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (3, 'PETR4F', '2013-10-25 00:00:00.000', 11.08, 50, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (4, 'GFSA3F', '2013-10-04 00:00:00.000', 3.95, 50, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (5, 'GFSA3F', '2012-01-11 00:00:00.000', 3.65, 50, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (6, 'GFSA3F', '2013-06-12 00:00:00.000', 3.23, 65, null, null, 1, 1, 'O');
insert into trade_log (id, quote_code, entry_date, entry_quote, quantity, exit_date, exit_quote, stock_book_id, stock_broker_id, lot_type) values (7, 'GFSA3F', '2013-07-03 00:00:00.000', 2.60, 35, null, null, 1, 1, 'O');


# --- !Downs
delete from trade_log;
delete from quote;
delete from stock_broker;
delete from stock_book;
