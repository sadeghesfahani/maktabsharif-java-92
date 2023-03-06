package Library;

public class Library {
    private BookList books;
    private int index = 0;

    public void addBook(Book book){
        books.addBook(book);
    }

    public void deleteBookByCategory(Category category){
        books.findBookByCategory(category);
    }

}
