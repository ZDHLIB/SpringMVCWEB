package ca.csi5112.Dao;

import ca.csi5112.Entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {

    /**
     * Insert one appointment record
     * @param bookId
     * @param studentId
     * @return
     */
    int insertAppointment(@Param("bookId") String bookId, @Param("studentId") String studentId);

    /**
     * Query appointment history
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryHistoryByKey(@Param("bookId") String bookId, @Param("studentId") String studentId);
}
