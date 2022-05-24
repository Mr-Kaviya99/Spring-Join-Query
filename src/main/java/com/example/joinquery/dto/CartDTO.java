package com.example.joinquery.dto;

import com.example.joinquery.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private String cartId;

    private String cartName;

    private String cartDescription;

    private String cartAddress;

}
