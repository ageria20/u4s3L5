package entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
@DiscriminatorValue("books")
public class Book extends Catalog{

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "book", nullable = false)
    private Book book;

    public Book() {
    }

    public Book(String author, String genre) {
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, LocalDate publishDate, int pages, String author, String genre) {
        super(title, publishDate, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{ " +
                " ISBN='" + this.getISBN() + '\'' +
                " title='" + this.getTitle() + '\'' +
                " author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
