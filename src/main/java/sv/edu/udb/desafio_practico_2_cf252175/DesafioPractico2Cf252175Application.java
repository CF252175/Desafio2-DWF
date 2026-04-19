package sv.edu.udb.desafio_practico_2_cf252175;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioPractico2Cf252175Application {

    public static void main(String[] args) {
        SpringApplication.run(DesafioPractico2Cf252175Application.class, args);

        System.out.println("--------------------------------------------------");
        System.out.println("¡El sistema está corriendo");
        System.out.println("Accede a Swagger en: http://localhost:8080/swagger-ui/index.html");
        System.out.println("--------------------------------------------------");
    }

}