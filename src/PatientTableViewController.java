import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientTableViewController implements Initializable {

    @FXML
    private TableView<Patient> tableView;

    @FXML
    private TableColumn<Patient, Integer> patientIDColumn;

    @FXML
    private TableColumn<Patient, String> firstNameColumn;

    @FXML
    private TableColumn<Patient, String> lastNameColumn;

    @FXML
    private TableColumn<Patient, String> phoneColumn;

    @FXML
    private TableColumn<Patient, String> cityColumn;

    @FXML
    private TableColumn<Patient, String> provinceColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("phone"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("city"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("province"));

        try {
            tableView.getItems().addAll(DBUtility.getAllPatients());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addNewPatient(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"newPatientView.fxml","New Patient Form");
    }
}

