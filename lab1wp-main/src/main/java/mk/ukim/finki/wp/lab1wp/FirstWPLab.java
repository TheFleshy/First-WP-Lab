package mk.ukim.finki.wp.lab1wp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FirstWPLab {

    public static void main(String[] args) {
        SpringApplication.run(FirstWPLab.class, args);
    }

}
