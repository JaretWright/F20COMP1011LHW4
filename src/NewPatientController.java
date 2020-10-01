import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class NewPatientController implements Initializable {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private ComboBox<String> provinceComboBox;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> provinces = Patient.getListOfProvinces();
        Collections.sort(provinces);
        provinceComboBox.getItems().addAll(provinces);
        provinceComboBox.setPromptText("Select Province");
        msgLabel.setText("");
    }

    @FXML
    private void createNewPatient()
    {
        try {
            Patient patient = new Patient(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    phoneTextField.getText(),
                    cityTextField.getText(),
                    provinceComboBox.getValue());
            msgLabel.setText(patient.toString());
        } catch(Exception e)
        {
            msgLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void viewAllPatientsButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"patientTableView.fxml",
                        "All Patients");
    }
}
