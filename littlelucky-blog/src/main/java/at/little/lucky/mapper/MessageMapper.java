package at.little.lucky.mapper;

import at.little.lucky.pojo.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description messageMapper
 * @author xiaochen
 * @date 2022-07-16
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {


}
