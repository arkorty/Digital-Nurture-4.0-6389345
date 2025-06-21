public class FinancialForecaster {
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods <= 0) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, periods - 1);
    }
    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int periods) {
        double[] memo = new double[periods + 1];
        memo[0] = currentValue;
        return calculateFutureValueMemo(currentValue, growthRate, periods, memo);
    }
    private static double calculateFutureValueMemo(double currentValue, double growthRate, int periods, double[] memo) {
        if (memo[periods] != 0) {
            return memo[periods];
        }
        if (periods == 0) {
            return currentValue;
        }
        double previousValue = calculateFutureValueMemo(currentValue, growthRate, periods - 1, memo);
        memo[periods] = previousValue * (1 + growthRate);
        return memo[periods];
    }
    public static double calculateFutureValueTailRec(double currentValue, double growthRate, int periods) {
        return tailRecHelper(currentValue, growthRate, periods, currentValue);
    }
    private static double tailRecHelper(double initialValue, double growthRate, int periodsRemaining,
            double accumulator) {
        if (periodsRemaining <= 0) {
            return accumulator;
        }
        return tailRecHelper(
                initialValue,
                growthRate,
                periodsRemaining - 1,
                accumulator * (1 + growthRate));
    }
}
