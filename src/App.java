
import models.Task;
import scheduler.RR;

public class App {
    public static void main(String[] args) throws Exception {
        var scan = new java.util.Scanner(System.in);
        
        System.out.print("Enter number of tasks: ");
        int n = scan.nextInt();
        
        // Use array instead of ArrayList
        Task[] taskArray = new Task[n];
        for (int i = 0; i < n; i++) {
            int at, bt, pri;
            
            // Validate arrival time
            while (true) {
                System.out.println("\nTask " + (i + 1) + ":");
                System.out.print("  Arrival Time: ");
                at = scan.nextInt();
                if (at >= 0) break;
                System.out.println("  Error: Arrival time must be >= 0");
            }
            
            // Validate burst time
            while (true) {
                System.out.print("  Burst Time: ");
                bt = scan.nextInt();
                if (bt > 0) break;
                System.out.println("  Error: Burst time must be > 0");
            }
            
            // Validate priority
            while (true) {
                System.out.print("  Priority: ");
                pri = scan.nextInt();
                if (pri >= 0) break;
                System.out.println("  Error: Priority must be >= 0");
            }
            
            int taskNum = i + 1;
            taskArray[i] = new Task("P" + taskNum, at, bt, pri);
        }
        
        System.out.print("\nEnter time quantum: ");
        int quantum = scan.nextInt();
        
        // Pass array directly to RR (varargs)
        RR rr = new RR(quantum, taskArray);
        rr.run();
        
        System.out.println("\n=== Round Robin Scheduling Complete ===");
        System.out.println("\nAll tasks completed!");

    }
}

