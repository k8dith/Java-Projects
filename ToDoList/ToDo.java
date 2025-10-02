import java.util.Scanner;

class Item 
{
    String task;
    int priority;
}

public class ToDo 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int numItems = 5;
        if (args.length > 0) 
        {
            try 
            {
                numItems = Integer.parseInt(args[0]);
            } 
            
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid number format. Using default of 5 items.");
            }
        }
        
        Item[] list = new Item[numItems];
        
        System.out.println("Enter " + numItems + " tasks for your To Do list:");

        for (int i = 0; i < numItems; i++) 
        {
        
            Item item = new Item();
            
            System.out.print("Task #" + i + ": ");
            item.task = scanner.nextLine();
            
            System.out.print("Priority from 1 (highest) to 5 (lowest): ");
            item.priority = scanner.nextInt();
            scanner.nextLine();
            
            list[i] = item;
        }
        

        System.out.println("\n    To Do List by Priority    ");
        for (int priority = 1; priority <= 5; priority++) 
        {
            for (int i = 0; i < numItems; i++) 
            {
                if (list[i].priority == priority) 
                {
                    System.out.println(priority + " " + list[i].task);
                }
            }
        }
        
        scanner.close();
    }
}