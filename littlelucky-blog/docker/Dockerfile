#基础镜像
FROM openjdk:11
 # 设置时区-否则时间慢8小时
ENV TZ="Asia/Shanghai"
#作者
MAINTAINER xiaochen
#将jar包添加到容器中
ADD littlelucky-blog-0.0.1-SNAPSHOT.jar littlelucky-blog-0.0.1-SNAPSHOT.jar
#运行jar包
RUN bash -c 'touch /littlelucky-blog-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/littlelucky-blog-0.0.1-SNAPSHOT.jar"]
EXPOSE 80

