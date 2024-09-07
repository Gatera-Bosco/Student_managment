
package model;

import javax.persistence.*;

/**
 *
 * @author jeremie
 */


@Entity
public class Student {
    @Id
    private String student_id;
    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(String student_id, String firstname, String lastname) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
}
