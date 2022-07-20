package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description category
 * @author xiaochen
 * @date 2022-07-16
 */
@Data
@AllArgsConstructor
@TableName("tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
    * id
    */
    private Integer id;

    /**
    * 类名
    */
    private String name;

    /**
    * 添加时间
    */
    private String createTime;

    /**
    * 修改时间
    */
    private String modifyTime;

    public Category() {}
}
