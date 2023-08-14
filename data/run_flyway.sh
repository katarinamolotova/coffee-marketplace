#!/bin/bash

mvn clean flyway:migrate -Dflyway.configFiles=./src/main/resources/application.properties
