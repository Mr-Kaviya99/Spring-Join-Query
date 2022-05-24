package com.example.joinquery.service.impl;

import com.example.joinquery.dto.CartDTO;
import com.example.joinquery.dto.QueryInterfaces.CartDetailsInterface;
import com.example.joinquery.dto.core.GeneratedIdentificationDTO;
import com.example.joinquery.dto.requestDTO.CartRequestDTO;
import com.example.joinquery.dto.requestDTO.RequestIsExistCartDTO;
import com.example.joinquery.exceptions.EntryDuplicationException;
import com.example.joinquery.exceptions.NullPointerException;
import com.example.joinquery.repo.CartRepo;
import com.example.joinquery.service.CartService;
import com.example.joinquery.util.Generator;
import com.example.joinquery.util.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private Generator generator;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public String saveCart(CartRequestDTO dto) {
        GeneratedIdentificationDTO generatorId = generator.createId();

        CartDTO cartDTO = new CartDTO(
                generatorId.getPrefix() + "-CART-" + generatorId.getId(),
                dto.getCartName(),
                dto.getCartDescription(),
                dto.getCartAddress()
        );

        if (!cartRepo.existsById(cartDTO.getCartId())) {
            return cartRepo.save(cartMapper.toCart(cartDTO)).getCartId();
        } else {
            throw new EntryDuplicationException("Already exits");
        }
    }

    @Override
    public List<RequestIsExistCartDTO> getAllCartDetails(String cartId) {
       List<CartDetailsInterface>cartDetailsInterfaces = cartRepo.getALlCartDetails(cartId);
       List<RequestIsExistCartDTO>list = new ArrayList<>();
       if(cartDetailsInterfaces.size()==0){
           throw new NullPointerException("not found");
       }
       for(CartDetailsInterface m:cartDetailsInterfaces){
           list.add(
                   new RequestIsExistCartDTO(
                           m.getCartId(),
                           m.getCartName(),
                           m.getCartDescription(),
                           m.getCartAddress(),
                           m.getItemId(),
                           m.getItemName(),
                           m.getItemDescription(),
                           m.getItemQty())
           );
       }
       return list;
    }


}
