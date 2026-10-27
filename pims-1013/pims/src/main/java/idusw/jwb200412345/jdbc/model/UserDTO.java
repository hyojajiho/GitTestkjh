package idusw.jwb200412345.jdbc.model;

public class UserDTO { // 조회한 결과 중 하나의 레코드를 처리하는 객체
    private String firstField;
    private String secondField;

    public String getFirstField() {
        return firstField;
    }

    public void setFirstField(String firstField) {
        this.firstField = firstField;
    }

    public String getSecondField() {
        return secondField;
    }

    public void setSecondField(String secondField) {
        this.secondField = secondField;
    }
}
