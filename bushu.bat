call rd /s/q E:\Tomcat\apache-tomcat-7.0.52-windows-x64\apache-tomcat-7.0.52\webapps\fundsrv
call del /f/s/q  E:\Tomcat\apache-tomcat-7.0.52-windows-x64\apache-tomcat-7.0.52\webapps\fundsrv.war
call mvn clean package -DskipTests=true
copy F:\homaer\fundsrv_new\fundsrv-web-home\target\fundsrv.war E:\Tomcat\apache-tomcat-7.0.52-windows-x64\apache-tomcat-7.0.52\webapps\
cd /d E:\Tomcat\apache-tomcat-7.0.52-windows-x64\apache-tomcat-7.0.52\bin\
call shutdown.bat
call startup.bat
cd /d F:\homaer\fundsrv_new
