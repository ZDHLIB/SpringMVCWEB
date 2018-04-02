package ca.csi5112.Service;

import ca.csi5112.Dto.AppointExecution;
import ca.csi5112.Entity.Book;

import java.util.List;

public interface IBookService {

    /**
     * Query book by book Id
     * @param bookId
     * @return
     */
    Book getBookById(String bookId);


    /**
     * Query all book info
     * @return
     */
    List<Book> getAllBooks();

    /**
     * Create a appointment for a book
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution makeAppointment(String bookId, String studentId);
}
