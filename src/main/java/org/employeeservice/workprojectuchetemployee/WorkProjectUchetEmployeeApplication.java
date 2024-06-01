package org.employeeservice.workprojectuchetemployee;

import org.employeeservice.workprojectuchetemployee.kafka.ConsumerApi;
import org.employeeservice.workprojectuchetemployee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WorkProjectUchetEmployeeApplication implements CommandLineRunner {
	private final EmployeeServiceImpl employeeService;



	@Autowired
    public WorkProjectUchetEmployeeApplication(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WorkProjectUchetEmployeeApplication.class, args);

		ConsumerApi consumerApi = context.getBean(ConsumerApi.class);

	System.out.println(consumerApi.getMessages().toString());



	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
	/*	employeeService.createEmployee(new Employee(UUID.randomUUID().toString(), "Стропольщик", "Sergey", "Zatsepin", "Alexsandrovich", LocalDate.of(1971, 6, 1), "Стропольщик", true, true, LocalDate.of(2016, 6, 20), 1L, LocalDate.of(2016, 6, 20), false, null, null, false, null, null, 0));
		employeeService.createEmployee(new Employee(UUID.randomUUID().toString(), "Крановщик", "Nokolay", "Sidorov", "Petrovich", LocalDate.of(1972, 6, 1), "Крановщик", true, true, LocalDate.of(2015, 6, 20), 1L, LocalDate.of(2017, 6, 20), false, null, null, false, null, null, 0));
		employeeService.createEmployee(new Employee(UUID.randomUUID().toString(), "Стропольщик", "Mandubeck", "Zimerhanov", "Ivanovich", LocalDate.of(1972, 6, 1), "Крановщик", true, true, LocalDate.of(2016, 4, 10), 1L, LocalDate.of(2016, 4, 10), false, null, null, false, null, null, 0));*/
	}

}

