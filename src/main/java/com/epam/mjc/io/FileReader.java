package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null, email = null;
        long number = 0;
        Integer age = 18;
        int ch;
        StringBuilder profile = new StringBuilder();
       /* try (InputStreamReader stream = new InputStreamReader(new FileInputStream(file)))
        {
            while ((ch = stream.read())!=-1)
            {
                profile.append(ch);
            }
            System.out.println(profile);
            String[] arrayProfile= (profile.toString()).split(": ");
            name = arrayProfile[0];
           // age = Integer.parseInt(arrayProfile[0]) ;
           // email = arrayProfile[0];
          //  number = Long.parseLong(arrayProfile[0]);
        }
        catch (IOException ee)
        {
            System.out.println(ee.getMessage());
        }*/
        try (InputStreamReader stream = new InputStreamReader(new FileInputStream(file))) {
            while ((ch = stream.read()) != -1) {
                profile.append((char) ch);
            }
            String[] arrayProfile = profile.toString().split(": ");


            String [] name1 = (arrayProfile[1].toString()).split("\n");
           System.out.print(name1[0]);
            name = name1[0].trim();

            String[] age1 = (arrayProfile[2].toString()).split("\n");
            System.out.print(age1[0]);
           age = Integer.parseInt(age1[0].trim());

            String[] email1 = (arrayProfile[3].toString()).split("\n");
            System.out.print(email1[0]);
            email = email1[0].trim();

            String[] n1 = (arrayProfile[4].toString()).split("\n");
            System.out.print(n1[0]);
           number = Long.parseLong(n1[0].trim());

        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }

        return new Profile(name, age, email, number);
    }

}
