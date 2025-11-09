package mk.ukim.finki.wp.lab1wp.service;

import mk.ukim.finki.wp.lab1wp.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();


    Author findById(Long authorId);

}
