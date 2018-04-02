package ca.csi5112.Dto;

import ca.csi5112.Enums.AppointStateEnum;
import ca.csi5112.Entity.Appointment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointExecution {
    private String bookId;
    private int bookState;
    private String bookStateInfo;
    private Appointment appointment;

    /**
     * Failed
     * @param bookId
     * @param stateEnum
     */
    public AppointExecution(String bookId, AppointStateEnum stateEnum){
        this.bookId = bookId;
        this.bookState = stateEnum.getState();
        this.bookStateInfo = stateEnum.getStateInfo();
    }

    /**
     * Success
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointExecution(String bookId, AppointStateEnum stateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.bookState = stateEnum.getState();
        this.bookStateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }
}
