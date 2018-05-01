# substratevm-netty-hello-world
Hello World HTTP Netty server running on [SubstrateVM] from the Graal project.

## License
[Apache 2.0]

# Obtain
The project is based on [Maven].

# Usage
Build SubstrateVM and get the [labs JDK], then set `JAVA_HOME`

> export JAVA_HOME=/usr/java/labsjdk1.8.0_161-jvmci-0.42/

Build this project using

> mvn clean package

then compile the [SubstrateVM] native image using

> native-image -cp ./target/substratevm-netty-hello-world-0.0.1-SNAPSHOT.jar com.github.graal.netty.HelloWorld -Dio.netty.noUnsafe=true -Djava.io.tmpdir=/tmp

Then run

> ./com.github.graal.netty.HelloWorld

and visit

http://localhost:8080

and observe response 'Hello World'. 

# History

 - 1.0.0: Initial version

[Apache 2.0]:          	http://www.apache.org/licenses/LICENSE-2.0.html
[issue-tracker]:       	https://github.com/skjolber/substratevm-netty-hello-world/issues
[Maven]:                http://maven.apache.org/
[1.0.0]:				https://github.com/skjolber/substratevm-netty-hello-world/releases/tag/substratevm-netty-hello-world-1.0.0
[SubstrateVM]:			https://github.com/oracle/graal/tree/master/substratevm
[labs JDK]:				http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads/index.html