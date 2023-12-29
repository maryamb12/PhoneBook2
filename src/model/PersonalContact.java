package model;

import java.util.ArrayList;

public class PersonalContact extends Contact {
    private String family;

    public PersonalContact(String name, ArrayList<String> number, String family){
        super(name,number,ContactType.PERSONAL);
        this.family=family;
    }

    //getter
    public String getFamily(){
        return family;
    }
}
