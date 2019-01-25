/**
 * Created by Екатерина on 24.01.2019.
 */
public enum SubjKind {
    REGION("R"),
    BUILDING("B");

    private final String dbValue;

    SubjKind(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }
}