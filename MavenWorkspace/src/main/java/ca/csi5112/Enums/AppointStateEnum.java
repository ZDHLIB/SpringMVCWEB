package ca.csi5112.Enums;

public enum AppointStateEnum {
    SUCCESS(1,"BookSuccess"),
    NO_NUMBER(2, "Understock"),
    REPEAT_APPOINT(3,"Duplicated"),
    INNER_ERROR(4,"SystemError");

    private int state;
    private String stateInfo;

    private AppointStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState(){ return state; }
    public String getStateInfo(){ return stateInfo; }

    public AppointStateEnum stateOf(int index){
        for (AppointStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
