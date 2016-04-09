package br.ucb.noqueue.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilitarios {
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "../configUCB/config.properties");
        props.load(file);
        return props;
    }

}
