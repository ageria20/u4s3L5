package entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue
    private UUID loan_id;

    @ManyToOne
    @JoinColumn(name = "loaned_element")
    private Catalog loanedElement;

    @Column(name = "start_loan")
    private LocalDate startLoan;

    @Column(name = "expected_return")
    private LocalDate expectedReturn;

    @Column(name = "actual_return")
    private LocalDate actualReturn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Loan() {
    }

    public Loan( Catalog loanedElement, LocalDate startLoan, LocalDate expectedReturn, LocalDate actualReturn, User user) {

        this.loanedElement = loanedElement;
        this.startLoan = startLoan;
        this.expectedReturn = expectedReturn;
        this.actualReturn = actualReturn;
        this.user = user;
    }

    public UUID getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(UUID loan_id) {
        this.loan_id = loan_id;
    }

    public Catalog getLoanedElement() {
        return loanedElement;
    }

    public void setLoanedElement(Catalog loanedElement) {
        this.loanedElement = loanedElement;
    }

    public LocalDate getStartLoan() {
        return startLoan;
    }

    public void setStartLoan(LocalDate startLoan) {
        this.startLoan = startLoan;
    }

    public LocalDate getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(LocalDate expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    public LocalDate getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(LocalDate actualReturn) {
        this.actualReturn = actualReturn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loan_id=" + loan_id +
                ", loanedElement=" + loanedElement +
                ", startLoan=" + startLoan +
                ", expectedReturn=" + expectedReturn +
                ", actualReturn=" + actualReturn +
                ", user=" + user +
                '}';
    }


}
