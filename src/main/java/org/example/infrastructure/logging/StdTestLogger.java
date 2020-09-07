package org.example.infrastructure.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdTestLogger implements TestLogger {

    int step = 0;

    protected String getEntry(String msg){
        step++;


        String logEntry = "";

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        String time = sdf.format(new Date());

        String methodName = Thread.currentThread().getName();
        logEntry += step + ") " + time + " [" + methodName + "]: " + msg;


        return logEntry;
    }


    @Override
    public void log(String msg) {
        System.out.println(getEntry(msg));


    }
}
