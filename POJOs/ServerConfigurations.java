package POJOs;

import java.util.ArrayList;

public class ServerConfigurations {
    private String ipAddress;
    private int portNumber;
    private String name;
    private String password;
    private int userPool;
    private boolean isMultithreaded;

    public ServerConfigurations(){
        this.ipAddress = "127.0.0.1";        //localhost
        this.portNumber = 8080;
        this.name = "Randomix";
        this.password = null;         //passwordless
        this.userPool = 10;
        this.isMultithreaded = true;    //multithreaded
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
