package homework1;


public class MergeSort {

    public static void sort(Entry[] entries) {
        if (entries == null || entries.length < 2) {
            return;
        }
        mergeSort(entries, 0, entries.length - 1);
    }

    private static void mergeSort(Entry[] entries, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(entries, left, middle);
            mergeSort(entries, middle + 1, right);
            merge(entries, left, middle, right);
        }
    }

    private static void merge(Entry[] entries, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        Entry[] leftArray = new Entry[leftSize];
        Entry[] rightArray = new Entry[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = entries[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = entries[middle + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                entries[k++] = leftArray[i++];
            } else {
                entries[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            entries[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            entries[k++] = rightArray[j++];
        }
    }
}

