package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@Data
public class BaseSaleAttr implements Serializable {

    @Id
    @Column
    private String id;


    @Column
    private String name;
}
