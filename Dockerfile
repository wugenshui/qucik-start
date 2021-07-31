# 基础镜像，也可自行调整为其它可用镜像，例如：openjdk:8-jdk、openjdk:8-jre-slim、openjdk:8-jre-alpine等
FROM openjdk:8-jre

ENV LANG C.UTF-8

ENV APP_HOME=/usr/local

ENV TIMEZONE=Asia/Shanghai

# JAVA运行参数
ENV JAVA_OPTS=""

# APP运行参数
ENV APP_OPTS=""

# 设置容器时间
RUN ln -sf /usr/share/zoneinfo/$TIMEZONE /etc/localtime

# 设置容器时区
RUN echo $TIMEZONE >/etc/timezone

WORKDIR $APP_HOME

RUN chmod -R 755 $APP_HOME

# EXPOSE 8080

# server-eureka-1.0 是构建后 JAR 包名称,例如 sdms-order-service-1.0.0
COPY "*.jar" "app.jar"

ENTRYPOINT "sh" "-c" "java $JAVA_OPTS -jar app.jar $APP_OPTS"