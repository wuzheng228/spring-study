package chapter2.section01.demo04;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 76973 on 2021/8/1 15:14
 */
public interface IRowMapper<T> {
     List<T> mapping(ResultSet rs) throws SQLException;
}
