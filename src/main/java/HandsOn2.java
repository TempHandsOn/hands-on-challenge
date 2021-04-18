import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandsOn2 {
    // fields
    private Integer[] values;
    private int targetNumber;

    // constructor
    public HandsOn2() {
        this.values = new Integer[4];
        this.targetNumber = 0;
    }

    // methods
    public Integer[] getExpressionValues() {
        return values;
    }

    public void setTargetNumber(int userTargetNumber) {
        this.targetNumber = userTargetNumber;
    }

    public void setExpressionValues(Integer[] expressionValues) {
        this.values = expressionValues;
    }

    public String startExpressionResolution() {
        for (Integer integer : values) {
            List<Integer> runList = new ArrayList<Integer>(Arrays.asList(values));
            runList.remove(integer);

            ExpressionResult result = attemptExpressionCombinations(runList, integer, targetNumber);
            if (result.success) {
                return targetNumber + " = " + "(((" + integer + result.output;
            }
        }
        return "The target number cannot be achieved with the 4 numbers supplied";
    }

    public void processChallenge() {
        System.out.println(startExpressionResolution());
    }

    private static class ExpressionResult {
        public String output;
        public boolean success;
    }

    /**
     * Brute force approach to recursively attempting all combinations of using the operators +, * and -
     * against our 4 user inputted numbers to reach the target number.
     *
     * @param numbers   List<Integer>
     * @param midNumber int
     * @param target    int
     * @return
     */
    private static ExpressionResult attemptExpressionCombinations(List<Integer> numbers, int midNumber, int target) {
        ExpressionResult midExpressionResult = new ExpressionResult();

        // Base case to ensure that when we have a correct result and we have used ALL numbers
        // Ignore correct results using subset of the numbers
        if (midNumber == target && numbers.isEmpty()) {
            midExpressionResult.success = true;
            midExpressionResult.output = "";
            return midExpressionResult;
        }

        for (Integer number : numbers) {
            List<Integer> newList = new ArrayList<Integer>(numbers);
            newList.remove(number);
            // This is the last number during this combination attempt
            // i.e.  ((1+3)*5) * 4 == 20  || ((1+3)*5) - 4 == 20  || ((1+3)*5) + 4 == 20
            // This is where we build the result output to return to the user
            if (newList.isEmpty()) {
                if (midNumber - number == target) {
                    midExpressionResult.success = true;
                    midExpressionResult.output = "-" + number + ")";
                    return midExpressionResult;
                }
                if (midNumber + number == target) {
                    midExpressionResult.success = true;
                    midExpressionResult.output = "+" + number + ")";
                    return midExpressionResult;
                }
                if (midNumber * number == target) {
                    midExpressionResult.success = true;
                    midExpressionResult.output = "*" + number + ")";
                    return midExpressionResult;
                }
                midExpressionResult.success = false;
                midExpressionResult.output = "f" + number;
                return midExpressionResult;
            } else {
                // Recursively attempt each operation at midExpressionResult ((1+3) ? 5) ... ?
                // i.e.
                // ((1+3) - 5) * 4 == 20  || ((1+3) - 5) - 4 == 20  || ((1+3) - 5) + 4 == 20
                // ((1+3) + 5) * 4 == 20  || ((1+3) + 5) - 4 == 20  || ((1+3) + 5) + 4 == 20
                // ((1+3) * 5) * 4 == 20  || ((1+3) * 5) - 4 == 20  || ((1+3) * 5) + 4 == 20
                // If no successful combination is found, return to the call above and try the next
                // number and all of the underlying combinations ((1+3) ? 4) ... ?
                // i.e.
                // ((1+3) - 4) * 5 == 20  || ((1+3) - 4) - 5 == 20  || ((1+3) - 4) + 5 == 20
                // ((1+3) + 4) * 5 == 20  || ((1+3) + 4) - 5 == 20  || ((1+3) + 4) + 5 == 20
                // ((1+3) * 4) * 5 == 20  || ((1+3) * 4) - 5 == 20  || ((1+3) * 4) + 5 == 20

                // If no successful result is found, we need to return one level up to the next
                // operator along for the combination 1 and 3. (1 + 3) -> (1 * 3) .. then repeat
                // the combinations above

                // If no successful combination is found using the combination of 1 and 3, we will
                // then move onto the next number and try all combinations with 1 and 4
                // (1 + 4) ... (1 - 4) ... (1 * 4) ... re-including 3 and 5 into the equation.
                midExpressionResult = attemptExpressionCombinations(newList, midNumber - number, target);
                if (midExpressionResult.success) {
                    midExpressionResult.output = "-" + number + ")" + midExpressionResult.output;
                    return midExpressionResult;
                }
                midExpressionResult = attemptExpressionCombinations(newList, midNumber + number, target);
                if (midExpressionResult.success) {
                    midExpressionResult.output = "+" + number + ")" + midExpressionResult.output;
                    return midExpressionResult;
                }
                midExpressionResult = attemptExpressionCombinations(newList, midNumber * number, target);
                if (midExpressionResult.success) {
                    midExpressionResult.output = "*" + number + ")" + midExpressionResult.output;
                    return midExpressionResult;
                }
            }
        }
        return midExpressionResult;
    }
}
