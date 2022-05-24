package com.example.joinquery.controller;

import com.example.joinquery.dto.requestDTO.ItemRequestDTO;
import com.example.joinquery.service.ItemService;
import com.example.joinquery.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {
    private final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/create/item", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StandardResponse> saveItem(@Valid @RequestBody ItemRequestDTO dto) {
        String saveItemId = itemService.saveItem(dto);
        LOGGER.info("Cart Successfully Saved!, Id:" + saveItemId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,
                "Cart Saved!",
                saveItemId),
                HttpStatus.CREATED);
    }
}
