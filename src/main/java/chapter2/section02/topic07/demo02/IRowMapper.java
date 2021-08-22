package chapter2.section02.topic07.demo02;

import java.sql.ResultSet;

/**
 * Created by 76973 on 2021/8/10 21:09
 */
public interface IRowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
