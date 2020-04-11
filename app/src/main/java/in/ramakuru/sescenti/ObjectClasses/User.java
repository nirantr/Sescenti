package in.ramakuru.sescenti.ObjectClasses;

import java.util.ArrayList;

public class User {
    public String bio;
    public     int credit;
    public int debit;
    public  String firstName;
    public  String id;
    public  String lastName;
    public  String email;
    public ArrayList<KonnektList> myKonnekts;


    public User(){

    }

    public User(String firstName, String email){
        this.firstName = firstName;
        this.email = email;
    }

    public User(String bio,int credit,int debit,String firstName,String id,String lastName,String email){
        this.bio = bio;
        this.credit = credit;
        this.debit = debit;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public User(ArrayList<KonnektList> myKonnekts){
    this.myKonnekts.addAll(myKonnekts);
    }

    public User(KonnektList myNewKonnekt){
    this.myKonnekts.add(myNewKonnekt);
    }
}
