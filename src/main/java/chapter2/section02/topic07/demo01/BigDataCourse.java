package chapter2.section02.topic07.demo01;

/**
 * Created by 76973 on 2021/8/10 21:00
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomwork = false;

    public BigDataCourse(boolean needHomwork) {
        this.needHomwork  = needHomwork;
    }

    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业!");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomwork;
    }
}
