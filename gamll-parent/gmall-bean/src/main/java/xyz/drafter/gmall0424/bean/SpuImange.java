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
public class SpuImange implements Serializable {

    @Column
    @Id
    private String id;

    @Column
    private String spuId;

    @Column
    private String imgName;

    @Column
    private String imgUrl;
}
