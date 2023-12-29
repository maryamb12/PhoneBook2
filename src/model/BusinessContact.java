package model;
import java.util.ArrayList;

public class BusinessContact extends Contact {

    private String fax;

    public BusinessContact(String name, ArrayList<String> number, String fax){
        super(name,number,ContactType.BUSINESS);
        this.fax=fax;
    }

    //getter
    public String getFax(){
        return fax;
    }
}
