/***************************
카트
****************************/

---로그인한멤버(guard1)의 카트아이템리스트
select * from cart c 
join product p 
on c.p_no=p.p_no
where userid='guard1';

--로그인한멤버(guard1)의 카트아이템1개의 제품수량증감(cart_no로변경)
update cart set cart_qty=cart_qty+1 where cart_no=1;
update cart set cart_qty=cart_qty-1 where cart_no=1;

--로그인한멤버(guard1)의 카트아이템1개의 제품수량증가(p_no   로변경)
--제품이카트에있는경우 카트에추가(수량변경)
update cart set cart_qty=cart_qty+3 where userid='guard1' and p_no = 1;

--로그인한멤버(guard1)의 카트아이템1개삭제
delete from cart where cart_no=4;
--로그인한멤버(guard1)의 카트아이템전체삭제
delete from cart where userid='guard1';

/***************************
주문
****************************/
--로그인한멤버(guard1)의 주문전체목록
select * from orders where userid='guard1';
--로그인한멤버(guard1)의 주문한개목록
select * from orders o 
join order_item oi
on o.o_no=oi.o_no
join product p
on oi.p_no=p.p_no
where o.o_no=1;

--로그인한멤버(guard1)의 주문한개삭제
--on delete cascade(X)
delete from order_item where o_no=1;
delete from orders where o_no=1;

--on delete cascade(O)
delete from orders where o_no=1;

--로그인한멤버(guard1)의 주문전체삭제
--on delete cascade(X)
delete from order_item where o_no=2;
delete from order_item where o_no=5;
delete from orders where userid='guard1';


--on delete cascade(O)
delete from orders where userid='guard1'
