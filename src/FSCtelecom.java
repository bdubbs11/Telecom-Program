// program 2 - fsc telecom - linked lists
// Brandon Wilson
// Dr. Cazalas 3280
// 9-20-22
// brandonewilson2002@gmail.com
// 1260637
import java.util.*;
public class FSCtelecom {

  
	// FINAL (CONSTANT) variables
	public static final double ratePerMinute = 0.05;
	public static final double smsRate = 0.02;
	public static final double dataRatePerKB = (1.0 / 1024.0) / 100.0;

	public static void addAccount(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
		// Note that this method should use the insert() method of the Linked List class
                        System.out.println("Command: ADDACCOUNT");
                        
                        //if(accounts.search(Integer.parseInt(inputLine[1])))
                        
                        Student students = new Student(Integer.parseInt(inputLine[1]), inputLine[2],inputLine[3],inputLine[4]);
                        // inserts it into the linked lists
                        accounts.insert(students);
                        // print statements
                        System.out.printf("	Name:          %s %s\n", inputLine[2],inputLine[3]);// first name and last name
                        System.out.printf("	Student ID:    %s\n", inputLine[1]);// student id
                        System.out.printf("	Phone Number:  %s\n", inputLine[4]); // phone number
                        System.out.println("	Balance:       $20.00\n");// balancd
	}
        
                // method that does the shifting and sorting while also adding the call data into accounts
                public static void shiftAndSort(FSCTelecomAccounts accounts, String[] inputLine, int time, String which){
                    // call duration at index 0 is equal to 0 put it in the first instance
                    // called numbers will be equal to call duration for "i" so only have to check one
                        // returns the index of the new space created for the product newly created
                        
                        if (which.equals("both")) {
                            // creating an empty array of called numbers and call times to be able to shift and save the new info
                            String[] calledNums = accounts.findNode(Integer.parseInt(inputLine[1])).getCalledNumbers();
                            int[] callTimes = accounts.findNode(Integer.parseInt(inputLine[1])).getCallDuration();
                            // to loop over 9 times essentially
                            for (int i = calledNums.length - 1; i > 0; i--) {
                                // shifting the indicies over together
                                    calledNums[i] = calledNums[i-1];
                                    callTimes[i] = callTimes[i-1];
                            }
                            // saving the new information at spot 0
                            calledNums[0] = inputLine[2];
                            callTimes[0] = time;
                        // string equals text or essentially anything other than both
                        }else{
                            // creating an empty array of texted numbers to be able to shift and save the new info
                            String[] textedNums = accounts.findNode(Integer.parseInt(inputLine[1])).getTextedNumbers();
                            // to loop over 9 times essentially
                            for (int i = textedNums.length - 1; i > 0; i--) {
                                // shifting the indicies over 
                                    textedNums[i] = textedNums[i-1];
                            }
                            // saving the new information at spot 0
                            textedNums[0] = inputLine[2];
                        }
                }
                

