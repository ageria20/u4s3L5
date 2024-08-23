package entities;


import enums.Periodicity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
@DiscriminatorValue("magazines")
public class Magazines extends Catalog{

    @Column(name="period_type")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;


    @ManyToOne
    @JoinColumn(name = "magazine")
    private Magazines magazine;


    public Magazines() {
    }

    public Magazines(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public Magazines(String title, LocalDate publishDate, int pages, Periodicity periodicity) {
        super(title, publishDate, pages);
        this.periodicity = periodicity;

    }




    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazines{ " +
                " ISBN=" + this.getISBN() +
                " title=" + this.getTitle() +
                " Pages=" + this.getPages() +
                " periodicity=" + periodicity +
                '}';
    }
}
