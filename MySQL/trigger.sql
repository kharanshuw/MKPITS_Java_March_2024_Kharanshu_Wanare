DELIMITER //
Create Trigger before_UPDATE_PRODUCTS   
BEFORE INSERT ON SALES FOR EACH ROW  
BEGIN  
UPDATE PRODUCTS SET QUANTITY_ON_HAND=QUANTITY_ON_HAND-NEW.QUANTITY
WHERE PRODUCTID=NEW.PRODUCTID ;    
END//

------------------------------------------------------------------
DELIMITER --
Create Trigger after_insert_sales
AFTER INSERT ON sale FOR EACH ROW
BEGIN 
UPDATE productmaster
SET qty_on_hand=qty_on_hand-NEW.QUANTITY
WHERE product_id=NEW.product_id
END --

DELIMITER ;

INSERT INTO student.sale
VALUES('sa006','p006',2,3,curdate());

--------------------------------------------------------------------

DELIMITER --

Create Trigger after_transaction_deposit
AFTER INSERT on transactions FOR EACH ROW
BEGIN
UPDATE ACCOUNT
SET balance=balance+NEW.amount
WHERE Account_No=NEW.Account_No;
END --

DELIMITER ;

INSERT INTO student.transactions
VALUES(7,4,250,deposit,curdate());


-----------------------------------------------------------------------



DELIMITER --

Create Trigger after_transaction_withdraw
AFTER INSERT on transactions FOR EACH ROW
BEGIN
if new.transaction_type="withdrawl" 
then
update account 
set balance = balance-new.amount
WHERE Account_No=NEW.Account_No;

else
update account 
set balance = balance+new.amount
where account_no=new.account_no;
end if;
END --

DELIMITER ;



ALTER transactions
drop CONSTRAINTS ch_type 