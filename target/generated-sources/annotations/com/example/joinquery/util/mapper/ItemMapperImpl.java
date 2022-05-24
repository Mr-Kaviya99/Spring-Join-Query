package com.example.joinquery.util.mapper;

import com.example.joinquery.dto.CartDTO;
import com.example.joinquery.dto.ItemDTO;
import com.example.joinquery.entity.Cart;
import com.example.joinquery.entity.Item;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-24T15:59:38+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toItem(ItemDTO itemDTO) {
        if ( itemDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemId( itemDTO.getItemId() );
        item.setItemName( itemDTO.getItemName() );
        item.setItemDescription( itemDTO.getItemDescription() );
        item.setItemQty( itemDTO.getItemQty() );
        item.setCarts( cartDTOToCart( itemDTO.getCarts() ) );

        return item;
    }

    protected Cart cartDTOToCart(CartDTO cartDTO) {
        if ( cartDTO == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartDTO.getCartId() );
        cart.setCartName( cartDTO.getCartName() );
        cart.setCartDescription( cartDTO.getCartDescription() );
        cart.setCartAddress( cartDTO.getCartAddress() );

        return cart;
    }
}
