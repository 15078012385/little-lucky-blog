package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @description img
 * @date 2022-07-18
 */
@Data
@TableName("tb_img")
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 添加时间
     */
    private String addTime;

    public Img() {
    }
}
