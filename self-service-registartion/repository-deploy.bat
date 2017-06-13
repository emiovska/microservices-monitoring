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
SET /P _message= Please enter a commit message:
GIT commit -m "%_message%"
GIT push
ECHO.
ECHO Done
ECHO.
PAUSE
CLS
EXIT