#!/bin/bash

set -ex;

exec /usr/bin/java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap ${JAVA_OPTS} \
     	-Djava.security.egd=file:/dev/./urandom \
     	-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.4.jar \
        -Dpinpoint.agentId=etax-datapool \
        -Dpinpoint.applicationName=etax-datapool \
     	-jar /app/etax-datapool/app.jar ${RUN_ARGS} "$@"