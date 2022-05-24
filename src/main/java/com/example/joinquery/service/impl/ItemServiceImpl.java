package com.example.joinquery.service.impl;

import com.example.joinquery.dto.ItemDTO;
import com.example.joinquery.dto.core.GeneratedIdentificationDTO;
import com.example.joinquery.dto.requestDTO.ItemRequestDTO;
import com.example.joinquery.exceptions.EntryDuplicationException;
import com.example.joinquery.repo.CartRepo;
import com.example.joinquery.repo.ItemRepo;
import com.example.joinquery.service.ItemService;
import com.example.joinquery.util.Generator;
import com.example.joinquery.util.mapper.CartMapper;
import com.example.joinquery.util.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private Generator generator;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public String saveItem(ItemRequestDTO dto) {
        GeneratedIdentificationDTO generatorId = generator.createId();

        ItemDTO itemDTO = new ItemDTO(
                generatorId.getPrefix() + "-ITEM-" + generatorId.getId(),
                dto.getItemName(),
                dto.getItemDescription(),
                dto.getItemQty(),
                cartMapper.toCartDto(cartRepo.getById(dto.getCarts()))

        );

        if (!itemRepo.existsById(itemDTO.getItemId())) {
            return itemRepo.save(itemMapper.toItem(itemDTO)).getItemId();
        } else {
            throw new EntryDuplicationException("Already exits");
        }
    }
}
