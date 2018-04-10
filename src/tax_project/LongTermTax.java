package Tax_Project;

public class LongTermTax implements FeeScheme {

    @Override
    public double feeAtBuy(double amount) {
        if (amount <= 1000) {
            return 0;
        } else if (amount > 1000) {
            return (.01 * amount);
        }
        return 0;
    }

    @Override
    public double feeAtSell(double amount) {
        return .05 * amount;
    }
}
