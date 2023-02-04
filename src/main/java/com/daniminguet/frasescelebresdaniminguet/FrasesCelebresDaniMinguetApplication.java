package com.daniminguet.frasescelebresdaniminguet;

import com.daniminguet.frasescelebresdaniminguet.util.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrasesCelebresDaniMinguetApplication implements CommandLineRunner {

    public static boolean DEBUG = true;
    public static String CONFIG_FILE =  null;

    public static void main(String[] args) {
        SpringApplication.run(FrasesCelebresDaniMinguetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Log.i("TAG", "Texto cualquiera");
    }

}
