package homework2;

import java.util.Arrays;

public class ProcessQueue {
    private Process[] pq = new Process[10];
    private int length = 0;

    public void addProcess(Process process) {
        if (length == pq.length) {
            pq = Arrays.copyOf(pq, pq.length * 2);
        }
        pq[length] = process;
        swim(length);
        length++;
    }

    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        Process min = pq[0];
        pq[0] = pq[--length];
        pq[length] = null;
        sink(0);
        return min;
    }

    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[0];
    }

    private void swim(int k) {
        while (k > 0 && greater((k - 1) / 2, k)) {
            exch((k - 1) / 2, k);
            k = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (2 * k + 1 < length) {
            int j = 2 * k + 1;
            if (j < length - 1 && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Process swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public int getLength() {
        return length;
    }
}
