package Lesson6;

import java.lang.reflect.Array;

public class Atm {

    int quantityBankNotes20, quantityBankNotes50, quantityBankNotes100, currentAmount;
    int numberBanknotes50, numberBanknotes20, numberBanknotes100;
    boolean sucsess = true;
    int restSum, sum;
    public Atm(int quantityBankNotes20, int quantityBankNotes50, int quantityBankNotes100) {
        this.quantityBankNotes20 = quantityBankNotes20;
        this.quantityBankNotes50 = quantityBankNotes50;
        this.quantityBankNotes100 = quantityBankNotes100;
        this.currentAmount = quantityBankNotes20 * 20 + quantityBankNotes50 * 50 + quantityBankNotes100 * 100;

    }
    public void ShowInfomation() {
        System.out.println("Банкомат загружен на сумму " + this.currentAmount);
        System.out.println("Количество банкнот 100 - " + this.quantityBankNotes100 + ";");
        System.out.println("Количество банкнот 50 - " + this.quantityBankNotes50 + ";");
        System.out.println("Количество банкнот 20 - " + this.quantityBankNotes20 + ";");
    }
    public void AddAmount(int sum) {
        if (sum % 100 == 0 || sum % 50 == 0 || sum % 20 == 0) {

            this.currentAmount = this.currentAmount + sum;
            if (sum % 100 == 0) {
                this.quantityBankNotes100 = this.quantityBankNotes100 + sum / 100;
            } else {
                if (sum % 50 == 0) {
                    this.quantityBankNotes50 = this.quantityBankNotes50 + sum / 50;
                } else {
                    if (sum % 20 == 0) {
                        this.quantityBankNotes20 = this.quantityBankNotes20 + sum / 20;
                    }
                }
            }
        } else {
            System.out.println("Сумма должна быть кратна 100, 50 или 20. Попробуйте ешё раз.");
        }
    }

    public boolean WithdrawAmount(int sum) {
        sucsess = false;
        numberBanknotes100 = 0;
        numberBanknotes50 = 0;
        numberBanknotes20 = 0;
        restSum = sum;
        String str = "";
        boolean banknotesDefined = false;
//        int[] myArray;
//        myArray = new int[3];
//        myArray[0] = 100;
//        myArray[1] = 50;
//        myArray[2] = 20;

        for (int i = this.quantityBankNotes100; i >= 0; i--) {
//            if ((i * 100) > restSum) {
//                continue;
//            }
            if ((i * 100) <= restSum) {
                restSum = restSum - i * 100;
                if (i > 0) {
                    numberBanknotes100 = i;
                }
            }
            sucsess = checkRestSum(sum);
            if (!sucsess) {
                numberBanknotes100 = 0;
                //continue;
            }

        }
        if (restSum == 0) {
            str = ((numberBanknotes100 == 0) ? str : numberBanknotes100 + "x100 ") + ((numberBanknotes50 == 0) ? str : numberBanknotes50 + "x50 ") + ((numberBanknotes20 == 0) ? str : numberBanknotes20 + "x20 ");
            System.out.println("Сумма выдана следующими купюрами: " + str);
        } else {
            sucsess = false;
        }
        return sucsess;
    }

    public boolean checkRestSum(int sum) {
        numberBanknotes50 = 0;
        numberBanknotes20 = 0;
        //int tempRestSum = restSum;
        for (int j = this.quantityBankNotes50; j >= 0; j--) {
       // for (int j = 0; j <= this.quantityBankNotes50; j++) {
            if (restSum == 0) {
              break;
            }
            if (j * 50 <= restSum) {
                if (((restSum - j * 50) % 20 == 0) | ((restSum - j * 50) % 50 == 0)) {
                    restSum = restSum - 50;
                    numberBanknotes50++;
                }
            }
            for (int k = 1; k < this.quantityBankNotes20; k++) {
                if (restSum == 0) {
                  break;
                }
                if (k * 20 <= restSum) {
                    restSum = restSum - 20;
                    numberBanknotes20++;
                }
//
            }

        }
        if (restSum == 0) {
            sucsess = true;
        }
        if (!sucsess) {
           restSum = sum;
        }
        return sucsess;
    }
}
