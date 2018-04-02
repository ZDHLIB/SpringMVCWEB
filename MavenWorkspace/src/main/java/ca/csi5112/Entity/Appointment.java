package ca.csi5112.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private String bookId;
    private String studentId;
    private Timestamp appointTime;
    private Book book;
}
