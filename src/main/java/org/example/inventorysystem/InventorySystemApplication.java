package org.example.inventorysystem;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventorysystem.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor

public class InventorySystemApplication  {


    public static void main(String[] args) {
        SpringApplication.run(InventorySystemApplication.class, args);
    }


}
