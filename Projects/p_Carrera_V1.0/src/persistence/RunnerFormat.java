package persistence;

public enum RunnerFormat{
    ID(0), FIRST_NAME(1),SECOND_NAME(2),LAST_NAME(3),
    BIRTH_DATE(4), GENDER(5), TEAM(6),ROUTE_TIME(7);

    private int fileFormatPosition;

    RunnerFormat(int fileFormatPosition){
        this.fileFormatPosition = fileFormatPosition;
    }

    public int getFileFormatPosition(){
        return this.fileFormatPosition;
    }
}