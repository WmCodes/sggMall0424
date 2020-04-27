package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author drafter
 * @date 2020/4/26
 * @desciption
 */
@Data
public class BaseAttrInfo implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String sttrName;

    @Column
    private String catalog3Id;

    @Transient
    private List<BaseAttrValue> attrValueList;
}
