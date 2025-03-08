package LibrarySystem;
import java.util.ArrayList;
public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Reader> readers = new ArrayList<>();
    private int addReaderID = 1;

    //Регистрация читателя
    public void registerReader(String name){
        readers.add(new Reader(addReaderID++, name));
    }
    //Добавление книг
    public void addBook(Book book){
        books.add(book);
    }
    //Передача книг пользователю
    public void giveBookToReader(int id, String bookTitle){
        Reader reader = findReader(id);
        Book book = findBook(bookTitle);
        if(book == null){
            throw new IllegalArgumentException("Книга "+ bookTitle +" не найдена");
        }
        if(!book.isAvailable()){
            throw new IllegalArgumentException("Книга уже выдана");
        }
        book.setAvailable(false);
        reader.borrowBook(book);

    }
    //возврат книги от пользователя
    public void returnBook(int id, String bookTitle){
        Reader reader = findReader(id);
        Book book = findBook(bookTitle);
        if(book == null){
            throw new IllegalArgumentException("Книга "+ bookTitle +" не найдена");
        }if(book.isAvailable()){
            throw new IllegalArgumentException("Книга "+ bookTitle +" уже в библиотеке");
        }if(!reader.hasBook(book)){
            throw new IllegalArgumentException("Книга "+ bookTitle +" у читателя нету");
        }
        book.setAvailable(true);
        reader.returnBook(book);
    }
    //поиск читателя по id
    private Reader findReader(int readerID){
        for(Reader r : readers){
            if(r.getReaderID() == readerID){return r;}
        }
        throw new IllegalArgumentException("Читатель " + readerID + " не найден");
    }
    //поиск книги по названию
    private Book findBook(String bookTitle){
        for(Book b : books){
            if(b.getTitle().equals(bookTitle)){return b;}
        }
        return null;
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }
    public void displayReaders() {
        if (readers.isEmpty()) {
            System.out.println("Читателей нет");
        } else {
            for (Reader r : readers) {
                r.ReaderInfo();
            }
        }
    }
}