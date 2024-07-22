import java.util.ArrayList;
import java.util.List;

public class Member {
    
    private String name;
    private int id;
    private List<Book> ListOfBooks;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
        this.ListOfBooks = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public List<Book> getBorrowedBook() {
        return this.ListOfBooks;
    }

    public void addBook(Book book) {
        this.ListOfBooks.add(book);
    }

    public void removeBook(Book book) {
        this.ListOfBooks.remove(book);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", id='" + getId() + "'" +
            ", ListOfBooks='" + getBorrowedBook() + "'" +
            "}";
    }
    

}
