public class User {
    private String name;
    private String surname;
    private int balance;
    public User(String name, String surname, int balance){
        setName(name);
        setSurname(surname);
        setBalance(balance);
    }
    public User(String name, String surname){
        setName(name);
        setSurname(surname);
        setBalance(0);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setBalance(int balance){
        if(balance >= 0) this.balance = balance;
        else System.out.println("Please enter valid number");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBalance() {
        return balance;
    }
}
