package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Logger;


public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());


    public Profile getDataFromFile(File file) {
        String name = null, email = null;
        long number = 0;
        int age = 18;
        int ch;
        StringBuilder profile = new StringBuilder();
        try (InputStreamReader stream = new InputStreamReader(new FileInputStream(file))) {
            while ((ch = stream.read()) != -1) {
                profile.append((char) ch);
            }
            String[] arrayProfile = profile.toString().split(": ");

            String[] name1 = (arrayProfile[1]).split("\n");
            name = name1[0].trim();

            String[] age1 = (arrayProfile[2]).split("\n");
            age = Integer.parseInt(age1[0].trim());

            String[] email1 = (arrayProfile[3]).split("\n");
            email = email1[0].trim();

            String[] n1 = (arrayProfile[4]).split("\n");
            number = Long.parseLong(n1[0].trim());

        } catch (IOException ee) {
            logger.info(ee.getMessage());
        }

        return new Profile(name, age, email, number);
    }

}
