FROM openjdk:8
# 作者
MAINTAINER mrli
# 系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8  TIME_ZONE=Asia/Shanghai
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /docker/tmps
# 将jar包添加到容器中并更名为app.jar
ADD wzk-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]