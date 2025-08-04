package util;
import interfaces.Loggable;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Logger implements Loggable {
    @Override
    public  void log(String entry, String FileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName+".txt",true))) {
            bw.write(entry+"\n");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.getMessage();
       
    }
}
    @Override
    public  void read(String FileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName+".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }
    
}

