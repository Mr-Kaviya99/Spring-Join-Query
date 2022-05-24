package com.example.joinquery.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Cart {

    @Id
    @Column(name = "cart_id", length = 45)
    private String cartId;

    @Column(name = "cart_cart_name", length = 100)
    private String cartName;

    @Column(name = "cart_description", length = 100)
    private String cartDescription;

    @Column(name = "cart_address", length = 100)
    private String cartAddress;

    @OneToMany(mappedBy = "carts")
    private Set<Item> items;

}
