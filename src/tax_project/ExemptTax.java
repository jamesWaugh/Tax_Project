package Tax_Project;

public class ExemptTax implements FeeScheme {

    protected boolean flag = true;
    protected int fee2;

    public ExemptTax(boolean temp1, int temp2) {
        flag = temp1;
        fee2 = temp2;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean temp) {
        flag = temp;
    }

    public int getFee() {
        return fee2;
    }

    public void setFee(int temp) {
        fee2 = temp;
    }

    @Override
    public double feeAtBuy(double amount) {
        if (flag) {
            this.setFlag(false);
            return 0;
        } else if (!flag) {
            return fee2;
        }
        return 0;
    }

    @Override
    public double feeAtSell(double amount) {
        if (flag) {
            this.setFlag(false);
            return 0;
        } else if (!flag) {
            return 500;
        }
        return 0;
    }
}
