import java.io.*;
import java.util.Scanner;

import POJOs.ServerConfigurations;

public class Server {
    static ServerConfigurations config;
    public static void main(String[] args){
        config = new ServerConfigurations();
        System.out.println(config.toString());
    }
}
