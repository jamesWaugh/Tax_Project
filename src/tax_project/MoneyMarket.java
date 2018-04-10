package Tax_Project;

import java.util.Random;

public class MoneyMarket extends Holding {

    public MoneyMarket() {
        shares = 100;
        shareprice = 100;
        reinvest = false;
        fee = new ShortTermTax();
    }

    public MoneyMarket(double temp1, double temp2, boolean temp3, FeeScheme temp4) {
        if (temp1 >= 0) {
            shares = temp1;
        }
        if (temp2 >= 0) {
            shareprice = temp2;
        }
        reinvest = temp3;
        fee = temp4;
    }

    @Override
    public double getSharePrice() {
        return 1;
    }

    @Override
    public void setSharePrice(double temp) {
        //I laugh at your temp
        shareprice = 1;
    }

    public static int randRangeGen(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    @Override
    public double update(int month) {
        double dividendAmount = ((randRangeGen(75, 125) / 100) * shareprice) - shareprice;
        if (dividendAmount < 0) {
            if (shares - Math.abs(dividendAmount) >= 0) {
                shares -= Math.abs(dividendAmount);
            }
        } else if (dividendAmount >= 0) {
            if (!reinvest) {
                return dividendAmount - fee.feeAtSell(dividendAmount);
            } else if (reinvest) {
                buy(dividendAmount);
            }
        }
        return 0;
    }
}
