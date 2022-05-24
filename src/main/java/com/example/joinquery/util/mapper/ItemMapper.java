package com.example.joinquery.util.mapper;

import com.example.joinquery.dto.ItemDTO;
import com.example.joinquery.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toItem(ItemDTO itemDTO);
}
