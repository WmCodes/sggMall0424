package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@Data
public class SpuSaleAttr implements Serializable {

    @Id
    @Column
    private String id;


    @Column
    private String spuId;

    @Column
    private String saleAttrId;

    @Column
    private String saleAttrName;

    @Transient
    List<SpuSaleAttrValue> spuSaleAttrValueList;
}
