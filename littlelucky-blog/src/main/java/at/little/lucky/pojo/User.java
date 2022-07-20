package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description user
 * @author xiaochen
 * @date 2022-07-16
 */
@Data
@AllArgsConstructor
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
    * id
    */
    private Integer id;

    /**
    * 账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 头像
    */
    private String avatar;

    public User() {}
}
