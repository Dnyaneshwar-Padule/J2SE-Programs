package com.tca;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class App{
    
    public static void main(String[] args) throws Exception{

        URL url = new URL("https://development.technocompacademy.com/images/courses/c.png");
        
        try(InputStream in = url.openStream()){
            FileOutputStream fout = new FileOutputStream("../response/c_.png");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while( ( bytesRead = in.read(buffer) )  != -1){
                fout.write(buffer, 0, bytesRead);
            }

            fout.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

/*

InputStream reads raw bytes, and BufferedReader encodes them and convert into a String

we should we BufferedInoutStream to read more bytes at a time, InputStream Reads byte by byte

*/