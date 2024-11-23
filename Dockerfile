# Build stage
FROM maven:3.8.6-amazoncorretto-17 as build

# Копируем pom.xml в рабочую директорию
COPY pom.xml /build/

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /build/

# Скачиваем все зависимости в оффлайн-режиме
RUN mvn dependency:go-offline

COPY src /build/src/

# Собираем проект с помощью Maven без выполнения тестов
RUN mvn package -DskipTests

#Run stage
FROM openjdk:17-alpine

# Объявляем переменную сборки для JAR-файла
ARG JAR_FILE=/build/target/*.jar

# Копируем собранный JAR-файл из стадии сборки
COPY --from=build $JAR_FILE /opt/TaskManagerSystems/app.jar

# Указываем команду, которая будет запускаться при старте контейнера
ENTRYPOINT ["java", "-jar", "/opt/TaskManagerSystems/app.jar"]


