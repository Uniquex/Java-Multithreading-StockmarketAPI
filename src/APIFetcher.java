import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by vitz on 04.02.17.
 */


public class APIFetcher implements Runnable {

    private final String apiKEY = "st8QyFGnDamzVaazAxK7";
    private String url;

    private boolean isRunning;

    public APIFetcher(String url){
            this.url = url;
    }

    @Override
    public void run() {


        StockData sdata = JsParser.parse(this.url+this.apiKEY);

        InfluxCon dbcon = new InfluxCon(sdata.getName(), sdata);
        dbcon.writetoDB(JsParser.parse(this.url));
    }

    public void setRunning(Boolean status)
    {
        this.isRunning = status;
    }
}
