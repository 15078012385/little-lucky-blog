package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description log
 * @author xiaochen
 * @date 2022-07-16
 */
@Data
@TableName("tb_log")
public class Log implements Serializable {

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
    * 访问url
    */
    private String accessUrl;

    /**
    * 访问的方法
    */
    private String accessMethod;

    /**
    * 访问参数
    */
    private String accessArgs;

    /**
    * 访问时间
    */
    private Date accessTime;

    private String returnData;


    public Log() {}
}
