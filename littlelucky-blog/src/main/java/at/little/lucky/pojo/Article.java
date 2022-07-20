package at.little.lucky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaochen
 * @description article
 * @date 2022-07-16
 */

@Data
@AllArgsConstructor
@TableName("tb_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 文章id
     */
    private Integer id;

    /**
     * 发布用户id
     */
    private Integer userId;

    /**
     * 发布用户昵称
     */
    private String userNickname;

    /**
     * 发布用户头像
     */
    private String userAvatar;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 首图
     */
    private String firstImg;

    /**
     * 发布状态
     */
    private String publish;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 浏览量
     */
    private Integer views;

    /**
     * 分类
     */
    private String category;

    public Article() {
    }

}
