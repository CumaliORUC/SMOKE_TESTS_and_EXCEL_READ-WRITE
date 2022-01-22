package utulities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        String path="src/Configuration.properties";

        try {
            FileInputStream fileinput=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileinput);
            fileinput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String key)
    {
        String value=properties.getProperty(key);
        return value;
    }
}