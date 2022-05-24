package com.example.joinquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String itemId;

    private String itemName;

    private String itemDescription;

    private int itemQty;

    private CartDTO carts;

}
