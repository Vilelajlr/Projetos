# Sistema de Biblioteca em Java

Bem-vindo ao projeto de Sistema de Biblioteca, desenvolvido em Java com princípios de Programação Orientada a Objetos (POO). Este projeto tem como objetivo gerenciar livros e membros em uma biblioteca, permitindo o empréstimo e devolução de livros, além de listar os livros e membros cadastrados.

## Funcionalidades

- **Adicionar Livro**: Permite adicionar um novo livro à biblioteca.
- **Adicionar Membro**: Permite adicionar um novo membro à biblioteca.
- **Empréstimo de Livros**: Permite que um membro empreste um livro disponível.
- **Devolução de Livros**: Permite que um membro devolva um livro emprestado.
- **Listar Livros**: Exibe a lista de todos os livros disponíveis na biblioteca.
- **Listar Membros**: Exibe a lista de todos os membros cadastrados na biblioteca.

## Estrutura do Projeto

### Classes Principais

1. **Livro (Book)**
   - Atributos: `titulo`, `autor`, `isbn`, `status` (disponível/empréstimo)
   - Métodos: `getters` e `setters`, `toString`

2. **Membro (Member)**
   - Atributos: `nome`, `id`, `listaDeLivrosEmprestados`
   - Métodos: `getters` e `setters`, `adicionarLivro`, `removerLivro`, `toString`

3. **Biblioteca (Library)**
   - Atributos: `listaDeLivros`, `listaDeMembros`
   - Métodos: `adicionarLivro`, `adicionarMembro`, `emprestarLivro`, `devolverLivro`, `listarLivros`, `listarMembros`

4. **Sistema Principal (Main)**
   - Contém o método `main` e lida com a interação do usuário, utilizando as classes acima para realizar operações na biblioteca.

## Exemplo de Código

### Classe Book
```java
public class Book {

        private String title;
        private String author;
        private String isbn;
        private boolean isavailable;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isavailable = true;
        }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isIsavailable() {
        return this.isavailable;
    }

    public boolean getIsavailable() {
        return this.isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }


    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", isbn='" + getIsbn() + "'" +
            ", isavailable='" + isIsavailable() + "'" +
            "}";
    }

}
```

### Classe Member

```java
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

```

### Classe Library

```java
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
```

### Classe Main

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library biblioteca = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Sistema de Biblioteca");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Livros");
            System.out.println("6. Listar Membros");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            limparConsole();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    Book livro = new Book(titulo, autor, isbn);
                    biblioteca.addBook(livro);
                    limparConsole();
                    System.out.println("Livro adicionado com sucesso.");
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Digite o nome do membro: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o ID do membro: ");
                    int id = scanner.nextInt();
                    Member membro = new Member(nome, id);
                    biblioteca.addMember(membro);
                    limparConsole();
                    System.out.println("Membro adicionado com sucesso.");
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Digite o ISBN do livro para emprestar: ");
                    isbn = scanner.nextLine();
                    System.out.print("Digite o ID do membro: ");
                    id = scanner.nextInt();
                    limparConsole();
                    biblioteca.lendBook(isbn, id);
                    System.out.println("");

                    break;
                case 4:
                    System.out.print("Digite o ISBN do livro para devolver: ");
                    isbn = scanner.nextLine();
                    System.out.print("Digite o ID do membro: ");
                    id = scanner.nextInt();
                    limparConsole();
                    biblioteca.lendBook(isbn, id);
                    System.out.println("");
                    break;
                case 5:

                    if(biblioteca.getBooks() == 0){
                        System.out.println("Nenhum livro cadastrado.");
                        break;
                    }

                    System.out.println("===== Lista de Livros =====");
                    biblioteca.listBook();
                    System.out.println("============================");
                    break;
                case 6:

                    if(biblioteca.getMembers() == 0){
                        System.out.println("Nenhum membro cadastrado.");
                        break;
                    }


                    System.out.println("===== Lista de Membros =====");
                    biblioteca.listMember();
                    System.out.println("============================");
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }


    public static void limparConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
```



[![Instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/joseleandrovilela/)