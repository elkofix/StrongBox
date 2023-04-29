package com.example.fileviewer.model;

import java.io.*;

// patron singleton
public class FileManager {

    // unica instancia de la clase

    private static final String pathFile = System.getProperty("user.dir")+"/src/main/java/com/example/fileviewer/controller/Data.txt";
    private static final String passFile = System.getProperty("user.dir")+"/src/main/java/com/example/fileviewer/controller/password.txt";

    private static FileManager instance;

    //constructo privado

    private FileManager(){}

    //getInstance -> Obtener la unica instancia de la clase

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }
    public static String readFile(int files){
        String line = "";
        String content = "";
        try{
            File file = new File(pathFile);
            if(files != 1){
                file = new File(passFile);
            }
            BufferedReader bf= new BufferedReader(new FileReader(file));
            while ((line = bf.readLine()) != null){
                content += line + "\n";
            }
            bf.close();
        }catch(IOException e){
            e.getMessage();
            e.printStackTrace();
        }
        return content;
    }

    public static void writeFile(String data, int location){
        try {
            File file = new File(pathFile);
            if(location ==2){
                file = new File(passFile);
            }

            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(data);
            writer.flush();
            fos.close();
        }catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }

    }
}
