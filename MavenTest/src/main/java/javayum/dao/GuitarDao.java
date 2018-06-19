package javayum.dao;

import javayum.domain.Guitar;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface GuitarDao {
    //数据初始化
    @Insert("insert into guitar (price,serialNumber,specId) values(" +1499.95+ ",'V95693',1),("+1549.95+",'V9512',2),("+5495.95+",'V9512',3)")
    void insertGuitar();


    @Select("select * from guitar ")
    List<Guitar> findAll();

    @Select("select * from guitar  where id =#{ID}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "price",property = "price"),
            @Result(column="serialNumber",property = "serialNumber"),
            @Result(column="specId",property = "spec",
                    one=@One(select = "javayum.dao.GuitarSpecDao.selectGuitarSpec",
                    fetchType = FetchType.EAGER))
    })
     Guitar selectGuitar(Integer ID);
}


