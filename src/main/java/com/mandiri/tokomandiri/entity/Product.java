package com.mandiri.tokomandiri.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mst_product")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@FilterDef(name = "deletedProductFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProductFilter", condition = "deleted = :isDeleted")
@SQLDelete(sql = "UPDATE mst_product SET deleted = true WHERE product_id=?")
@Where(clause = "deleted=false")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String productName;
    private Integer productPrice;
    @Column(nullable = false)
    private Integer stock;
    private boolean deleted = Boolean.FALSE;
}



