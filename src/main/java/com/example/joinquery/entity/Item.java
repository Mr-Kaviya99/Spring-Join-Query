package com.example.joinquery.entity;


import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Item {

    @Id
    @Column(name = "item_id", length = 45)
    private String itemId;

    @Column(name = "item_name", length = 45)
    private String itemName;

    @Column(name = "item_description", length = 100)
    private String itemDescription;

    private int itemQty;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart carts;



}
