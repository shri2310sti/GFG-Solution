import java.util.stream.Collectors;


class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        return Arrays.stream(arr).filter(a -> a >= start && a <= end).boxed().collect(Collectors.toSet()).size() == (end - start + 1);
    }
}