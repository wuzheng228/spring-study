package chapter2.section02.topic07.demo01;

/**
 * Created by 76973 on 2021/8/10 20:48
 */
public abstract class NetworkCourse {

    protected final void createCourse() {
        this.postPreResource();
        this.createPPT();
        this.liveVideo();
        this.postNote();
        this.postSource();
        if (needHomework()) {
            checkHomework();
        }
    }

    abstract void checkHomework();

    // 钩子方法实现流程的微调
    protected boolean needHomework() {return false;};

    final void postSource() {
        System.out.println("提交源代码");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void createPPT() {
        System.out.println("创建备课PPT");
    }

    final void postPreResource() {
        System.out.println("分发预习资料");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }

}
