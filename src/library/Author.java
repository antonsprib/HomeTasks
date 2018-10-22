import java.io.Serializable;

public class Author implements Serializable {
    private String name;
    private String birthDate;
    private int writedBooksCount;

    public Author(){
        this("Lev Tolstoj", "12.12.1812", 34);
    }

    public Author(String name, String birthDate, int writedBooksCount){
        this.name  = name;
        this.birthDate = birthDate;
        this.writedBooksCount = writedBooksCount;
    }


    public String authInfo(){
        return "Имя автора " + name + " Дата рождения " + birthDate + " Колл-во написанных книг " + writedBooksCount;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getbirthDate(){
        return birthDate;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public int getWritedBooksCount(){
        return writedBooksCount;
    }

    public void setWritedBooksCount(int writedBooksCount){
        this.writedBooksCount = writedBooksCount;
    }
}
