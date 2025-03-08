package LibrarySystem;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;
    //Геттеры
    public String getTitle() {return title;}
    public boolean isAvailable(){return isAvailable;}
    //Сеттеры
    public void setTitle(String _title) {title = _title;}
    public void setAuthor(String author) {this.author = author;}
    public void setYear(int year) {
        if(year < 0){
            throw new IllegalArgumentException("Год не может быть отрицательным");
        }
        this.year = year;
    }
    public void setAvailable(boolean available) {isAvailable = available;}

    //Конструктор для добавления значений в поля
    public Book (String title, String author, int year){
        this.title = title; this.author = author;
        this.isAvailable = true;
        setYear(year);
    }
    //Вывод данных книги
    @Override
    public String toString(){
        return title + " (" + author+ ", " + year + ") " + (isAvailable ? "Доступна" : "Выдана");
    }

}
