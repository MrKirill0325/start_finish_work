package com.example.project.catalogs;

import java.io.*;
import java.util.List;

public class CatalogReader {

    public void read(List<String> list, String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
