package com.example.joinquery.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    private String cartName;

    private String cartDescription;

    private String cartAddress;

}
