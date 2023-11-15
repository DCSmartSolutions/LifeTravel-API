package com.nexusnova.lifetravelapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping
    public Date test() {
        String hour = "01";
        String minute = "56";
        String dayTime = "AM";
        Date currentDate = new Date();

        // Create a string representing the time
        String timeString = hour + ":" + minute + " " + dayTime;

        // Define the format of the time string
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

        try {
            // Parse the time string to obtain a Date object
            Date parsedDate = dateFormat.parse(timeString);

            // Print the parsed Date object
            System.out.println("Parsed Date: " + parsedDate);

            // If you want to set the parsed time to the current date, you can do the following:
            currentDate.setHours(parsedDate.getHours());
            currentDate.setMinutes(parsedDate.getMinutes());

            // Print the updated Date object with the parsed time
            System.out.println("Updated Date: " + currentDate);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return currentDate;
    }
}
