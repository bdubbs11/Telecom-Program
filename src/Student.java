// class that creates all the objects to be added into linked lists
public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private double balance;
    private String[] calledNumbers;
    private int [] callDuration;
    private String[] textedNumbers;
    private static int numStudents;
    private Student next;
    
    // empty constructor
    public Student(){
        ID = 0;
        next = null;
        numStudents +=1;
    }
    // stuff from the llnode class
    public Student(int ID){
        this.ID = ID;
        next = null;
        numStudents +=1;
    }
    // stuff from the llnode class
    public Student(int ID, Student next){
        this.ID = ID;
        this.next = next;
        numStudents +=1;
    }
    
    // this.calledNumbers = calledNumbers;
       // this.callDuration = callDuration;
        //this.textedNumbers = textedNumbers;
    // , String[] calledNumbers, int [] callDuration, String[] textedNumbers,
    //, double balance,
    // for the first one
    public Student(int ID, String firstName, String lastName, String phoneNumber){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.balance = 20;
        this.next = null;
        calledNumbers = new String[10];
        callDuration = new int[10];
        textedNumbers = new String[10];
        numStudents +=1;
    }
    // , String[] calledNumbers, int [] callDuration, String[] textedNumbers,
    // , double balance,
    // for all the rest
   public Student(int ID, String firstName, String lastName, String phoneNumber, Student next){
       this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.balance = 20;
        this.next = next;
        calledNumbers = new String[10];
        callDuration = new int[10];
        textedNumbers = new String[10];
        numStudents +=1;
    }
   
   // getter for getting id/data
    public int getID() {
        return ID;
    }
    // getter for getting first name
    public String getFirstName() {
        return firstName;
    }
    // getter for getting last name
    public String getLastName() {
        return lastName;
    }
    // getter for getting phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // getter for getting balance
    public double getBalance() {
        return balance;
    }
    // getter for getting called numbers
    public String[] getCalledNumbers() {
        return calledNumbers;
    }
    // getter for getting call duration
    public int[] getCallDuration() {
        return callDuration;
    }
    // getter for getting texted numbers
    public String[] getTextedNumbers() {
        return textedNumbers;
    }
    // getter for getting number of students
    public static int getNumStudents() {
        return numStudents;
    }
    // getter for getting next
    public Student getNext() {
        return next;
    }
    // setter for setting id/data
    public void setID(int ID) {
        this.ID = ID;
    }
    // setter for setting first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // setter for setting last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // setter for setting phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // setter for setting balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
    // setter for setting called numbers
    public void setCalledNumbers(String[] calledNumbers) {
        this.calledNumbers = calledNumbers;
    }
    // setter for setting call duration
    public void setCallDuration(int[] callDuration) {
        this.callDuration = callDuration;
    }
    // setter for setting texted numbers
    public void setTextedNumbers(String[] textedNumbers) {
        this.textedNumbers = textedNumbers;
    }
    // setter for setting num students
    public static void setNumStudents(int numStudents) {
        Student.numStudents = numStudents;
    }
    // setter for setting next
    public void setNext(Student next) {
        this.next = next;
    }
    
    
    
    
    
    
    
}
