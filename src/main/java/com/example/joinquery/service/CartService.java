package com.example.joinquery.service;

import com.example.joinquery.dto.requestDTO.CartRequestDTO;
import com.example.joinquery.dto.requestDTO.RequestIsExistCartDTO;

import java.util.List;

public interface CartService {
    String saveCart(CartRequestDTO dto);

    List<RequestIsExistCartDTO> getAllCartDetails(String cartId);
}
