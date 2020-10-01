import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
//        Patient tiredPatient = new Patient("Cam","IwishIwasHere","(555) 4561237","Bradford","ON");
//
//        try {
//            ArrayList<Patient> patients = DBUtility.getAllPatients();
//            for (Patient patient: patients)
//                System.out.println(patient);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
////        String validPhone = "(555)433-1234";
//        String invalidPhone = "1231231234";
////        String phonePattern = "\\(?[2-9]\\d{2}\\)?[-\\s]?[2-9]\\d{2}[-\\s]?\\d{4}";
////
////               System.out.printf("invalidPhone is valid: %b\n",
////                invalidPhone.replaceAll("[^0-9]", "").matches("[2-9]\\d{2}[2-9]\\d{2}\\d{4}"));
//
//
////        System.out.printf("%s is a valid phone number: %b%n",validPhone,
////                            validPhone.matches(phonePattern));
////        System.out.printf("%s is a valid phone number: %b%n",invalidPhone,
////                invalidPhone.matches(phonePattern));
////
////        String validName="Jaret";
////        String validName2="Jaret-IsTired";
////        String validName3="MaryBeth";
////        String invalidName="2LegitToQuit";
////        String invalidName2="jaret";
////        String invalidName3="J";
////        String namePattern="[A-Z][A-Z][A-z]*[-]?[A-z]*?";
////
////        System.out.printf("%s is a valid name: %b%n",validName,
////                validName.matches(namePattern));
////        System.out.printf("%s is a valid name: %b%n",validName2,
////                validName2.matches(namePattern));
////        System.out.printf("%s is a valid name: %b%n",validName3,
////                validName3.matches(namePattern));
////        System.out.printf("%s is a valid name: %b%n",invalidName,
////                invalidName.matches(namePattern));
////        System.out.printf("%s is a valid name: %b%n",invalidName2,
////                invalidName2.matches(namePattern));
////        System.out.printf("%s is a valid name: %b%n",invalidName3,
////                invalidName3.matches(namePattern));
////
//
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("newPatientView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("New Patient Intake Form");
        stage.show();
    }
}
