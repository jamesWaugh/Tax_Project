package Tax_Project;

public abstract class Holding {

    protected double shares;
    protected double shareprice;
    protected boolean reinvest;
    protected FeeScheme fee;

    public FeeScheme getFee() {
        return fee;
    }

    public void setFee(FeeScheme temp) {
        fee = temp;
    }

    public double getShare() {
        return shares;
    }

    public double getSharePrice() {
        return shareprice;
    }

    public boolean getReinvest() {
        return reinvest;
    }

    public void setShare(double temp) {
        if (temp >= 0) {
            shares = temp;
        }
    }

    public void setSharePrice(double temp) {
        if (temp >= 0) {
            shareprice = temp;
        }
    }

    public void setReinvest(boolean temp) {
        reinvest = temp;
    }

    public Holding() {
        shares = 100;
        shareprice = 100;
        reinvest = false;
        fee = new ShortTermTax();
    }

    public Holding(double temp1, double temp2, boolean temp3, FeeScheme temp4) {
        if (temp1 >= 0) {
            shares = temp1;
        }
        if (temp2 >= 0) {
            shareprice = temp2;
        }
        reinvest = temp3;
        fee = temp4;
    }

    public double getValue() {
        return (shares * shareprice);
    }

    public void buy(double amt) {
        System.out.println("You can buy " + (amt / shareprice) + " shares");
        shares += ((amt - fee.feeAtBuy(amt)) / shareprice);
    }

    public double sell(double amt) {
        System.out.println("You have to sell " + (amt / shareprice) + " shares");
        if (shares - (amt / shareprice) >= 0) {
            shares -= ((amt - fee.feeAtSell(amt)) / shareprice);
        }
        return amt;
    }

    public abstract double update(int month);

}
