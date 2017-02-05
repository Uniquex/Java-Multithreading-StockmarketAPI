import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by vitz on 04.02.17.
 */


public class APIFetcher implements Runnable {

    // 7
    private final String apiKEY = "st8QyFGnDamzVaazAxK";
    private String url;

    private boolean isRunning;

    public APIFetcher(String url){
            this.url = url;
    }

    @Override
    public void run() {

        StockData sdata = JsParser.parse(this.url);


    }





    public void setRunning(Boolean status)
    {
        this.isRunning = status;
    }
}
