import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> result = intList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(result.toString());

        nonStream(intList);
    }

    public static void nonStream(List<Integer> intlist){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < intlist.size(); i++){
            if (intlist.get(i) < 1){
                continue;
            }
            if (intlist.get(i) % 2 != 0){
                continue;
            }
            for(int j = 0; j < result.size() + 1; j++){
                if (result.size() <= j){
                    result.add(intlist.get(i));
                    break;
                }
                if (result.get(j) > intlist.get(i)){
                    result.add(j ,intlist.get(i));
                    break;
                }

            }
        }
        System.out.println(result.toString());
    }
}