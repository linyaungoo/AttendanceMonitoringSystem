import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class attdReport {
    String name,id,attd,date;
    ObservableList<ObservableList> row =
            FXCollections.observableArrayList();

    public void setRow(ObservableList<ObservableList> row) {
        this.row = row;
    }

    public attdReport(String name, String id, String attd, String date, ObservableList<ObservableList> row) {
        this.name = name;
        this.id = id;
        this.attd = attd;
        this.date = date;
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public ObservableList<ObservableList> getRow() {
        return row;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttd() {
        return attd;
    }

    public void setAttd(String attd) {
        this.attd = attd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public attdReport() {
        this.name = name;
        this.id = id;
        this.attd = attd;
        this.date = date;
    }
}

