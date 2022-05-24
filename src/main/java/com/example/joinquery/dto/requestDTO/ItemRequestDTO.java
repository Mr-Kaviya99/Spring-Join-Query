package com.example.joinquery.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDTO {
    private String itemName;
    private String itemDescription;
    private int itemQty;
    private String carts;
}
