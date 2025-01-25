import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(null, null, 0, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
        int selection = 0;  
        
        
        while (selection != 6) {
            System.out.println("============select===========");
            bank.Display(); 
            selection = scanner.nextInt();  
            
            switch (selection) {
                case 1:
                    bank.CreateAccount();; 
                    break;
                case 2:
                    bank.Withdraw();  
                    break;
                case 3:
                    bank.Deposit();  
                    break;
                case 4:
                    bank.Balance();  
                    break;
                case 5:
                    bank.AccountDetails();;  
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        
        scanner.close();  
}
}
