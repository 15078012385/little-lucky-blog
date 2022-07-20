# docker-compose部署教程

-   博客打成jar包，**上传到linux.**

    ![image-20220720153821715](C:\Users\MyAsus\AppData\Roaming\Typora\typora-user-images\image-20220720153821715.png)

-------

-   Dockerfile文件，用来构建镜像  构建命令：**docker build -t myblog:1.0.0 .**

```dockerfile
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
```

-   docker-compose.yml，用来进行容器编排.  一件后台启动命令：**docker-compose up -d**

```yml
version: "3"

services:
  microService:
    image: myblog:1.0.0
    container_name: myblog
    ports:
      - "80:80"
    volumes:
      - /app/microService:/data
    networks:
      - lucky_six
    depends_on:
      - redis
      - mysql

  redis:
    image: redis
    ports:
      - "6379:6379"
    volumes:
      - /app/redis/redis.conf:/etc/redis/redis.conf
      - /app/redis/data:/data
    networks:
      - lucky_six
    command: redis-server /etc/redis/redis.conf

  mysql:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: 'root'
      MYSQL_ALLOW_EMPTY_PASSWORD: 'root'
    ports:
      - "3306:3306"
    volumes:
      - /app/mysql/db:/var/lib/mysql
      - /app/mysql/conf/my.cnf:/etc/my.cnf
      - /app/mysql/init:/docker-entrypoint-initdb.d
    networks:
      - lucky_six
    command: --default-authentication-plugin=mysql_native_password #解决外部无法访问

networks:
  lucky_six:
```

-   依赖mysql、redis，因此需要拉取这两个镜像。命令：
-   **docker pull mysql**
-   **docker pull redis**

-------

