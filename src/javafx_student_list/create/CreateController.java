package javafx_student_list.create;

import database.Connector;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx_student_list.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ComboBox<String> cbGender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> genders = FXCollections.observableArrayList();
        genders.add("Nam");
        genders.add("Nữ");
        genders.add("Other");
        cbGender.setItems(genders);
    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/javafx_student_list.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) {
        try {
            Integer m = Integer.parseInt(txtMark.getText());
            if(m<0 || m > 10)
                throw new Exception("Điểm thi không hợp lệ");
            // them sv
            Student s=  new Student(null, txtName.getText(),txtEmail.getText(),m,cbGender.getValue());

            Connector connector = new Connector();
            String sql_txt = "insert into students(name,email,mark,gender) values(?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getName());
            parameters.add(s.getEmail());
            parameters.add(s.getMark());
            parameters.add(s.getGender());
            if(connector.execute(sql_txt,parameters)){
                backToList(null);
                return;
            }
            throw new Exception("Không thêm được dữ liệu");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
