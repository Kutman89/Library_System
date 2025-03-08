package LibrarySystem;

public class Main {
    public static void main(String[] args){
        Library library = new Library();

        // 1. Добавляем книги
        System.out.println("Добавление книг:");
        library.addBook(new Book("1984", "Джордж Оруэлл", 1949));
        library.addBook(new Book("Гарри Поттер", "Дж. К. Роулинг", 1997));
        library.addBook(new Book("Война и мир", "Лев Толстой", 1865));
        System.out.println("Книги добавлены.\n");

        // 2. Регистрируем читателей
        System.out.println("Регистрация читателей:");
        library.registerReader("Иван");
        library.registerReader("Мария");
        System.out.println("Читатели зарегистрированы.\n");

        // 3. Выводим начальное состояние книг
        System.out.println("Список книг в библиотеке:");
        library.displayBooks();
        System.out.println();

        // 4. Тестируем выдачу книг
        System.out.println("Тест выдачи книг:");
        try {
            library.giveBookToReader(1, "1984"); // Иван берет "1984"
            System.out.println("Книга '1984' выдана читателю с ID 1");
            library.giveBookToReader(2, "Гарри Поттер"); // Мария берет "Гарри Поттер"
            System.out.println("Книга 'Гарри Поттер' выдана читателю с ID 2");

            // Попытка выдать уже взятую книгу
            library.giveBookToReader(2, "1984");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 5. Выводим состояние после выдачи
        System.out.println("Список книг после выдачи:");
        library.displayBooks();
        System.out.println("Информация о читателях:");
        library.displayReaders();
        System.out.println();

        // 6. Тестируем возврат книг
        System.out.println("Тест возврата книг:");
        try {
            library.returnBook(1, "1984"); // Иван возвращает "1984"
            System.out.println("Книга '1984' возвращена");

            // Попытка вернуть книгу, которая не была взята
            library.returnBook(2, "Война и мир");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // 7. Выводим финальное состояние
        System.out.println("Финальный список книг:");
        library.displayBooks();
        System.out.println("Финальная информация о читателях:");
        library.displayReaders();
    }
}
