package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        int ch;
        StringBuilder profile = new StringBuilder();
        try (FileInputStream stream = new FileInputStream(file))
        {
            while ((ch = stream.read())!=-1)
            {
                profile.append(ch);
            }
            System.out.println(profile);
        }
        catch (IOException ee)
        {
            System.out.println(ee.getMessage());
        }
        return new Profile();
    }
}
