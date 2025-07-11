package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException; 

@SpringBootApplication
public class SpringLearnApplication {

    
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        
        LOGGER.info("Starting SpringLearnApplication main() method...");

        SpringApplication.run(SpringLearnApplication.class, args);

        
        displayDate();

        
        LOGGER.info("SpringLearnApplication main() method finished.");
    }

    private static void displayDate() {
        LOGGER.info("Starting displayDate() method...");

       
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        LOGGER.info("ApplicationContext loaded from date-format.xml.");

       
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        LOGGER.info("SimpleDateFormat bean 'dateFormat' retrieved from context.");

       
        String dateString = "31/12/2018";
        LOGGER.info("Attempting to parse date string: " + dateString);

        try {
            
            Date parsedDate = format.parse(dateString);

            
            System.out.println("Parsed Date: " + parsedDate);
            LOGGER.info("Successfully parsed date: " + parsedDate);

        } catch (ParseException e) {
          
            LOGGER.error("Error parsing date: " + dateString, e);
            System.err.println("Error parsing date: " + e.getMessage());
        } finally {
           
            if (context instanceof ClassPathXmlApplicationContext) {
                ((ClassPathXmlApplicationContext) context).close();
                LOGGER.info("ClassPathXmlApplicationContext closed.");
            }
        }

        LOGGER.info("Finished displayDate() method.");
    }
}
