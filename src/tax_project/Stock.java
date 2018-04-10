package Tax_Project;

import java.util.Random;

public class Stock extends Holding {

    public Stock() {
        dividendPercent = 1;
        shares = 100;
        shareprice = 100;
        reinvest = false;
        fee = new ShortTermTax();
    }

    public Stock(double temp1, double temp2, boolean temp3, double temp4, FeeScheme temp5) {
        dividendPercent = temp4;
        if (temp1 >= 0) {
            shares = temp1;
        }
        if (temp2 >= 0) {
            shareprice = temp2;
        }
        reinvest = temp3;
        fee = temp5;
    }

    public Stock(double temp1, double temp2, boolean temp3, double temp4) {
        dividendPercent = temp4;
        if (temp1 >= 0) {
            shares = temp1;
        }
        if (temp2 >= 0) {
            shareprice = temp2;
        }
        reinvest = temp3;
    }

    protected double dividendPercent;

    public double getDividendPercent() {
        return dividendPercent;
    }

    public void setDividendPercent(double temp) {
        dividendPercent = temp;
    }

    public static int randRangeGen(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    @Override
    public double update(int month) {
        double dividendAmount = shareprice * dividendPercent;
        shareprice = shareprice * (randRangeGen(75, 125) / 100);
        if (month == 1 || month == 4 || month == 7 || month == 10) {
            if (!reinvest) {
                return dividendAmount - fee.feeAtSell(dividendAmount);
            } else if (reinvest) {
                buy(dividendAmount);
                return 0;
            }
        } else {
            return 0;
        }
        return 0;
    }
}
