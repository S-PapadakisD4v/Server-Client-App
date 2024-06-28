package POJOs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.lang.SecurityException;

public class Configuration {
    Properties props;
    FileInputStream fis;
    String fileName;

    public Configuration(){
        this.setProps(new Properties());
    }

    public Properties getProps() {
        return this.props;
    }

    private void setProps(Properties props) {
        this.props = props;
    }

    public FileInputStream getFis() {
        return this.fis;
    }

    private void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public String getFileName() {
        return this.fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void loadFile(String fileName) throws FileNotFoundException,
                                                SecurityException
    {
        this.setFileName(fileName);
        this.setFis(new FileInputStream(this.fileName));
    }

    public void loadProperties() throws IOException,
                                        IllegalArgumentException,
                                        NullPointerException
    {
        this.props.load(this.fis);
    }
}
