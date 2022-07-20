package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description timeline
 * @author xiaochen
 * @date 2022-07-16
 */
@Data
@AllArgsConstructor
@TableName("tb_timeline")
public class Timeline implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 内容
    */
    private String content;

    /**
    * 添加时间
    */
    private String createTime;

    /**
    * 名称
    */
    private String nickName;

    public Timeline() {}
}
