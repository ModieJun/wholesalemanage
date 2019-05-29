package db.project.wholesalemanage.Model;

public enum Type {
    PAID("P"),PENDING("pen");

    private String code;

    private Type(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
