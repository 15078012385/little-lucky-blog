package at.little.lucky.mapper;

import at.little.lucky.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description articleMapper
 * @author xiaochen
 * @date 2022-07-16
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {



}
