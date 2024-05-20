package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int[] result = {-1, -1};
        int left = 0;
        int right = entries.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = entries[mid].getName().compareTo(searchableName);

            if (comparison < 0) {
                left = mid + 1;
            } else if (comparison > 0) {
                right = mid - 1;
            } else {
                int start = mid;
                int end = mid;

                while (start > 0 && entries[start - 1].getName().equals(searchableName)) {
                    start--;
                }

                while (end < entries.length - 1 && entries[end + 1].getName().equals(searchableName)) {
                    end++;
                }

                return new int[]{start, end};
            }
        }
        return new int[]{};
    }


}