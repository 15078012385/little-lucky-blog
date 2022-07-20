package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaochen
 * @description message
 * @date 2022-07-16
 */
@Data
@AllArgsConstructor
@TableName("tb_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 访问者ip
     */
    private String accessIp;

    /**
     * 留言内容
     */
    @NotEmpty
    private String messageContent;

    /**
     * 留言时间
     */
    private String messageTime;

    /**
     * 留言qq
     */
//    qq正则
    @Pattern(regexp = "[1-9]{1}[0-9]{4,11}", message = "QQ校验不通过")
    private String qq;

    /**
     * qq头像url
     */
    @TableField("qq_avatar")
    private String qlogo;

    /**
     * qq昵称
     */
    @TableField("qq_nickname")
    private String name;



    public Message() {
    }
}
