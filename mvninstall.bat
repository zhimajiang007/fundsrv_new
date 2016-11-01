rem mvn install:install-file -DgroupId=QRCode -DartifactId=QRCode -Dversion=0.9 -Dpackaging=jar -Dfile=E:/uniexpay/qrcode.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ib.client -DartifactId=ibclient -Dversion=1.0.0 -Dpackaging=jar -Dfile=ibclient-1.0.0-SNAPSHOT.jar -DgeneratePom=true

call mvn install:install-file -DgroupId=cn.jpush.api -DartifactId=jpush -Dversion=3.2.9 -Dpackaging=jar -Dfile=jpush-client-3.2.9.jar -DgeneratePom=true
