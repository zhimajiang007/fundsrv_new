call mvn clean package -DskipTests=true
call mvn jetty:run -Dmaven.test.skip=true