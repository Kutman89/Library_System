package LibrarySystem;

import java.util.ArrayList;

public class Reader {
    private int readerID;
    private String name;
    private ArrayList<Book> borrowedBooks;

    //конструктор
    public Reader(int ID, String name){
        readerID = ID; this.name = name;
        borrowedBooks = new ArrayList<>();
    }
    //сеттеры
    public void setName(String name) {
        this.name = name;
    }
    //геттеры
    public int getReaderID() {
        return readerID;
    }
    public String getName() {
        return name;
    }
    //проверка книги
    public boolean hasBook(Book book){
        return borrowedBooks.contains(book);
    }
    //добавить книгу
    public void borrowBook(Book book){borrowedBooks.add(book);}
    //удалить книгу
    public void returnBook(Book book){borrowedBooks.remove(book);}

    //Информация о читателе
    public void ReaderInfo(){
        System.out.println("ID: "+ readerID +" Имя: "+name);
        if(borrowedBooks.isEmpty()){
            System.out.println("Книг нет");
        }else{
            for (Book b : borrowedBooks){
                System.out.println(b.toString());
            }
        }
    }
}
