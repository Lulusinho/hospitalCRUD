package GUI;

import java.sql.SQLException;

import DBhospital.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class Maintable {
  @FXML
  public TableView<Tableinfo> maintable;
  @FXML
  public TableColumn<Tableinfo, String> birth;
  @FXML
  public TableColumn<Tableinfo, String> cpf;
  @FXML
  public TableColumn<Tableinfo, String> date;
  @FXML
  public TableColumn<Tableinfo, String> doc;
  @FXML
  public TableColumn<Tableinfo, String> pacient;
  @FXML
  public TableColumn<Tableinfo, String> type;
  @FXML
  public ObservableList<Tableinfo> list;

  public void getcontent() {
    list = FXCollections.observableArrayList();

    var result = DAO.search();

    try {
      while (result.next()) {
        if (result.getString("doc") == null) {
          continue;
        }
        Tableinfo row = new Tableinfo(result.getString("birth"), result.getString("cpf"), result.getString("date"),
            result.getString("doc"), result.getString("pacient"), result.getString("type"));
        list.add(row);
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }
    result = DAO.search2();

    try {
      while (result.next()) {
        if (result.getString("doc") == null) {
          continue;
        }
        Tableinfo row = new Tableinfo(result.getString("birth"), result.getString("cpf"), result.getString("date"),
            result.getString("doc"), result.getString("pacient"), result.getString("type"));
        System.out.println(row.doc);
        list.add(row);
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }

  }

  @FXML
  public void initializetable() {
    birth.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("birth"));
    cpf.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("cpf"));
    date.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("date"));
    doc.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("doc"));
    pacient.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("pacient"));
    type.setCellValueFactory(new PropertyValueFactory<Tableinfo, String>("type"));
    getcontent();

    this.maintable.setItems(list);
  }

}
