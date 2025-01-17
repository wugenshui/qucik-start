# 基础镜像，这是分阶段构建的前期阶段
FROM openjdk:8u212-jdk-stretch as builder
# 执行工作目录
WORKDIR application
# 配置参数
ARG JAR_FILE=*.jar
# 将编译构建得到的jar文件复制到镜像空间中
COPY ${JAR_FILE} application.jar
# 通过工具spring-boot-jarmode-layertools从application.jar中提取拆分后的构建结果
RUN java -Djarmode=layertools -jar application.jar extract

# 正式构建依赖镜像，也可自行调整为其它可用镜像，例如：openjdk:8-jdk、openjdk:8-jre-slim、openjdk:8-jre-alpine
FROM openjdk:8-jre

ENV LANG C.UTF-8

# 设置容器时间
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
# 设置容器时区
RUN echo 'Asia/Shanghai' >/etc/timezone

# JAVA运行参数
ENV JAVA_OPTS=""

# APP运行参数
ENV APP_OPTS=""

WORKDIR application

# 前一阶段从jar中提取除了多个文件，这里分别执行COPY命令复制到镜像空间中，每次COPY都是一个layer
COPY --from=builder application/dependencies/ ./
RUN true
COPY --from=builder application/spring-boot-loader/ ./
RUN true
COPY --from=builder application/snapshot-dependencies/ ./
RUN true
COPY --from=builder application/application/ ./
RUN true

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS org.springframework.boot.loader.JarLauncher $APP_OPTS"]