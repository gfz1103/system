from blueuninfo-registry.com:5000/oracle-java-font:8
MAINTAINER yueyu <yueyu@blueuninfo.com>
ENV LANG=en_US.UTF-8
ENV TZ=Asia/Shanghai
workdir /
run bash -c 'mkdir -p /pic/temp'
run bash -c 'mkdir -p /pic/formal'
add system-service.jar system.jar
#"-Dspring.profiles.active=$active"
cmd ["java","-jar","/system.jar"]