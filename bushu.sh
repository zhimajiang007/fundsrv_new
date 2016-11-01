sh /Users/chenlong/mydev/tomcat/tomcat7/bin/shutdown.sh
rm -fr /Users/chenlong/mydev/tomcat/tomcat7/webapps/fundsrv
rm -fr /Users/chenlong/mydev/tomcat/tomcat7/webapps/fundsrv.war
mvn clean package -DskipTests=true
cp /Users/chenlong/homaer/projects/fundsrv/fundsrv-web-home/target/fundsrv.war /Users/chenlong/mydev/tomcat/tomcat7/webapps/
sh /Users/chenlong/mydev/tomcat/tomcat7/bin/shutdown.sh && sh /Users/chenlong/mydev/tomcat/tomcat7/bin/startup.sh
