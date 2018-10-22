import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static int i = 4;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int k = 0; k < 5; k++){
            Author author = new Author("Лев Толстой"+k, "12.12.1912",3+i);
            authors.add(k, author);
            Book book = new Book("Книга но"+k, 200+k, authors.get(k), k+1);
            books.add(k, book);
        }
        while( true){
            gameIntroduction();
            int userChoice = sc.nextInt();
            if (userChoice == 1){
                addNewAuthor();
                addNewBook();
            } else if (userChoice == 2) {
                showAllBooks();
            }
            else if (userChoice == 3){
                break;
            } else if(userChoice == 4){
                System.out.println("Введите название книги");
                sc.nextLine();
                String searchBook = sc.nextLine();
                searchBook(searchBook);
            }
            i++;
        }

    }

    public static void gameIntroduction(){
        System.out.println("Приложение учета книг");
        System.out.println("Выберите один из вариантон");
        System.out.println("1. Добавить новую книгу");
        System.out.println("2. Показать список всех книг");
        System.out.println("3. Выйти из системы");
        System.out.println("4. Поиск книги по названию");
    }

    public static void addNewAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Имя и Фамилию автора");
        String authName = sc.nextLine();
        System.out.println("Введите дату рождения автора");
        String authDateOfBirth = sc.next();
        System.out.println("Введите колл-во написанных книг");
        int authWritenBooksCount = sc.nextInt();
        Author author = new Author(authName,authDateOfBirth,authWritenBooksCount);
        authors.add(i, author);
    }

    public static void addNewBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги");
        String bookTitle = sc.nextLine();
        System.out.println("Введите колл-во страниц");
        int pagesCount = sc.nextInt();
        System.out.println("Введите колл-во книг в библиотеке");
        int booksCount = sc.nextInt();
        Book book = new Book(bookTitle, pagesCount, authors.get(i), booksCount);
        books.add(i, book);
    }

    public static void showAllBooks(){
        for (Book b : books){
            System.out.println(b.bookInfo());
        }
    }

    public static void searchBook(String searchBook){
        boolean bookStatus = false;
        for (Book b : books){
            if(b.getName().equals(searchBook)){
                System.out.println("Книга с таким названием найдена");
                System.out.println(b.bookInfo());
                bookStatus = true;
                break;
            }
        }
        if(!bookStatus){
            System.out.println("Книга не найдена");
        }
    }


}
