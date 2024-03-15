package org.example.intergicielterminal.view;

import org.example.intergicielterminal.service.Producter2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@SpringBootApplication
public class Console implements CommandLineRunner {

    @Autowired
    private Producter2 kafkaProducerService2;

    private static final String TOPIC = "TOPIC_2";

    public static void main(String[] args) {
        SpringApplication.run(Console.class, args);
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Entrez votre commande parmis : ");
                String command = scanner.nextLine();

                if ("exit".equalsIgnoreCase(command)) {
                    break; // Quitter la boucle si l'utilisateur entre 'exit'
                }

                // Utiliser le service de production pour envoyer la commande au topic Kafka
                kafkaProducerService2.sendMessage(command, TOPIC);
            }
        }
    }
}
