#!/bin/bash
./mvnw clean
./mvnw package
java -jar target/BillionProject-1.0-SNAPSHOT-spring-boot.jar -conf target/classes/team-system-config.json
