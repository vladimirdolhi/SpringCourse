package by.spring.crudapp.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 3, max = 80, message = "Title should be between 3 and 80 characters")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 3, max = 80, message = "Author should be between 3 and 80 characters")
    private String author;

    @Min(value = 1900, message = "Incorrect year")
    private int year;


    public Book(int id, String title, String author, int year, int person_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
