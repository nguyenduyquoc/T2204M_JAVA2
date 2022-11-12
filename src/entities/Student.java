package entities;

import javafx.scene.control.Button;


public class Student {
    private Integer id;
    private String name;
    private String email;
    private int mark;
    private String gender;
    private Button edit;


    public Student(Integer id,String name, String email, int mark, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mark = mark;
        this.gender = gender;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {

        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
    @Override
    public String toString() {
        return this.getName()+"\n"+this.getMark();
    }
}
