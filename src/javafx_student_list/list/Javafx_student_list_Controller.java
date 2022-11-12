package javafx_student_list.list;

import database.Connector;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_student_list.Main;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Javafx_student_list_Controller implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student, String> cName;
    public TableColumn<Student, String> cEmail;
    public TableColumn<Student, String> cMark;
    public TableColumn<Student, String> cGender;
    public TableColumn<Student, Button> cAction;
    public TextField txtSearch;
    private ObservableList<Student> ls = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        try {
            Connector connector = new Connector();
            String sql = "select * from students";
            ResultSet rs = connector.query(sql);
            ObservableList<Student> ls = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int mark = rs.getInt("mark");
                String gender = rs.getString("gender");
                Student s = new Student(id,name,email,mark,gender);
                ls.add(s);
            }
            tbStudents.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }


    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearch.getText();
            if(s.isEmpty()){
                tbStudents.setItems(ls);
                throw new Exception("Vui lòng nhập từ cần tìm kiếm");
            }

            ObservableList<Student> results = ls.stream()
                    .filter(student -> student.getName().toLowerCase().contains(s.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbStudents.setItems(results);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void createStudent(ActionEvent actionEvent)  throws Exception{
        Parent createForm = FXMLLoader.load(getClass().getResource("../create/creatStudent.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }
}
