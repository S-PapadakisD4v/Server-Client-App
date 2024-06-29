import java.io.*;
import java.util.Scanner;

import POJOs.ServerConfigurations;

public class Server {
    private static ServerConfigurations config;
    private static final String CONFIG_FILE_NAME = "./configs/server.cfg";
    public static void main(String[] args){
        try{
            config = new ServerConfigurations(CONFIG_FILE_NAME);
            System.out.println(String.format("\nSERVER INFORMATIONS\n----------------------\n%s\n\n",config.toString()));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
