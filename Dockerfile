FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src ./src

RUN mkdir -p out

RUN javac -d out $(find src -name "*.java")

CMD ["java", "-cp", "out", "Main"]