	public static void makeCall(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                                System.out.println("Command: MAKECALL");
                                 // finding the student is true                                        & the desired time is 5 cents per every minute is less than the balance the person has in their account
                                if(accounts.search(Integer.parseInt(inputLine[1])) && (Integer.parseInt(inputLine[3]) * .05) <= accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()){
                                        System.out.printf("	Name:           %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                        System.out.printf("	Phone Number:   %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                        System.out.printf("	Number Called:  %s\n",inputLine[2]); // the number that is being called
                                        System.out.printf("	Call Duration:  %s minutes\n",inputLine[3]); // the call duration
                                        System.out.printf("	Prev Balance:   $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance());// balance before it is updated
                                        System.out.printf("	Call Cost:      $%.2f\n",(Integer.parseInt(inputLine[3]) * .05)); // how mucht the call was
                                        // sets the new balance to be the previous balance subtracted by the amount the call was
                                        accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() - (Integer.parseInt(inputLine[3]) * .05));
                                        System.out.printf("	New Balance:    $%.2f\n\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()); // the new balance
                                        // add the called numbers and call history
                                        shiftAndSort(accounts, inputLine, Integer.parseInt(inputLine[3]), "both");
                                        
                                }// finding the student is true                                              & the desired time is 5 cents per every minute is greater or equal to the time the person has in their acccount             // for one test case
                                else if(accounts.search(Integer.parseInt(inputLine[1])) && ((Integer.parseInt(inputLine[3]) * .05) >= accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()) && accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() >= 0.05){
                                        double prevBalance = accounts.findNode(Integer.parseInt(inputLine[1])).getBalance();
                                        
                                        double tempTimeAllowed = (accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() / .05);
                                        int timeAllowed = (int) Math.floor(tempTimeAllowed);
                                        
                                        //int callTime = 0;
                                        // to loop over the amount in the balance as long as its greater than the cost of a minute (.05)
                                        //while(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() >= .05){
                                            // sets the the balance to .05 cents less of what it was
                                            //accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() - .05);
                                            // gets the new call time for every time this function runs
                                           // callTime += 1;
                                        //}
                                        System.out.printf("	Name:           %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                        System.out.printf("	Phone Number:   %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                        System.out.printf("	Number Called:  %s\n",inputLine[2]); // the number that is being called
                                        System.out.printf("	Call Duration:  %s\n",timeAllowed); // the call duration
                                        System.out.printf("	Prev Balance:   $%.2f\n",prevBalance);// balance before it is updated
                                        System.out.printf("	Call Cost:      $%.2f\n",timeAllowed * .05); // how mucht the call was
                                        accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() - (timeAllowed * .05));
                                        System.out.printf("	New Balance:    $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()); // the new balance
                                        System.out.println("	***Call terminated due to low balance.\n");
                                        //int blah = (int)(callTime);
                                        shiftAndSort(accounts, inputLine, timeAllowed, "both");
                                    
                                            // the person is not found or their balance is 0
                                }else{ // accounts.search(Integer.parseInt(inputLine[1])) == false || accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() == 0
                                    // the person is not found
                                    if( accounts.search(Integer.parseInt(inputLine[1])) == false ){
                                        System.out.println("	Cannot perform MAKECALL. Account does not exist in FSC Telecom System.\n");
                                    }// there is not enough money in the account
                                    else{//accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() == 0
                                        System.out.println("	Cannot perform MAKECALL. Account has insufficient balance.\n");
                                    }
                                }
	}

	public static void sendText(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                                System.out.println("Command: SENDTEXT");
                                 // finding the student is true                                        & the desired time is 2 cents per every text is less than the balance the person has in their account
                                if(accounts.search(Integer.parseInt(inputLine[1])) && .02 <= accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()){
                                        System.out.printf("	Name:           %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                        System.out.printf("	Phone Number:   %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                        System.out.printf("	Number Texted:  %s\n",inputLine[2]); // the number that is being called
                                        System.out.printf("	Prev Balance:   $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance());// balance before it is updated
                                        System.out.printf("	Text Cost:      $%.2f\n",0.02); // how mucht the call was
                                        // sets the new balance to be the previous balance subtracted by the amount the call was
                                        accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() - .02);
                                        System.out.printf("	New Balance:    $%.2f\n\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()); // the new balance
                                        // add the called numbers and call history
                                        // this number should never be read in the function im calling, if it does i have to do some more work :(
                                        shiftAndSort(accounts, inputLine,42069, "text");
                                        
                                }else{ // accounts.search(Integer.parseInt(inputLine[1])) == false || accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() == 0
                                    // the person is not found
                                    if( accounts.search(Integer.parseInt(inputLine[1])) == false ){
                                        System.out.println("	Cannot perform SENDTEXT. Account does not exist in FSC Telecom System.\n");
                                    }// there is not enough money in the account
                                    else{//accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() == 0
                                        System.out.println("	Cannot perform SENDTEXT. Account has zero balance.\n");
                                    }
                                }
                               
	}

	public static void useData(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                                System.out.println("Command: USEDATA");
                
                                // this next variable is inside your useData() method
                                double dataCost = Math.ceil(Integer.parseInt(inputLine[2]) * dataRatePerKB * 100000.0) / 100000.0;
                                dataCost = ((int)(dataCost * 100))/100.0;
                                
                                 // finding the student is true                                        & the desired amount is ok to be used in the in their account
                                if(accounts.search(Integer.parseInt(inputLine[1])) && dataCost <= accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()){
                                        System.out.printf("	Name:           %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                        System.out.printf("	Phone Number:   %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                        System.out.printf("	Kilobytes:      %s\n",inputLine[2]); // the number that is being called
                                        System.out.printf("	Prev Balance:   $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance());// balance before it is updated
                                        System.out.printf("	Data Cost:      $%.2f\n",dataCost); // how mucht the data was
                                        // sets the new balance to be the previous balance subtracted by the amount the data was
                                        accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() - dataCost);
                                        System.out.printf("	New Balance:    $%.2f\n\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()); // the new balance
                                    //they dont have enough or preson doesnt exst
                                }else{
                                    if(accounts.search(Integer.parseInt(inputLine[1])) == false){
                                        System.out.println("	Cannot perform USEDATA. Account does not exist in FSC Telecom System.\n");
                                    }else{// there is not enough balance in the account
                                        System.out.println("	Cannot perform USEDATA. Account does not have enough balance.\n");
                                    }
                                }       
	}

	public static void recharge(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                                System.out.println("Command: RECHARGE");
                                 // finding the student is true                                        & the desired amount is ok to be used in the in their account
                                if(accounts.search(Integer.parseInt(inputLine[1]))){
                                        System.out.printf("	Name:            %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                        System.out.printf("	Phone Number:    %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                        System.out.printf("	Recharge Amount: $%.2f\n",Double.parseDouble(inputLine[2])); // the number that is being called
                                        // adds the recharge amount to the old balance
                                        accounts.findNode(Integer.parseInt(inputLine[1])).setBalance(accounts.findNode(Integer.parseInt(inputLine[1])).getBalance() + Double.parseDouble(inputLine[2]));
                                        System.out.printf("	New Balance:     $%.2f\n\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance()); // the new balance
                                    //person doesnt exist in account
                                }else{
                                    System.out.println("	Cannot perform RECHARGE. Account does not exist in FSC Telecom System.\n");
                                } 
                                
	}

	public static void deleteAccount(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
		// Note that this method should use the delete() method of the Linked List class
                        System.out.println("Command: DELETEACCOUNT");
                        // if the specific account could be found
                        if(accounts.search(Integer.parseInt(inputLine[1]))){
                            System.out.printf("	Name:           %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                            System.out.printf("	Student ID:     %s\n",inputLine[1]);// student id number
                            System.out.printf("	Phone Number:   %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                            System.out.printf("	Balance:        $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance());// balance
                            // deleteing the account above
                            System.out.println("	***Account has been deleted.");
                            // actually delete
                            accounts.delete(Integer.parseInt(inputLine[1]));
                            
                        }else{// if nothing matches
                            System.out.println("	Cannot perform DELETEACCOUNT. Account does not exist in FSC Telecom System.");
                        }
                
	}

	public static void search(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                        System.out.println("Command: SEARCH");
                        // if the account can be found
                        if(accounts.search(Integer.parseInt(inputLine[1])) == true){
                            System.out.printf("	Name:          %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                            System.out.printf("	Student ID:    %s\n",inputLine[1]);// student id number
                            System.out.printf("	Phone Number:  %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                            System.out.printf("	Balance:       $%.2f\n",accounts.findNode(Integer.parseInt(inputLine[1])).getBalance());// balance
                        }else{// if nothing matches
                            System.out.println("	Cannot perform SEARCH. Account does not exist in FSC Telecom System.\n");
                        }
                        
	}

	public static void displayDetails(FSCTelecomAccounts accounts, String[] inputLine) {
		// Note that this method should use the search() or findNode() method of the Linked List class
                                // if the specific account could be found
                                System.out.println("Command: DISPLAYDETAILS");
                                if(accounts.search(Integer.parseInt(inputLine[1]))){
                                    System.out.printf("	Name:          %s %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getFirstName(),accounts.findNode(Integer.parseInt(inputLine[1])).getLastName());// first and last name
                                    System.out.printf("	Student ID:    %s\n",inputLine[1]);// student id number
                                    System.out.printf("	Phone Number:  %s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getPhoneNumber());// phone number
                                    System.out.println("	Called Numbers and Duration:");// number and duration header
                                    if(accounts.findNode(Integer.parseInt(inputLine[1])).getCalledNumbers()[0] == null){
                                        System.out.println("		(user has not made any calls yet)");
                                    }else{
                                        // loop over the size of array
                                        for (int i = 0; i < 10; i++) {
                                            //if statement to only print the thing that are actually in the list
                                            if(accounts.findNode(Integer.parseInt(inputLine[1])).getCalledNumbers()[i] == null){
                                                // print nothing
                                            }else{// they have something in the array 
                                                System.out.printf("		%s (%d)\n",accounts.findNode(Integer.parseInt(inputLine[1])).getCalledNumbers()[i], accounts.findNode(Integer.parseInt(inputLine[1])).getCallDuration()[i]);
                                            }
                                        }
                                    }
                                    System.out.println("	Texted Numbers:");// number and duration header
                                    // if head is null print error and do nothing with the else
                                    if(accounts.findNode(Integer.parseInt(inputLine[1])).getTextedNumbers()[0] == null){
                                            System.out.println("		(user has not made any texts yet)");
                                        }else{
                                        // loop over the size of array
                                        for (int i = 0; i < 10; i++) {
                                            //if statement to only print the thing that are actually in the list
                                            if(accounts.findNode(Integer.parseInt(inputLine[1])).getTextedNumbers()[i] == null){
                                                // print nothing
                                            }else{// they have something in the array 
                                                System.out.printf("		%s\n",accounts.findNode(Integer.parseInt(inputLine[1])).getTextedNumbers()[i]);
                                            }
                                        }
                                    }
                                    
                                }else{
                                    System.out.println("	Cannot perform DISPLAYDETAILS. Account does not exist in FSC Telecom System.\n");
                                }
                                
	}

	//*************//
	// MAIN METHOD //
	//*************//
	public static void main(String[] args) {
		// Variables needed for program
		String[] inputLine; // used to save the command read from input file
		Scanner in = new Scanner(System.in);

		// Make linked-list
		FSCTelecomAccounts accounts = new FSCTelecomAccounts();
		// ^ ^ ^ ^ ^
		// | | | | |
		// | | | | |     "accounts" is the reference variable that points
		//               to your linked-list of Student objects
		
		// MAIN DO/WHILE LOOP:
		//    - We read commands and then process the commands by calling
		//      the appropriate methods.
		while (true) {
			inputLine = in.nextLine().split(" ");

			// ADDACCOUNT
			if (inputLine[0].equals("ADDACCOUNT") == true) {
				addAccount(accounts, inputLine);
				// NOTE: what are we sending to this method?
				//       Two things:
				//       1. a reference to the linked list (accounts)
				//       2. a reference to the array which has the inputLine
			}

			// MAKECALL
			else if (inputLine[0].equals("MAKECALL") == true) {
				makeCall(accounts, inputLine);
			}

			// SENDTEXT
			else if (inputLine[0].equals("SENDTEXT") == true) {
				sendText(accounts, inputLine);
			}

			// USEDATA
			else if (inputLine[0].equals("USEDATA") == true) {
				useData(accounts, inputLine);
			}

			// RECHARGE
			else if (inputLine[0].equals("RECHARGE") == true) {
				recharge(accounts, inputLine);
			}

			// DELETEACCOUNT
			else if (inputLine[0].equals("DELETEACCOUNT") == true) {
				deleteAccount(accounts, inputLine);
			}

			// SEARCH
			else if (inputLine[0].equals("SEARCH") == true) {
				search(accounts, inputLine);
			}

			// DISPLAYDETAILS
			else if (inputLine[0].equals("DISPLAYDETAILS") == true) {
				displayDetails(accounts, inputLine);
			}

			// Command QUIT: Quit the Program
			else if (inputLine[0].equals("QUIT") == true) {
				System.out.println("Command: QUIT.");
				System.out.println("\tExiting the FSC Telecom System...");
				System.out.println("\tGoodbye.");
				break;
			}

			// Invalid Command --- this will NEVER occur if you coded things correctly
			else {
				System.out.println("Invalid Command: input invalid.");
			}

		} // END while loop

	} // END main() method
}

    

