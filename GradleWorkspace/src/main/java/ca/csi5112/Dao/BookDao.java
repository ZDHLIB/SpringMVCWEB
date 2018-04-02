package ca.csi5112.Dao;

import ca.csi5112.Entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    /**
     * Query book by book Id
     * @param bookId
     * @return
     */
    Book queryById(@Param("bookId") String bookId);

    /**
     * Query all books
     * @param offset
     * @param limit
     * @return
     */
    List<Book> queryAllBook(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * Update book number
     * @param bookId
     * @return
     */
    int updateBookNum(@Param("bookId") String bookId);
}
