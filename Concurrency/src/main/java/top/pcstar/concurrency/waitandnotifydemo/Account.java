package top.pcstar.concurrency.waitandnotifydemo;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 9:10 2018/7/25
 */
public class Account {
    private Integer balance;
    private Boolean flag = false;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    public synchronized void saveMoney(Integer balance) throws InterruptedException {
        if (getFlag()){
            wait();
        }
        System.out.println(this);
        setBalance(balance);
        setFlag(true);
        notify();
    }

    public synchronized void drawMoney() throws InterruptedException {
        if (!getFlag()){
            wait();
        }
        System.out.println(this);
        setBalance(0);
        setFlag(false);
        notify();
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", flag=" + flag +
                '}';
    }
}

class SaveMoney extends Thread{
    private Account account;
    public SaveMoney(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                account.saveMoney(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DrawMoney extends Thread{
    private Account account;
    public DrawMoney(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                account.drawMoney();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WaitAndNotifyTest{
    public static void main(String[] args) {
        Account account = new Account();
        SaveMoney saveMoney = new SaveMoney(account);
        DrawMoney drawMoney = new DrawMoney(account);
        saveMoney.start();
        drawMoney.start();
    }
}
