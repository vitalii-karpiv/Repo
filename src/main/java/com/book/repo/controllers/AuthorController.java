package com.book.repo.controllers;

import com.book.repo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

//    @RequestMapping("/books")
//  public String getBooks(Model model) {
//
//    model.addAttribute("books", bookRepository.findAll());
//
//    return "books/list";
//  }

  @RequestMapping("/authors")
  public String getAuthors(Model model) {

    model.addAttribute("authors", authorRepository.findAll());

    return "authors/list";
  }
}
