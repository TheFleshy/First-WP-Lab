package mk.ukim.finki.wp.lab1wp.repository;

import mk.ukim.finki.wp.lab1wp.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public  class AuthorRepository {

    private List<Author> authors = new ArrayList<Author>();
    public AuthorRepository() {
        authors.add(new Author(1L, "Christopher", "Nolan", "United Kingdom",
                "Director and writer known for Inception, Interstellar, and The Dark Knight."));
        authors.add(new Author(2L, "Winston", "Groom", "United States",
                "American novelist best known for Forrest Gump."));
        authors.add(new Author(3L, "Quentin", "Tarantino", "United States",
                "Director and screenwriter known for Pulp Fiction and Django Unchained."));
    }

    public List<Author> findAll(){
        return authors;
    }


    public Author findById(Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
