package Tax_Project;

public class ShortTermTax implements FeeScheme {

    @Override
    public double feeAtBuy(double amount) {
        return .01 * amount;
    }

    @Override
    public double feeAtSell(double amount) {
        if (amount <= 1000) {
            return .1 * amount;
        } else if (amount > 1000) {
            return (.1 * 1000) + (.2 * (amount - 1000));
        }
        return 0;
    }
}
