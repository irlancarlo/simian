FROM openjdk:11
env home=/home/app
copy build/libs/application.jar $home/simian/application.jar
workdir $home/simian
expose 8080
cmd ["java", "-jar", "/home/app/simian/application.jar"]