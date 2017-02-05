import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.*;

/**
 * Created by vitz on 04.02.17.
 */
public class JsParser {

    public static StockData parse(String sURL){

        StockData sdata = new StockData();

        try{

            JSONObject rootobj = readJsonFromUrl(sURL);

            JSONObject datasetobj = rootobj.getJSONObject("dataset");

            sdata.setDataset_code(datasetobj.getString("dataset_code"));
            sdata.setId(datasetobj.getString("id"));
            sdata.setName(datasetobj.getString("name"));

            JSONArray dataarr = datasetobj.getJSONArray("data");

            for(int i = 0; i < dataarr.length(); i++){
                Data data = new Data();
                JSONArray ar = dataarr.getJSONArray(i);
                data.setDay(ar.get(0).toString());
                data.setEndofDay(ar.get(1).toString());

                sdata.addtoArr(data);
            }

        }
        catch (IOException ioex){
            ioex.getMessage();
        }
        catch (JSONException jsonex){
            jsonex.getMessage();
        }
        return sdata;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
