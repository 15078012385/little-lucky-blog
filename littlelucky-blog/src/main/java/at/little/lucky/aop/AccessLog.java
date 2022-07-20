package at.little.lucky.aop;

import java.util.Date;

import at.little.lucky.pojo.Log;
import at.little.lucky.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 17:14
 * 访问日志
 */
@Aspect
@Component
@Slf4j
public class AccessLog {

    @Autowired
    private LogService logService;

    private static Log dbLog = new Log();


    /**
     * @param joinPoint
     * @description: 前置处理
     * @return: void
     * @author: xiaochen
     * @time: 2022/7/16 17:21
     */
    @Before("execution(* at.little.lucky.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        dbLog.setAccessUrl(url);
        dbLog.setAccessMethod(classMethod);
        dbLog.setAccessArgs(args.toString());
        dbLog.setAccessTime(new Date());
//        log.info("-------------------------------------------");
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
            dbLog.setAccessIp("127.0.0.1");
//            log.info("Request : {}", new RequestLog(url, ip, classMethod, args));
//            log.warn("当前请求的ip地址 : {}", "127.0.0.1");
        } else {
//            log.info("Request : {}", new RequestLog(url, ip, classMethod, args));
//            log.warn("当前请求的ip地址 : {}", ip);
//            设置访问者ip
            dbLog.setAccessIp(ip);
        }
//        log.info("-------------------------------------------");
    }

    /**
     * @param result
     * @description: 后置处理
     * @return: void
     * @author: xiaochen
     * @time: 2022/7/16 17:22
     */
    @AfterReturning(returning = "result", pointcut = "execution(* at.little.lucky.controller.*.*(..))")
    public void doAfterReturn(Object result) {
//        log.info("-------------------------------------------");
        dbLog.setReturnData(result.toString());
//        log.info("Result : {}", result);
//        log.info("-------------------------------------------");
        logService.save(dbLog);
//        保存本次日志后，重置dblog.
        dbLog = new Log();
    }


}
