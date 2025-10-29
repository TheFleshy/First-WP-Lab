package mk.ukim.finki.wp.firstlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FirstLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstLabApplication.class, args);
    }

}
