package com.rccode.enumeration;

public enum ExpenseType {
    PERCENT {
        @Override
        public boolean checkValidArgs(int[] splitShare, double target) {
            target = 100;
            double sum = 0;
            for (int i = 0; i < splitShare.length; i++) {
                sum += splitShare[i];
            }
            if (target != sum) {
                return false;
            }
            return true;
        }

        @Override
        public double getShare(double amount, int[] splitShare, int index) {
            if (index == 0) {
                double sum = 0;
                for (int i = 1; i < splitShare.length; i++) {
                    sum += getShare(amount, splitShare, i);
                }
                return amount - sum;
            } else {
                return ((double)splitShare[index] / 100) * amount;
            }
        }
    },
    EQUAL {
        @Override
        public double getShare(double amount, int[] splitShare, int index) {
            double share = amount / splitShare.length;
            if (index > 0) {
                return share;
            } else {
                return (amount - share * (splitShare.length - 1));
            }
        }
    },
    EXACT {
        @Override
        public boolean checkValidArgs(int[] splitShare, double target) {
            double sum = 0;
            for (int i = 0; i < splitShare.length; i++) {
                sum += splitShare[i];
            }
            if (target != sum) {
                return false;
            }
            return true;
        }

        @Override
        public double getShare(double amount, int[] splitShare, int index) {
            return splitShare[index];
        }

    };

    public boolean checkValidArgs(int[] splitShare, double target) {
        return true;
    }

    public double getShare(double amount, int[] splitShare, int index) {
        return 0;
    }
}
