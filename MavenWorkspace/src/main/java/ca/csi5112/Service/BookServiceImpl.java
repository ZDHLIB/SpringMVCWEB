package ca.csi5112.Service;

import ca.csi5112.Enums.AppointStateEnum;
import ca.csi5112.Dao.AppointmentDao;
import ca.csi5112.Dao.BookDao;
import ca.csi5112.Dto.AppointExecution;
import ca.csi5112.Entity.Appointment;
import ca.csi5112.Entity.Book;
import ca.csi5112.Exceptions.AppointException;
import ca.csi5112.Exceptions.NoNumberException;
import ca.csi5112.Exceptions.RepeatAppointException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getBookById(String bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.queryAllBook(0, 20);
    }

    @Override
    @Transactional
    public AppointExecution makeAppointment(String bookId, String studentId) {
        try{
            // Update the number of the book in the library
            int update = bookDao.updateBookNum(bookId);
            System.out.println("Update book num : " + update + " " + bookId);
            if( update <= 0 ) {
                throw new NoNumberException("Out of stock!");
            } else {
                //Create a new appointment
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                System.out.println("Insert appointment : "+insert+", bookId: "+bookId+", studentId:"+studentId);
                if( insert < 0 ){
                    throw new RepeatAppointException("Repeat appointment");
                } else {
                    Appointment appointment = appointmentDao.queryHistoryByKey(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        }catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
