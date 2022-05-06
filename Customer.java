package Project6;

import java.util.ArrayList;

public class Customer {

    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private ArrayList<Donut> donuts;

    public Customer(){
        lastName = "";
        firstName = "";
        phone = "";
        email = "";
        donuts = new ArrayList<Donut>();
    }

    public Customer (String aLastName, String aFirstName, String aPhone, String anEmail){
        lastName = aLastName;
        firstName = aFirstName;
        phone = aPhone;
        email = anEmail;
        donuts = new ArrayList<Donut>();
    }

    public void setLastName(String LastName){
        this.lastName = LastName;
    }

    public void setFirstName(String FirstName){
        this.firstName = FirstName;
    }

    public void setPhone(String Phone){
        this.phone = Phone;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void orderDonut(Donut donut){
        donuts.add(donut);
    }

    public int getNumDonut(){
        return donuts.size();
    }

    public ArrayList<Donut> getDonut(){
        return donuts;
    }

    public String toString(){

        String result ="";
        int size = donuts.size();
        for(Donut s : donuts){
            result += s.toString()+"\n";
        }
        return String.format(firstName+" "+lastName+"\n"+phone+"\n"+email+"\n"+"Donut Order:\n"+result);
    }
}
