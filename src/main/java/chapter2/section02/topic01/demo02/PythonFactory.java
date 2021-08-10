package chapter2.section02.topic01.demo02;

import chapter2.section02.topic01.demo01.ICourse;
import chapter2.section02.topic01.demo01.PythonCourse;

/**
 * Created by 76973 on 2021/8/1 17:59
 */
public class PythonFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
