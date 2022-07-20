package at.little.lucky.controller;

import at.little.lucky.pojo.User;
import at.little.lucky.service.UserService;
import at.little.lucky.utils.MD5;
import at.little.lucky.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 16:20
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    //    盐值
    private static String salt = "Make in xiaochen";

    @Autowired
    private UserService userService;

    /**
     * @param user
     * @param
     * @description: 登录
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 16:31
     */
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpSession session) {
//        实例化====>条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        通过username字段查找用户
        wrapper.eq("username", user.getUsername());
//      传入条件构造器
        User one = userService.getOne(wrapper);
//        如果用户非空，则校验密码信息
        if (one != null) {
            if (one.getPassword().equals(MD5.encrypt(salt + user.getPassword() + salt))) {
//                将用户登录信息、用session存储
                session.setAttribute("user", one);
//                ------
                return new RespResult<>(200, "登录成功", one, 0L);
            }
        }
        return new RespResult<>(500, "登录失败，信息有误。", null, 0L);
    }


    /**
     * @param httpServletRequest
     * @description: ajxa异步发退出登录请求、
     * @return: java.lang.Object
     * @author: xiaochen
     * @time: 2022/7/16 16:30
     */
    @GetMapping("/logout")
    public Object logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
//        移除用户信息
        session.removeAttribute("user");
        return new RespResult<>(200, "退出成功", null, 0L);
    }


}
