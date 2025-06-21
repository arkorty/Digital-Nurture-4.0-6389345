public class Main {
    public static void main(String[] args) {

        double[] historicalRevenue = { 12.5, 13.2, 14.1, 15.0, 16.3 };

        double avgGrowthRate = FinancialDataAnalyzer.calculateAverageGrowthRate(historicalRevenue);
        System.out.printf("Average growth rate: %.2f%%\n", avgGrowthRate * 100);

        double currentValue = historicalRevenue[historicalRevenue.length - 1];
        int forecastPeriods = 5;

        System.out.println("\nRecursive:");
        long startTime = System.nanoTime();
        double futureValue = FinancialForecaster.calculateFutureValue(currentValue, avgGrowthRate, forecastPeriods);
        long endTime = System.nanoTime();
        System.out.printf("Period %d: $%.2fM | Time: %d ns\n", forecastPeriods, futureValue, endTime - startTime);

        System.out.println("\nOptimized:");
        startTime = System.nanoTime();
        futureValue = FinancialForecaster.calculateFutureValueOptimized(currentValue, avgGrowthRate, forecastPeriods);
        endTime = System.nanoTime();
        System.out.printf("Period %d: $%.2fM | Time: %d ns\n", forecastPeriods, futureValue, endTime - startTime);

        System.out.println("\nTail Recursive:");
        startTime = System.nanoTime();
        futureValue = FinancialForecaster.calculateFutureValueTailRec(currentValue, avgGrowthRate, forecastPeriods);
        endTime = System.nanoTime();
        System.out.printf("Period %d: $%.2fM | Time: %d ns\n", forecastPeriods, futureValue, endTime - startTime);

        System.out.println("\nForecast Series:");
        double[] forecastSeries = FinancialDataAnalyzer.predictValueSeries(currentValue, avgGrowthRate,
                forecastPeriods);
        for (int i = 0; i < forecastSeries.length; i++) {
            System.out.printf("Period %d: $%.2fM\n", i + 1, forecastSeries[i]);
        }

        System.out.println("\nPerformance:");
        compareApproaches(5);
        compareApproaches(10);
        compareApproaches(20);
        compareApproaches(1000);
    }

    private static void compareApproaches(int periods) {
        double currentValue = 100;
        double growthRate = 0.05;

        System.out.printf("\n%d periods:\n", periods);

        try {
            long start = System.nanoTime();
            FinancialForecaster.calculateFutureValue(currentValue, growthRate, periods);
            long end = System.nanoTime();
            System.out.printf("Recursive: %d ns\n", end - start);
        } catch (StackOverflowError e) {
            System.out.println("Recursive: Stack overflow");
        }

        long start = System.nanoTime();
        FinancialForecaster.calculateFutureValueOptimized(currentValue, growthRate, periods);
        long end = System.nanoTime();
        System.out.printf("Optimized: %d ns\n", end - start);

        start = System.nanoTime();
        FinancialForecaster.calculateFutureValueTailRec(currentValue, growthRate, periods);
        end = System.nanoTime();
        System.out.printf("Tail recursive: %d ns\n", end - start);
    }
}
