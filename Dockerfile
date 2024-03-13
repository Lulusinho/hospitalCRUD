FROM eclipse-temurin:21.0.2_13-jre-alpine
WORKDIR /app

FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN sudo apt install maven