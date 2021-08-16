package com.siemenscase.uniquenumberconsistanceofletter;

import com.siemenscase.uniquenumberconsistanceofletter.service.MinimumDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniqueNumberConsistanceOfLetterApplication implements CommandLineRunner {
	private MinimumDeletionService minimumDeletionService;

	@Autowired
	public void MinimumDeletionService(MinimumDeletionService minimumDeletionService){
		this.minimumDeletionService = minimumDeletionService;
	}


	public static void main(String[] args) {
		SpringApplication.run(UniqueNumberConsistanceOfLetterApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Integer> toBeDeletedNumberList = minimumDeletionService.getMinimumDeletionNumberList(args[0]);
		int order = 1;
		for(int number : toBeDeletedNumberList){
			System.out.println(order + "- " + number);
			++order;
		}

	}
}
