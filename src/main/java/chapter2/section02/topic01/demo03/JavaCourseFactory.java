package chapter2.section02.topic01.demo03;

/**
 * Created by 76973 on 2021/8/1 18:10
 */
public class JavaCourseFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
