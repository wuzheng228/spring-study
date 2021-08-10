package chapter2.section02.topic01.demo02;

import chapter2.section02.topic01.demo01.ICourse;
import chapter2.section02.topic01.demo01.JavaCourse;

/**
 * Created by 76973 on 2021/8/1 17:57
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
