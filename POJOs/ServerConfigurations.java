package POJOs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ServerConfigurations extends Configuration{
    private String ipAddress = "127.0.0.1";     //localhost;
    private int portNumber = 8080;
    private String name = "Randomix";
    private String password = "";               //passwordless
    private int userPool = 10;
    private boolean isMultithreaded = true;     //multithreaded

    public ServerConfigurations(){
        super();
    }

    public ServerConfigurations(String fileName) throws SecurityException,
                                                        FileNotFoundException,
                                                        IllegalArgumentException,
                                                        NullPointerException,
                                                        IOException
    {
        super();
        this.loadConfigs(fileName);
    }

    private void loadConfigs(String fileName) throws SecurityException,
                                                    FileNotFoundException,
                                                    IllegalArgumentException,
                                                    NullPointerException,
                                                    IOException
    {
        super.loadFile(fileName);
        super.loadProperties();
        this.getProps().forEach(( k, v )->{
            String key = k.toString();
            switch (key) {
                case "ip.address":
                    this.setIpAddress(v.toString());
                    break;
                case "port.number":
                    this.setPortNumber((Integer.parseInt(v.toString())));
                    break;
                case "server.name":
                    this.setName(v.toString());
                    break;
                case "password":
                    this.setPassword(v.toString());
                    break;
                case "user.pool":
                    this.setUserPool((Integer.parseInt(v.toString())));
                    break;
                case "is.multithreaded":
                    this.setMultithreaded((Boolean.parseBoolean(v.toString())));
                    break;
                default:
                    break;
            }
        });
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserPool() {
        return userPool;
    }

    public void setUserPool(int userPool) {
        this.userPool = userPool;
    }

    public boolean isMultithreaded() {
        return isMultithreaded;
    }

    public void setMultithreaded(boolean isMultithreaded) {
        this.isMultithreaded = isMultithreaded;
    }

    public String toString(){
        ArrayList<String> messages = new ArrayList<String>();
        messages.add("Server Name\t>\t%s");
        messages.add("Ip Address\t>\t%s");
        messages.add("Port Number\t>\t%s");
        messages.add("Password\t>\t%s");
        messages.add("Multithreaded\t>\t%s");
        messages.add("User Pool\t>\t%s");

        String result = String.format(
                String.join("\n", messages),
                this.name,
                this.ipAddress,
                this.portNumber,
                this.password,
                this.isMultithreaded,
                this.userPool
                );

        return result;
    }
}
