package model;
import java.util.ArrayList;

public abstract class Contact {
    private int indx;
    private String name;
    private ArrayList<String> number;
    private ContactType type;

    public Contact(String name, ArrayList<String> number,ContactType type) {
        this.name=upperFirstCharecter(name);
        this.number=number;
        this.type=type;
    }

    private String upperFirstCharecter(String str){
        if(str!=null && !str.isEmpty()){
            return Character.toUpperCase(str.charAt(0))+str.substring(1);
        }
        else {
            return str;
        }
    }

    public String toString(){
        String numberStr="";
        for(String str: number){
            numberStr+="\t"+str;
        }
        return indx +"\t\t"+ name+"\t\t"+numberStr+"\t\t";
    }

    //getter
    public int getIndx(){
        return indx;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getNumber(){
        return number;
    }

    public ContactType getType() {
        return type;
    }
    //setter

    public void setName(String name){
        this.name=upperFirstCharecter(name);
    }
    public void setNumber(ArrayList<String> number){
        this.number=number;
    }
    public void setIndx(int indx){
        this.indx=indx;
    }

}