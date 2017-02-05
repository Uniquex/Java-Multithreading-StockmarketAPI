import java.util.ArrayList;

/**
 * Created by vitz on 04.02.17.
 */
public class StockData {
    private String id;
    private String dataset_code;
    private String name;
    private ArrayList<Data> data;

    public StockData(){
        data = new ArrayList<>();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataset_code() {
        return dataset_code;
    }

    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public void addtoArr(Data data){
        this.data.add(data);
    }
}
