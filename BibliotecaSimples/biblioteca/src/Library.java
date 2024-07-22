import java.util.ArrayList;
import java.util.List;

public class Library {
    
    private List<Book> books;
    private List<Member> members;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addMember(Member member){
        this.members.add(member);
    }

    public void lendBook(String isbn, int memberId){
        Book book = searchBook(isbn);
        Member member = searchMember(memberId);

        if(book != null && member != null && book.isIsavailable()){
            book.setIsavailable(false);
            member.addBook(book);
            System.out.println("Livro emprestado com sucesso.");
        } else {

            book.setIsavailable(true);
            member.removeBook(book);
            System.out.println("Devolução realizada.");

        }

    }



    public void listBook(){
        for(Book book : this.books){
            System.out.println(book);
        }
    }

    public void listMember(){
        for(Member member : this.members){
            System.out.println(member);
        }
    }

    private Book searchBook(String isbn){
        for(Book book : this.books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }


    private Member searchMember(int memberId){
        for(Member member : this.members){
            if(member.getId() == memberId){
                return member;
            }
        }
        return null;
    }

    public int getBooks() {
        return this.books.size();
    }

    public int getMembers() {
        return this.members.size();
    }


}
