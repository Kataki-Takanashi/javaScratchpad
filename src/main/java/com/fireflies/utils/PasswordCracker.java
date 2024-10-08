package com.fireflies.utils;

import java.util.Random;

public class PasswordCracker {

    // Method to crack the password
    public static void crackPassword(String target) {
        String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;'<>,.?/ ";
        char[] current = new char[target.length()];
        Random random = new Random();
        int counter = 0;

        // Initialize the 'current' array with random characters
        for (int i = 0; i < target.length(); i++) {
            current[i] = CHARS.charAt(random.nextInt(CHARS.length()));
        }

        // Start cracking the password character by character
        for (int index = 0; index < target.length(); index++) {
            while (current[index] != target.charAt(index)) {
                // Randomize the current character until it matches the target
                current[index] = CHARS.charAt(random.nextInt(CHARS.length()));
                counter++;

                // Randomize characters to the right of the current index
                for (int i = index + 1; i < target.length(); i++) {
                    current[i] = CHARS.charAt(random.nextInt(CHARS.length()));
                }

                // Display the progress in place
                System.out.print("Cracked! The password is " + new String(current) +
                        " and took " + counter + " attempts.\r");

                try {
                    Thread.sleep(10);  // Pause for 0.01 seconds (10 milliseconds)
                } catch (InterruptedException e) {
                    // Handle the exception if necessary (e.g., restore interrupted status)
                    Thread.currentThread().interrupt();
                }
            }
        }

        // Print the final result outside the loop to ensure it shows up
        System.out.println("Cracked! The password is " + new String(current) +
                " and took " + counter + " attempts.");
    }
}