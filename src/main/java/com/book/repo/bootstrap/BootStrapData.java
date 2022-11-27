package com.book.repo.bootstrap;

import com.book.repo.domain.Author;
import com.book.repo.domain.Book;
import com.book.repo.domain.Publisher;
import com.book.repo.repositories.AuthorRepository;
import com.book.repo.repositories.BookRepository;
import com.book.repo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author bob = new Author("Boob", "Jonson");
    Book javaFromZeroToHero = new Book("From zero to hero", "123123");
    Publisher publisher = new Publisher("SFG", "London", "London", null, null);

    authorRepository.save(bob);
    bookRepository.save(javaFromZeroToHero);
    publisherRepository.save(publisher);

    System.out.println("Bootstrapping finished");
    System.out.println("Saved books: " + bookRepository.count());
    System.out.println("Saved publishers: " + publisherRepository.count());
  }


}
