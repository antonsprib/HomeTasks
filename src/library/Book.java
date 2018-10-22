import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private int pages;
    private Author author;
    private int quanty;


    public Book(String name, int pages, Author author, int quanty){
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.quanty = quanty;
    }

    public String bookInfo(){
        return "Название книги " + name + " Колл-во страниц " + pages +" " + author.authInfo() + " Колл-во в библиотеке " + quanty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }
}
