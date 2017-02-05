/**
 * Created by wvitz on 08.01.2017.
 */
public class Runner {

    public static void main(String[] args) {

        StockData fb = JsParser.parse("https://www.quandl.com/api/v3/datasets/WIKI/FB.json?api_key=st8QyFGnDamzVaazAxK7");

        StockData atx =  JsParser.parse("https://www.quandl.com/api/v3/datasets/WIKI/GOOGL.json?api_key=st8QyFGnDamzVaazAxK7");

        //InfluxCon influxcon = new InfluxCon();


        System.out.println("fam");
    }
}
