package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="catalog_type")
@NamedQuery(name="findByTitleOrPArtOfIt", query="SELECT c FROM Catalog c WHERE LOWER(c.title) LIKE LOWER(:title)")
public abstract class Catalog {

    @Id
    @GeneratedValue
    private UUID ISBN;

    @Column(name = "title")
    private String title;

    @Column(name="publishedDate")
    private LocalDate publishedDate;

    @Column(name="pages")
    private int pages;

    @OneToMany(mappedBy = "book")
    private List<Book> bookList;

    @OneToMany(mappedBy = "magazine")
    private List<Magazines> magazinesList;

    public Catalog() {
    }

    public Catalog(String title, LocalDate publishDate, int pages) {
        this.title = title;
        this.publishedDate = publishDate;
        this.pages = pages;
    }

    public UUID getISBN() {
        return ISBN;
    }

    public void setISBN(UUID ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishedDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishedDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


}
