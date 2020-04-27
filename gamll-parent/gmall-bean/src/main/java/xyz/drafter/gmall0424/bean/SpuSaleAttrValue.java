package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@Data
public class SpuSaleAttrValue implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String spuId;

    @Column
    private String saleAttrId;

    @Column
    private String saleAttrValueNmae;

    //当前的属性值是否被选中
    @Transient
    private String idChecked;
}
