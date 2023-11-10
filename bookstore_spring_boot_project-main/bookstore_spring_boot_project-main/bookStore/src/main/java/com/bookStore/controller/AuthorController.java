package com.bookStore.controller;

import com.bookStore.entity.Author;
import com.bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")

public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping//("/author")
    public String showAuthorList(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "author_list"; // Thymeleaf template to display a list of authors
    }

    @GetMapping("/create")
    public String showAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author_form"; // Thymeleaf template for creating or editing an author
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors"; // Redirect to the list of authors
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author_form"; // Thymeleaf template for creating or editing an author
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors"; // Redirect to the list of authors
    }



}
