import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.text.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitz on 04.02.17.
 */



public class InfluxCon{

    private String point;
    private StockData sdata;

    public InfluxCon(String point, StockData sdata){
        InfluxDB influxDB = InfluxDBFactory.connect("http://vhome.pw:8086", "root", "");
        String dbName = "Stock";
        influxDB.createDatabase("Stock");
        this.point = point;
        this.sdata = sdata;
    }

    public void writetoDB(StockData sdata){

        for(Data data : sdata.getData()) {
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            try{
                Date date = formatter.parse(data.getDay());

                Point point1 = Point.measurement(this.point)
                        .time(date.getTime(), TimeUnit.MILLISECONDS)
                        .addField("Name", sdata.getName())
                        .addField("EOD", data.getEndofDay())
                        .build();
            }
            catch (ParseException pexc){
                pexc.getMessage();
            }
        }
    }
}
