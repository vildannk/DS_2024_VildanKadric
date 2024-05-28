package homework2;

public class Process implements Comparable<Process> {
    String name;
    int priority;
    int time;
    int arrivedtime;
    int remintime;

    public Process(String name, int priority, int time, int arrivedtime) {
        this.name = name;
        this.priority = priority;
        this.time = time;
        this.arrivedtime = arrivedtime;
        this.remintime = time;
    }

    @Override
    public int compareTo(Process other) {
        if (other == null) return -1;
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        } else {
            return Integer.compare(this.arrivedtime, other.arrivedtime);
        }
    }
}
