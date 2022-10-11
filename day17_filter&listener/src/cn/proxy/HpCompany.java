package cn.proxy;

/**
 * 真实类
 */
public class HpCompany implements SaleComputer {


    @Override
    public String sale(double money) {
        System.out.println("花了" + money + "元买了一台电脑······");
        return "hp电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑！！");
    }
}
