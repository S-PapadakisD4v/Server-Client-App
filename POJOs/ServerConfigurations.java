package POJOs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ServerConfigurations extends Configuration{
    private String ipAddress;
    private int portNumber;
    private String name;
    private String password;
    private int userPool;
    private boolean isMultithreaded;

    public ServerConfigurations(){
        super();
        this.loadDefaultValues();
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

    private void loadDefaultValues(){
        this.setIpAddress("127.0.0.1");    //localhost;
        this.setPortNumber(8080);
        this.setName("Randomix");
        this.setPassword("");               //passwordless
        this.setUserPool(10);
        this.setMultithreaded(true); //multithreaded
    }

    private void loadConfigs(String fileName) throws SecurityException,
                                                    FileNotFoundException,
                                                    IllegalArgumentException,
                                                    NullPointerException,
                                                    IOException
    {
        this.loadDefaultValues();
        super.loadFile(fileName);
        super.loadProperties();
        this.getProps().forEach(( k, v )->{
            String key = k.toString().trim();
            String propValue = v.toString().trim();
            switch (key) {
                case "ip.address":
                    if(!propValue.isEmpty() && propValue != null){
                        this.setIpAddress(propValue);
                    }
                    break;
                case "port.number":
                    if(!propValue.isEmpty() && propValue != null){
                        try{
                            this.setPortNumber((Integer.parseInt(propValue)));
                        }catch(NumberFormatException ex){}
                    }
                    break;
                case "server.name":
                    if(!propValue.isEmpty() && propValue != null){
                        this.setName(propValue);
                    }
                    break;
                case "password":
                    if(!propValue.isEmpty() && propValue != null){
                        this.setPassword(propValue);
                    }
                    break;
                case "user.pool":
                    if(!propValue.isEmpty() && propValue != null){
                        try{
                            int up = Integer.parseInt(propValue);
                            if(up > 0){
                                this.setUserPool(up);
                            }
                        }catch(NumberFormatException ex){}
                        if(this.getUserPool() > 1){
                            this.setMultithreaded(true);
                        }else{
                            this.setMultithreaded(false);
                        }
                    }
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
