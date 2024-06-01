package org.employeeservice.workprojectuchetemployee.kafka;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.employeeservice.workprojectuchetemployee.DAO.EmployeeRepository;
import org.employeeservice.workprojectuchetemployee.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.*;

@Service
@AllArgsConstructor
public class ConsumerApi {
    public List<Employee> getMessages() {
        // Создание настроек для Kafka Consumer
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group1");

        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Подписка на топик
        consumer.subscribe(Collections.singleton("new-demo-topic"));

        List<Employee> messages = new ArrayList<>();

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

                for (ConsumerRecord<String, String> record : records) {
                    // Преобразование сообщения в объект Employee и добавление в список
                //    Employee employee = convertToEmployee(record.value());
                //    messages.add(employee);
                    System.out.println("сообщение прочитано! ");
                    System.out.println(record);

                }
            }
        } catch (Exception err) {
            // Обработка ошибок
            err.printStackTrace();
        } finally {
            consumer.close();
        }

        return messages;
    }

    private Employee convertToEmployee(String message) {


        // Логика преобразования сообщения в объект Employee
        // Ваш код здесь
        return new Employee();
    }
}
