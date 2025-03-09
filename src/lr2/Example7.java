package lr2;

public class Example7 {
    interface BankAccountInterface {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    static class BankAccount implements BankAccountInterface {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance < 0)
                System.out.println("Начальный баланс не может быть отрицательным");
            else {
                this.balance = initialBalance;
            }
        }

        @Override
        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Депозит не может быть отрицательным или нулевым");
            }
            else {
                balance += amount;
                System.out.println("Депозит на сумму " + amount + " успешно внесен");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Нельзя снять отрицательную или нулевую сумму");
            }
            else if (amount > balance) {
                System.out.println("На счете недостаточно средств");
            }
            else {
                balance -= amount;
                System.out.println("Сумма " + amount + " успешно снята");
            }
        }

        @Override
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        account.deposit(50);
        System.out.println("Баланс после депозита: " + account.getBalance());

        account.withdraw(30);
        System.out.println("Баланс после снятия: " + account.getBalance());

        account.deposit(-1000);
        account.withdraw(-1000);
        account.withdraw(1000);
    }
}
