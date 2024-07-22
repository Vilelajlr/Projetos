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
