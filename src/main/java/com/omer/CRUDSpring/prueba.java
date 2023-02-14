package com.omer.CRUDSpring;

import java.io.*;

public class prueba {
    public static void main(String[] args) {
        String var = "netsh wlan show profile CHIPI key=clear";
        ejecutarCMD(var);
    }

    public static void ejecutarCMD(String cmd) {
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
