package by.spring.crudapp.dao;

import by.spring.crudapp.model.Book;
import by.spring.crudapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(title, year, author, person_id) VALUES(?, ?, ?)", book.getTitle(), book.getYear(),
                book.getAuthor(), book.getPerson_id());

    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=?, person_id=?  WHERE  id=?", updatedBook.getTitle(),
                updatedBook.getAuthor(), updatedBook.getYear(), updatedBook.getPerson_id());
    }


    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book where id=?", id);

    }
}
