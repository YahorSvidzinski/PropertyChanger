package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyChanger {
    public void change (String name){
        Properties pro = new Properties();
        try(FileInputStream in = new FileInputStream(name)){

            JavaParser javaParser = new JavaParser();

            pro.load(in);
            System.out.println("All keys of the property file before changing : ");
            System.out.println(pro.keySet());
            Enumeration em = pro.keys();
            Properties props = new Properties();
            while(em.hasMoreElements()){
                String str = (String)em.nextElement();
                javaParser.parseFile();
                javaParser.changeFile(str);
                props.setProperty(StringCalc.done(str),pro.getProperty(str));
            }
            props.store(new FileOutputStream(new File(name)), "my interesting comment");
            System.out.println("Properties changed!Check your file.");

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
