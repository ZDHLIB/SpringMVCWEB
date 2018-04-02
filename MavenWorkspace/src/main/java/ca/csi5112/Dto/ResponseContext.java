package ca.csi5112.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseContext<T> {
    private boolean success; //Book success or not
    private T data;  //response data
    private String error;  //error info

    /**
     * Success response
     * @param success
     * @param data
     */
    public ResponseContext(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    /**
     * Failed response
     * @param success
     * @param error
     */
    public ResponseContext(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
