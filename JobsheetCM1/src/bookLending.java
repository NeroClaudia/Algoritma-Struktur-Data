public class bookLending {

    Student sdt;
    Book book;
    int loanPeriod, overdue, fine;

    public bookLending(Student sdt, Book book, int loanPeriod) {
        this.sdt = sdt;
        this.book = book;
        this.loanPeriod = loanPeriod;
        calculateFine();
    }

    public void calculateFine() {
        if (loanPeriod <= 5) {
            overdue = 0;
            fine = 0;
        } else {
            overdue = loanPeriod - 5;
            fine = overdue * 2000;
        }
    }

    public void printLending() {
        System.out.printf("\n%s | %s | Loan Period (days): %d | Late return of books: %d | fine: %d", sdt.name,
                book.title, loanPeriod, overdue, fine);
    }
}
