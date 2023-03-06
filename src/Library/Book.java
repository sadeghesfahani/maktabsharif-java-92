package Library;

class Book {

    private String title;
    private String ISBN;
    private int numberOfPage;
    private String edition;
    private Author author;
    private Date year;
    private Category category;

    Book(String title, String ISBN, int numberOfPage, String edition, Author author, Date year, Category category) {
        this.title = title;
        this.ISBN = ISBN;
        this.numberOfPage = numberOfPage;
        this.edition = edition;
        this.author = author;
        this.year = year;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }
}
