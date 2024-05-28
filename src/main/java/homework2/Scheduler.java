package homework2;

import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        Collections.sort(processes, (a, b) -> Integer.compare(a.arrivedtime, b.arrivedtime));

        int currentTime = 0;
        int processIndex = 0;
        Process currentProcess = null;

        while (processIndex < processes.size() || currentProcess != null || pq.getLength() > 0) {
            while (processIndex < processes.size() && processes.get(processIndex).arrivedtime <= currentTime) {
                pq.addProcess(processes.get(processIndex));
                processIndex++;
            }

            if (currentProcess != null && pq.getLength() > 0 && pq.peekNextProcess().compareTo(currentProcess) < 0) {
                pq.addProcess(currentProcess);
                currentProcess = pq.runNextProcess();
            }

            if (currentProcess == null && pq.getLength() > 0) {
                currentProcess = pq.runNextProcess();
            }

            if (currentProcess != null) {
                System.out.println("t = " + currentTime + " -> " + currentProcess.name + " is running");
                currentProcess.remintime--;

                if (currentProcess.remintime == 0) {
                    currentProcess = null;
                }
            } else {
                System.out.println("t = " + currentTime + " -> No process is running");
            }

            currentTime++;
        }

        System.out.println("Total time taken: " + currentTime);
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        /** Example 1
         processes.add(new Process("P1", 1, 4, 0));
         processes.add(new Process("P2", 2, 3, 0));
         processes.add(new Process("P3", 1, 7, 6));
         processes.add(new Process("P4", 3, 4, 11));
         processes.add(new Process("P5", 2, 2, 12));
         **/
        /** Example 2
         processes.add(new Process("P1", 5, 4, 0));
         processes.add(new Process("P2", 4, 3, 1));
         processes.add(new Process("P3", 3, 1, 2));
         processes.add(new Process("P4", 2, 5, 3));
         processes.add(new Process("P5", 2, 2, 4));
         **/
        /** Example 3
        processes.add(new Process("P1", 3, 3, 0));
        processes.add(new Process("P2", 2, 4, 1));
        processes.add(new Process("P3", 4, 6, 2));
        processes.add(new Process("P4", 6, 4, 3));
        processes.add(new Process("P5", 10, 2, 5));
         **/
        /** Example 4
         processes.add(new Process("P1", 2, 1, 0));
         processes.add(new Process("P2", 6, 7, 1));
         processes.add(new Process("P3", 3, 3, 2));
         processes.add(new Process("P4", 5, 6, 3));
         processes.add(new Process("P5", 4, 5, 4));
         processes.add(new Process("P6", 10, 15, 5));
         processes.add(new Process("P7", 9, 8, 15));
         **/
        // Example 5
        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));


        scheduleAndRun(processes);
    }
}
