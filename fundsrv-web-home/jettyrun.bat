mvn clean compile -Dmaven.test.skip=true
mvn jetty:run-war -Dmaven.test.skip=true

mvn clean package -DskipTests jetty:run-war