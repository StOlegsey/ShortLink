FROM tomcat:10.1-jdk21
ADD target/ShortLink-1.war /usr/local/tomcat/webapps/ShortLink-1.war
EXPOSE 8080
CMD ["catalina.sh", "run"]