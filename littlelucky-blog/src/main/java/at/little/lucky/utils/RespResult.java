package at.little.lucky.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 11:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespResult<T> {
    private Integer code;
    private String msg;
    private T data;
    private Long total;
}

