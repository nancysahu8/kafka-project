This project is designed to demonstrate the usage of Apache Kafka with String and JSON format as data in a Spring Boot application. It covers basic Kafka producer and consumer implementations with a focus on Java 17 and Spring Boot 3.4.2.

Prerequisites
Java 17 or above
Apache Kafka running locally or remotely
Maven 3.6+ (for project build)
Spring Boot 3.4.2

Project Structure
Producer: Sends messages to Kafka topics in String and JSON formats.
Consumer: Consumes messages from Kafka topics and processes them.

Getting Started

1. Clone the Repository
bash
Copy
[git clone https://github.com/your-username/kafka-learning.git](https://github.com/nancysahu8/kafka-project.git)
cd kafka-project

3. Configure Kafka
Make sure you have Apache Kafka running. If you are using a local Kafka server, you can run it using Docker or by manually setting it up. Here's an example of how to run Kafka on Window's command prompt:
Start Zookeeper 
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Start Broker server
.\bin\windows\kafka-server-start.bat .\config\server.properties

You can also follow the Kafka quickstart for manual installation.

3. Configure Application Properties
Edit src/main/resources/application.yml or application.properties to set up your Kafka broker URL and other related configurations.

Example application.yml:

yaml
Copy
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: my-group
      auto-offset-reset: earliest
    producer:
      bootstrap-servers: localhost:9092
      
4. Run the Application
You can run the Spring Boot application by executing:

bash
Copy
mvn spring-boot:run

5. Test the Kafka Producer and Consumer
The application includes two components:

Producer: Sends String and JSON messages to Kafka topics.
Consumer: Consumes messages from Kafka topics and logs them.
You can trigger the producer to send messages by invoking REST endpoints or by calling the producer service directly.

Producer Example (REST Endpoint)
The producer exposes a REST endpoint to send messages to a Kafka topic. The endpoint can send both String and JSON formatted messages.

POST: /api/v1/kafkaMessage/publish

Payload example:
json
Copy
"Hello, Kafka!"

POST: /api/v1/kafkaMessages/publish

Payload example:
json
Copy
{
    "userId": 1,
    "firstName": "John",
    "lastName": "Doe"
}
Consumer
The consumer will automatically consume messages from the specified Kafka topics, print the consumed data to the logs, and process it accordingly.
Here's command to run consumer on window's command prompt - 
.\bin\windows\kafka-console-consumer.bat --topic javatopic --from-beginning --bootstrap-server localhost:9092
.\bin\windows\kafka-console-consumer.bat --topic javajsontopic --from-beginning --bootstrap-server localhost:9092


6. View Logs
Kafka consumer logs will be available in the application console. You can see the consumed messages as they are processed by the consumer.

Project Dependencies
Spring Boot 3.4.2
Apache Kafka Client
Spring Kafka
Jackson (for JSON serialization/deserialization)
Maven
Here are the key dependencies in pom.xml:

xml
Copy
<dependencies>
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
        <version>3.4.2</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.15.1</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>


Troubleshooting

Ensure that Kafka is running and reachable on the configured bootstrap-servers.
Check if the topics exist. If not, create them manually or configure auto-creation in Kafka.
Ensure the correct group-id and auto-offset-reset settings for consumers.
Contributing
If you want to contribute to this project, please fork it and create a pull request with your changes.

License

This project is licensed under the MIT License - see the LICENSE file for details.

Let me know if you need any modifications or additional sections!
