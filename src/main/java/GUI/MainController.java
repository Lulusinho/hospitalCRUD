package GUI;

import java.net.URL;

import java.util.ResourceBundle;

import DBhospital.DAO;
import Person.*;
import Utils.Addres;
import Utils.Healthinsurance;
import Utils.Speciality;
import actions.Appointment;
import actions.Procedure;
import actions.Procedure.ProcedureBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class MainController extends Maintable implements Initializable {

  @FXML
  private TextField textcpf;
  @FXML
  private TextField textcrm;

  @FXML
  private Tab deletetab;

  @FXML
  private TextField textinsurancename;

  @FXML
  private Tab newregistration;

  @FXML
  private TextField textnumaddr;

  @FXML
  private TextField textpayment;

  @FXML
  private TextField textpersonname;

  @FXML
  private TextField textpublicspace;

  @FXML
  private Button registerdoc;

  @FXML
  private Button registerpacient;

  @FXML
  private Label retrive;

  @FXML
  private TextField textspeciality;

  @FXML
  private TextField textvalue;

  @FXML
  public Label wellcomelb;
  @FXML
  private DatePicker birthdatepicker;

  @FXML
  private TextField textcep;

  @FXML
  private TextField textcity;

  @FXML
  private TextField deletecpf;
  @FXML
  private TextField deletecrm;

  @FXML
  private DatePicker deletedate;

  @FXML
  void savethedoc(ActionEvent event) {
    Person person = new Person(textpersonname.getText(), birthdatepicker.getValue().toString(),
        new Addres(textpublicspace.getText(), textcity.getText(), Integer.parseInt(textcep.getText()),
            Integer.parseInt(textnumaddr.getText())));
    Doctor doc = new Doctor(person, new Speciality(textspeciality.getText().split(",")),
        Float.parseFloat(textpayment.getText()), Integer.parseInt(textcrm.getText()));
    DAO.save(doc);
    initializetable();
  }

  @FXML
  void savethepacient(ActionEvent event) {
    Person person = new Person(textpersonname.getText(), birthdatepicker.getValue().toString(),
        new Addres(textpublicspace.getText(), textcity.getText(), Integer.parseInt(textcep.getText()),
            Integer.parseInt(textnumaddr.getText())));
    Pacient pacient = new Pacient(person, textcpf.getText(),
        new Healthinsurance(textinsurancename.getText(), Double.parseDouble(textvalue.getText())));
    DAO.save(pacient);
    initializetable();
  }

  @FXML
  void deletePacient(ActionEvent e) {
    DAO.delete(new Pacient(null, "789.987.321-12", null));
    initializetable();

  }

  @FXML
  void deleteDoctor(ActionEvent e) {
    DAO.delete(new Doctor(null, null, 0.0, Integer.parseInt(deletecpf.getText())));
    initializetable();

  }

  @FXML

  void deleteProcedure(ActionEvent e) {
    var variable = new Procedure.ProcedureBuilder();
    var doc = new Doctor(null, null, 0.0, Integer.parseInt(deletecpf.getText()));
    var pacient = new Pacient(null, deletecpf.getText(), null);
    DAO.delete(variable.setDate(deletedate.getValue().toString()).setDoctor(doc).setPacient(pacient).build());
    initializetable();

  }

  @FXML

  void deleteAppointment(ActionEvent e) {
    var doc = new Doctor(null, null, 0.0, Integer.parseInt(deletecpf.getText()));
    var pacient = new Pacient(null, deletecpf.getText(), null);
    Appointment ap = new Appointment(pacient, doc, deletedate.getValue().toString());
    DAO.delete(ap);
    initializetable();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.initializetable();

  }

  @FXML
  private DatePicker adddatepicker;
  @FXML
  private TextField addcpf;
  @FXML
  private TextField addcrm;
  @FXML
  private TextField addtype;
  @FXML
  private TextField addroom;
  @FXML
  private TextField addduration;
  @FXML
  private Button addprocedure;
  @FXML
  private Button addappointment;

  public void addprocedure1() {
    Doctor doc = new Doctor(new Person(), null, 0, Integer.parseInt(addcrm.getText()));
    var builder = new Procedure.ProcedureBuilder();
    Pacient pacient = new Pacient(new Person(), addcpf.getText(), null);
    var procedure = builder.setDoctor(doc).setDate(adddatepicker.getValue().toString()).setPacient(pacient)
        .setCost(Double.parseDouble(addduration.getText()), 5).setType(addtype.getText()).setroom(addroom.getText())
        .build();
    DAO.save(procedure);
    initializetable();

  }

  public void addappointment1() {
    Doctor doc = new Doctor(new Person(), null, 0, Integer.parseInt(addcrm.getText()));
    Pacient pacient = new Pacient(new Person(), addcpf.getText(), null);
    DAO.save(new Appointment(pacient, doc, adddatepicker.getValue().toString()));
    initializetable();

  }

}
