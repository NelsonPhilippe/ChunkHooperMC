package fr.oceanquest.chunkhooper.utils;

import fr.oceanquest.chunkhooper.ChunkHooper;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class JSON {

    public static void set(String path, Map<String, Object> values) throws FileNotFoundException {

        File file = new File(ChunkHooper.getInstance().getDataFolder().getPath() + "/data.json");

        JSONObject obj = new JSONObject();


        for(Map.Entry<String, Object> value : values.entrySet()){
            obj.put(value.getKey(), value.getValue());
        }

        PrintWriter pw = new PrintWriter(file);
        pw.write(obj.toJSONString());

        pw.flush();
        pw.close();
    }

}
