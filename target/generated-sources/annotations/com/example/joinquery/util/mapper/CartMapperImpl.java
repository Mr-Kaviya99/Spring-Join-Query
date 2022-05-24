package com.example.joinquery.util.mapper;

import com.example.joinquery.dto.CartDTO;
import com.example.joinquery.entity.Cart;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-24T15:59:38+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart toCart(CartDTO cartDTO) {
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

    @Override
    public CartDTO toCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setCartId( cart.getCartId() );
        cartDTO.setCartName( cart.getCartName() );
        cartDTO.setCartDescription( cart.getCartDescription() );
        cartDTO.setCartAddress( cart.getCartAddress() );

        return cartDTO;
    }
}
