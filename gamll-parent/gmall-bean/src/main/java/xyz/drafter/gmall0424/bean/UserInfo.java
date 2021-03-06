package xyz.drafter.gmall0424.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author drafter
 * @date 2020/4/24
 * @desciption
 */
@Data
public class UserInfo implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 获取数据库主键自增
    private String id;

    @Column
    private String loginName;

    @Column
    private String nickName;

    @Column
    private String passwd;

    @Column
    private String name;

    @Column
    private String phoneNum;

    @Column
    private String email;

    @Column
    private String headImg;

    @Column
    private String userLevel;
}
