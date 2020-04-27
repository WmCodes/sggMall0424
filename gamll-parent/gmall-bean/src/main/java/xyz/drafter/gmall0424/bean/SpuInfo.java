package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@Data
public class SpuInfo implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String spuName;

    @Column
    private String description;

    @Column
    private String catalog3Id;

    @Transient
    private List<SpuSaleAttr> spuSaleAttrList;

    @Transient
    private List<SpuImange> spuImangeList;
}
