package com.bookStore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="author")
public class Author {

    @Id//(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bio;


    //for relationship

/*   @OneToMany(fetch = FetchType.EAGER)
    private List<Book>books;
/**/


    public Author (Long id, String name, String bio, List<Book> books) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        //this.books = books;
    }

  /*  @OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name="authorbook_id", nullable=false)
        private List<Book>books;*/

  /*  public List<Book> getBooks () {
        return books;
    }

    public void setBooks (List<Book> books) {
        this.books = books;
    }*/

    public Author (Long id, String name, String bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
    }



    public Author () {
        super();
    }


    public Long getId () {return id;}

    public void setId (Long id) {this.id = id;}

    public String getName () {return name;}

    public void setName (String name) {this.name = name;}

    public String getBio () {return bio;}

    public void setBio (String bio) {this.bio = bio;}
}
