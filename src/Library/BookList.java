package Library;

public class BookList {
    private Book[] books = new Book[10];
    private int index = 0;

    public void addBook(Book book) {
        if (index == books.length - 1) {
            extendBookList(index);
            books[index++] = book;
        } else {
            books[index++] = book;
        }
    }

    private void extendBookList(int currentIndex) {
        Book[] newBookList = new Book[(int) Math.ceil(currentIndex + currentIndex * 50)];
        int innerIndex = 0;
        for (Book oldBook :
                this.books) {
            newBookList[innerIndex++] = oldBook;
        }
        this.books = newBookList;
    }


    public Book findBookByCategory(Category category){
        for (Book book:
             books) {
            if(book.getCategory().getTitle()==category.getTitle()){
                return book;
            }
        }
        return null;
    }

    public void deleteBook(Book book){
        for (int i = 0; i < books.length; i++) {
            if(books[i].getTitle() == book.getTitle()){
                books[i] =null;
            }
        }
    }
}
