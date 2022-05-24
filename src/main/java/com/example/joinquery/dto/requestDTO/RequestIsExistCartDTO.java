package com.example.joinquery.dto.requestDTO;

import com.example.joinquery.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestIsExistCartDTO implements SuperDTO {

    private String cartId;
    private String cartName;
    private String cartDescription;
    private String cartAddress;
    private String itemId;
    private String itemName;
    private String itemDescription;
    private int itemQty;

}
