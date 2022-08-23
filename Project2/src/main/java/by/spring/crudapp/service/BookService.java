package by.spring.crudapp.service;

import by.spring.crudapp.model.Book;
import by.spring.crudapp.model.Person;
import by.spring.crudapp.repository.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(){
        return booksRepository.findAll();
    }


    public Book findById(int id){
        Optional<Book> person = booksRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void save(Book book){
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook){
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    @Transactional
    public Optional<Person> getBookOwner(int id){
        return Optional.ofNullable(booksRepository.findById(id).map(Book::getOwner).orElse(null));
    }

    @Transactional
    public void release(int id){

        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(null);
                });

    }

    @Transactional
    public void appoint(int id, Person person){

        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(person);
                }
        );

    }


}
