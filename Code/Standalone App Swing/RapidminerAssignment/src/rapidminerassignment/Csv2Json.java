package rapidminerassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.json.JSONArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kantr2
 */
public class Csv2Json {

    public JSONArray convertTojson(File f) throws FileNotFoundException {

        JSONArray rows = new JSONArray();
        Scanner sc = new Scanner(f);
        Pattern csvPattern = Pattern.compile("[;,]");
        while (sc.hasNextLine()) {
            String temp[] = csvPattern.split(sc.nextLine());
            /* De-limiter could be dynamic.
             And regex pattern could be used to handle corner 
             cases like enclosed quotes in data.  Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");           
             */
            JSONArray cols = new JSONArray();
            for (String s : temp) {
                String s2 = s.replaceAll("\"", "");
                try {
                    Double d = Double.parseDouble(s2);
                    cols.put(d);
                } catch (Exception e) {
                    cols.put(s2);
                }

            }
            rows.put(cols);
        }

        return rows;
    }

}
