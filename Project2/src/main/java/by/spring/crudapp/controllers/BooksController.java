package by.spring.crudapp.controllers;


import by.spring.crudapp.model.Book;
import by.spring.crudapp.model.Person;
import by.spring.crudapp.service.BookService;
import by.spring.crudapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final PeopleService peopleService;


    @Autowired
    public BooksController(BookService bookService, PeopleService peopleService) {

        this.bookService = bookService;
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model,
                       @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookService.findById(id));
        Optional<Person> owner = bookService.getBookOwner(id);

        if (owner.isPresent()){
            model.addAttribute("owner", owner.get());
            System.out.println(owner);
        } else{
            model.addAttribute("people", peopleService.findAll());
        }

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "books/new";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id
    ){

        if (bindingResult.hasErrors()){
            return "books/edit";
        }
        bookService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id){
        bookService.release(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/appoint")
    public String release(@PathVariable("id") int id,
                          @ModelAttribute("person") Person selectedPerson){
        bookService.appoint(id, selectedPerson);
        return "redirect:/books/" + id;
    }
}
