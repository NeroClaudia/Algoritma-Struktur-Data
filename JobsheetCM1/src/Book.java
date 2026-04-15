public class Book {

    String code, title, status;
    int year;

    public Book(String code, String title, int year) {
        this.code = code;
        this.title = title;
        this.year = year;
    }

    public void printBook() {
        System.out.printf("\nCode: %s | Title: %s | Year: %d", code, title, year);
    }
}
