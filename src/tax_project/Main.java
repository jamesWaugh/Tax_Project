package Tax_Project;

import java.util.Random;

public class Main {

    public static int randRangeGen(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void portfolio() {

        Holding[] myHoldings = {new Stock(50, (double) randRangeGen(0, 150), true, (double) randRangeGen(0, 2)),
            new Stock(40, (double) randRangeGen(0, 150), false, (double) randRangeGen(0, 2)),
            new MoneyMarket(),
            new MoneyMarket(),
            new MoneyMarket(100, 100, false, new ExemptTax(true, 300))
        };

        for (int i = 0; i < myHoldings.length; i++) {
            myHoldings[i].buy(3000);
        }
        //buying things loop

        double total = 0;
        for (int d = 1; d < 5; d++) {
            //4 cycles
            for (int i = 1; i < 13; i++) {
                //12 months
                for (int k = 0; k < myHoldings.length; k++) {
                    //array runthrough
                    if (myHoldings[k] != null) {
                        total += myHoldings[k].update(i);
                    }
                    if (myHoldings[k] != null && myHoldings[k].getSharePrice() <= 1) {
                        myHoldings[k] = null;
                    }
                }
            }
            if (d == 1) {
                for (int r = 0; r < myHoldings.length - 1; r++) {
                    if (myHoldings[r] != null) {
                        myHoldings[r].setFee(new LongTermTax());
                    }
                }
            }
        }

        double totalTotal = total;
        for (int y = 0; y < myHoldings.length; y++) {
            if (myHoldings[y] != null) {
                totalTotal += myHoldings[y].sell(3000);
            }
        }
        System.out.println(totalTotal);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        portfolio();
        // TODO code application logic here
    }
}
