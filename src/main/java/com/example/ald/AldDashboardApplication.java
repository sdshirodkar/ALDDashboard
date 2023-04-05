package com.example.ald;

import com.example.ald.repository.AldRepository;
import com.example.ald.repository.DLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;

@SpringBootApplication
public class AldDashboardApplication {

	@Autowired
	private AldRepository aldRepository;

	@Autowired
	private DLRepository dlRepository;
	public static void main(String[] args) {

		SpringApplication.run(AldDashboardApplication.class, args);

	}

	public ArrayList<Integer> getDataFromString(String str){
		ArrayList<Integer> finalData = new ArrayList();
		for(int i =0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch!=','){
				int data = ch - '0';
				finalData.add(data);

			}
		}
		return finalData;
	}



	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//
//			String op = aldRepository.getCollDefFieldIds();
//
//			System.out.println(aldRepository.getCollDeffData(getDataFromString(op)));
//			ArrayList<Integer> getCollDelfAL =
//			System.out.println(output);
//			dlRepository.testDB();
//			dlRepository.testCPRDB();
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

		};
	}

}
