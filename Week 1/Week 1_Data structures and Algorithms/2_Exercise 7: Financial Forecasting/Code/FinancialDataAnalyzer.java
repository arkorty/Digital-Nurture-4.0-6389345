public class FinancialDataAnalyzer {
    public static double calculateAverageGrowthRate(double[] historicalValues) {
        if (historicalValues == null || historicalValues.length < 2) {
            throw new IllegalArgumentException("Need at least 2 historical values");
        }

        double totalGrowth = 0;
        for (int i = 1; i < historicalValues.length; i++) {
            double periodGrowth = (historicalValues[i] - historicalValues[i - 1]) / historicalValues[i - 1];
            totalGrowth += periodGrowth;
        }

        return totalGrowth / (historicalValues.length - 1);
    }

    public static double[] predictValueSeries(double initialValue, double growthRate, int periods) {
        double[] predictions = new double[periods];
        predictions[0] = initialValue * (1 + growthRate);

        for (int i = 1; i < periods; i++) {
            predictions[i] = predictions[i - 1] * (1 + growthRate);
        }

        return predictions;
    }
}
