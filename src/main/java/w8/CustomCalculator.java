package w8;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface CustomCalculator {

    // 짝수의 합.
    default int addEvenNumbers(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }

    // 홀수의 합.
    default int addOddNumbers(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }

    // 더하기.
    private int add(IntPredicate predicate, int... nums) {
        return IntStream.of(nums)
                .filter(predicate)
                .sum();
    }

}
