package org.example.infrastructure.logging;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTestLogger implements TestLogger {

    private static int counter = 0;


    private String fileName = "";
   private static final String HEADER = "<html><head><title></title></head><body><ul>";
   private static final String FOOTER = "</ul></body></html>";


    public FileTestLogger() {

        fileName = "log.html";
       // fileName = "log_" + System.currentTimeMillis() + ".html";

        FileWriter fw = null;

        try {
            fw = new FileWriter(new File(fileName), true);

            fw.write(HEADER);

        } catch (IOException e) {
            counter ++;
            System.out.println("Exception # " + counter);
            e.printStackTrace();
        }finally {
            if(fw != null){

            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void log(String msg) {
        try {
            FileWriter fw = new FileWriter(new File(fileName), true);

            fw.write("<li>" + msg +"</li>");

            fw.close();
        } catch (IOException e) {
            counter ++;
            System.out.println("Exception # " + counter);
            e.printStackTrace();
        }
    }

    public void endFile(){
        try {
            FileWriter fw = new FileWriter(new File(fileName), true);

            fw.write(FOOTER);

            fw.close();
        } catch (IOException e) {
            counter ++;
            System.out.println("Exception # " + counter);
            e.printStackTrace();
        }

    }
}

