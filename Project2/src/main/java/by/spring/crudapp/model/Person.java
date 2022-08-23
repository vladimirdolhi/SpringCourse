package by.spring.crudapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 25, message = "Name should be between 3 and 25 characters")
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 1899, message = "Incorrect date")
    @Column(name = "birth_year")
    private int birthYear;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }



    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.fullName = name;
        this.birthYear = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
