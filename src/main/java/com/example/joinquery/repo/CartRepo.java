package com.example.joinquery.repo;

import com.example.joinquery.dto.QueryInterfaces.CartDetailsInterface;
import com.example.joinquery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, String> {

    @Query(value = "select c.cart_id as cartId,c.cart_cart_name as cartName,c.cart_description as CartDescription," +
            "c.cart_address as cartAddress,i.item_id as itemId,i.item_name as itemName,i.item_description as" +
            " ItemDescription,i.item_qty as itemQty from cart c,item i where c.cart_id=i.cart_id and c.cart_id=?1",nativeQuery = true)
    List<CartDetailsInterface> getALlCartDetails(String cartId);

}
