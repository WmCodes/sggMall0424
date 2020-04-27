package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author drafter
 * @date 2020/4/26
 * @desciption
 */
@Data
public class UserAddress  implements Serializable {

    @Column
    @Id
    private String id;

    @Column
    private String userAddress;

    @Column
    private String userId;

    @Column
    private String consignee;

    @Column
    private String phoneNum;

    @Column
    private String isDefault;

}
