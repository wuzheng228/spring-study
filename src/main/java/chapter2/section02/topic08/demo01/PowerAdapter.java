package chapter2.section02.topic08.demo01;

/**
 * Created by 76973 on 2021/8/13 21:04
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int input = ac220.outPutAC220V();
        int adapterOutput = input / 44;
        System.out.println("使用PowerAdapter输入AC" + input + "V" + "输出" + adapterOutput + "V");
        return adapterOutput;
    }
}
