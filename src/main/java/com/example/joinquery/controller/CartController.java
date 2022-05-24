package com.example.joinquery.controller;

import com.example.joinquery.dto.requestDTO.CartRequestDTO;
import com.example.joinquery.dto.requestDTO.RequestIsExistCartDTO;
import com.example.joinquery.service.CartService;
import com.example.joinquery.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/cart")
public class CartController {
    private final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/create/cart", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StandardResponse> saveCart(@Valid @RequestBody CartRequestDTO dto) {
        String saveCartId = cartService.saveCart(dto);
        LOGGER.info("Cart Successfully Saved!, Id:" + saveCartId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,
                "Cart Saved!",
                saveCartId),
                HttpStatus.CREATED);
    }

    @GetMapping(
            path = {"/getbyId"},
            params = {"cartId"})
    public ResponseEntity<StandardResponse> getDetails(@RequestParam(value = "cartId") String cartId) {
        List<RequestIsExistCartDTO> requestIsExistCartDTOList = cartService.getAllCartDetails(cartId);

        return new ResponseEntity(new StandardResponse(200, "Success!", requestIsExistCartDTOList), HttpStatus.OK);
//        return new ResponseEntity(new StandardResponse(200, "Success!", cartService.isExistsAccountWithUserId(userId)), HttpStatus.OK);

    }


}
