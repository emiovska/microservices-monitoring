@ECHO OFF
ECHO.
ECHO Cleaning up
CALL MVN clean
ECHO.
ECHO Building JAR
CALL MVN install
ECHO.
ECHO Setting up for git
CD target
COPY *.jar ..\..\..\
CD ..\..\
GIT checkout lib-repository
GIT pull origin lib-repository
CD self-service-registartion
DEL *.jar
CD ..\..\
COPY *.jar microservices-monitoring\self-service-registartion\
DEL *.jar
CD microservices-monitoring\self-service-registartion
GIT add *.jar
GIT commit -m "[no-issue] repository version updated"
GIT push
ECHO.
ECHO Done
ECHO.
PAUSE
CLS
EXIT