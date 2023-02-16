--insert
/**********************user insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');
/**********************product insert************************/


insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '조은의자chair1', 550000, 'chair1.jpeg','조은의자입니다..', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '더조은의자chair2', 500000, 'chair2.jpeg','더조은의자입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '게임의자chair3', 400000, 'chair3.jpeg','게임의자입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '조은침대bed1', 450000, 'chair4.jpeg','의자입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '더조은침대bed2', 800000, 'chair5.jpeg','조은침대입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '게임침대bed3', 700000, 'chair6.jpeg','더조은침대입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '책상desk1', 800000, 'chair7.jpeg','게임침대입니다.', 0);
insert into product_furniture values(product_furniture_p_no_SEQ.nextval, '조은책상desk1', 800000, 'chair8.jpeg','책상입니다.', 0);
commit;
/*********************cart insert****************************/
--guard1님 카트
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,2,1,'guard1');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,1,3,'guard1');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,1,7,'guard1');
--guard2님 카트
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,1,7,'guard2');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,1,8,'guard2');
commit;
desc cart;

/*************************order insert*********************************/
--1. order insert
insert into orders(o_no,o_desc,o_date,o_price,userid) 
values(orders_o_no_SEQ.nextval,'비글외1종',sysdate,1350000,'guard1');
--order_item insert(비글 1)
insert into order_item(oi_no,oi_qty,o_no,p_no) 
values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
--order_item insert(닥스훈트 1)
insert into order_item(oi_no,oi_qty,o_no,p_no) 
values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,7);


--2. order insert
insert into orders(o_no,o_desc,o_date,o_price,userid) 
values(orders_o_no_SEQ.nextval,'달마시안외1종',sysdate,900000,'guard1');
--order_item insert(달마시안 1)
insert into order_item(oi_no,oi_qty,o_no,p_no) 
values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
--order_item insert(퍼그 2)
insert into order_item(oi_no,oi_qty,o_no,p_no) 
values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,3);




commit;




