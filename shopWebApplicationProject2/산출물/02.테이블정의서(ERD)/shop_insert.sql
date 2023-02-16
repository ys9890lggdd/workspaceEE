/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************product insert************************/

insert into product_toy values(product_toy_p_no_SEQ.nextval, '호랑이', 50000, '0700000065282.jpg','귀여워요', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '토끼', 40000, '0700000065292.jpg','사랑스러워요.', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '곰돌이', 43000, '0700000065302.jpg','예뻐요', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '미니마우스', 35000, '0700000065312.jpg','든든해요..', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '미키마우스', 70000, '0700000065322.jpg','키우기쉬워요.', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '무우', 20000, '0700000065342.jpg','애교가많아요.', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '모자짱구', 53000, '0700000065412.jpg','멋있어요.', 0);
insert into product_toy values(product_toy_p_no_SEQ.nextval, '짱구', 34000, '0700000065422.jpg','용감해요.', 0);


/**********************cart insert************************/
insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'guard1',1,2);
insert into cart(cart_no,userId,p_no,cart_qty) 
values
(cart_cart_no_SEQ.nextval,'guard1',2,1);

insert into cart(cart_no,userId,p_no,cart_qty) 
values
(cart_cart_no_SEQ.nextval,'guard1',3,5);


insert into cart(cart_no,userId,p_no,cart_qty) 
values
(cart_cart_no_SEQ.nextval,'guard2',1,1);
insert into cart(cart_no,userId,p_no,cart_qty) 
values
(cart_cart_no_SEQ.nextval,'guard2',3,1);

/**********************orders insert************************/
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'곰돌이인형외1종',sysdate-2,1050000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'짱구인형외0종',sysdate-1,400000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);


insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'돼지인형외1종',sysdate,1450000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);



insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'달마시안외0종',sysdate-1,500000,'guard2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'비글외1종',sysdate,1000000,'guard2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);


commit;
desc order_item;


