@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  CheckInApi startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CHECK_IN_API_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\check-in-api-1.0-plain.jar;%APP_HOME%\lib\CheckIn.Infraestructure-1.0-plain.jar;%APP_HOME%\lib\CheckIn.Application-1.0-SNAPSHOT.jar;%APP_HOME%\lib\CheckInDomain-1.0-SNAPSHOT.jar;%APP_HOME%\lib\ShareKernel-1.0-SNAPSHOT.jar;%APP_HOME%\lib\spring-boot-starter-web-2.6.7.jar;%APP_HOME%\lib\springdoc-openapi-ui-1.6.8.jar;%APP_HOME%\lib\spring-cloud-starter-aws-messaging-2.2.6.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-aws-2.2.6.RELEASE.jar;%APP_HOME%\lib\webjars-locator-core-0.48.jar;%APP_HOME%\lib\spring-boot-starter-json-2.6.7.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.2.jar;%APP_HOME%\lib\springdoc-openapi-webmvc-core-1.6.8.jar;%APP_HOME%\lib\springdoc-openapi-common-1.6.8.jar;%APP_HOME%\lib\swagger-core-2.2.0.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.2.jar;%APP_HOME%\lib\spring-cloud-aws-autoconfigure-2.2.6.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-messaging-2.2.6.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-context-2.2.6.RELEASE.jar;%APP_HOME%\lib\spring-cloud-aws-core-2.2.6.RELEASE.jar;%APP_HOME%\lib\aws-java-sdk-sns-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-sqs-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-ec2-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-cloudformation-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.11.792.jar;%APP_HOME%\lib\aws-java-sdk-core-1.11.792.jar;%APP_HOME%\lib\jmespath-java-1.11.792.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.2.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.13.2.jar;%APP_HOME%\lib\jackson-databind-2.13.2.1.jar;%APP_HOME%\lib\swagger-models-2.2.0.jar;%APP_HOME%\lib\jackson-annotations-2.13.2.jar;%APP_HOME%\lib\jackson-core-2.13.4.jar;%APP_HOME%\lib\postgresql-42.3.4.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.6.7.jar;%APP_HOME%\lib\pipelinr-0.7.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.6.7.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.6.7.jar;%APP_HOME%\lib\spring-boot-starter-2.6.7.jar;%APP_HOME%\lib\spring-webmvc-5.3.19.jar;%APP_HOME%\lib\spring-data-jpa-2.6.4.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.6.7.jar;%APP_HOME%\lib\spring-boot-2.6.7.jar;%APP_HOME%\lib\spring-context-5.3.19.jar;%APP_HOME%\lib\spring-orm-5.3.19.jar;%APP_HOME%\lib\spring-jdbc-5.3.19.jar;%APP_HOME%\lib\spring-tx-5.3.19.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.6.7.jar;%APP_HOME%\lib\spring-web-5.3.19.jar;%APP_HOME%\lib\swagger-ui-4.10.3.jar;%APP_HOME%\lib\classgraph-4.8.143.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\spring-data-commons-2.6.4.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.6.7.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\hibernate-core-5.6.8.Final.jar;%APP_HOME%\lib\spring-aspects-5.3.19.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\spring-aop-5.3.19.jar;%APP_HOME%\lib\spring-messaging-5.3.19.jar;%APP_HOME%\lib\spring-beans-5.3.19.jar;%APP_HOME%\lib\spring-expression-5.3.19.jar;%APP_HOME%\lib\spring-core-5.3.19.jar;%APP_HOME%\lib\snakeyaml-1.29.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.62.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.62.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.62.jar;%APP_HOME%\lib\aspectjweaver-1.9.7.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\byte-buddy-1.11.22.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jaxb-runtime-2.3.6.jar;%APP_HOME%\lib\spring-jcl-5.3.19.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\txw2-2.3.6.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.12.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\swagger-annotations-2.2.0.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.8.1.jar;%APP_HOME%\lib\httpcore-4.4.15.jar;%APP_HOME%\lib\commons-codec-1.15.jar


@rem Execute CheckInApi
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CHECK_IN_API_OPTS%  -classpath "%CLASSPATH%" com.nur.CheckInApiApplication %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable CHECK_IN_API_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%CHECK_IN_API_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
