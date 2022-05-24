package com.example.joinquery.util.mapper;

import com.example.joinquery.dto.CartDTO;
import com.example.joinquery.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toCart(CartDTO cartDTO);
    CartDTO toCartDto(Cart cart);
}
