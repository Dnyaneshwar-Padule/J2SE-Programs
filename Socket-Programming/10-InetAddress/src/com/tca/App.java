package  com.tca;

import java.net.InetAddress;

public class App{
    public static void main(String[] args)  throws  Exception{
        InetAddress address = InetAddress.getByName("google.com");
        System.out.println(address.getHostAddress());
    }
} 