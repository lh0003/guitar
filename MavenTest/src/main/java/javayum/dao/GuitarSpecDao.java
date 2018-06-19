package javayum.dao;

import javayum.domain.GuitarSpec;
import org.apache.ibatis.annotations.*;

public interface GuitarSpecDao {

    //初始化数据
    @Insert("insert into guitarSpec (builder,model,type,numStrings,backWood,topWood) " +
            "values('COLLINGS','CJ','ACOUSTIC',6,'INDIAN_ROSEWOOD','SITKA'),('FENDER','Stratocastor','ELECTRIC',6,'ALDER','ALDER')," +
            "('MARTIN','OM-28','ACOUSTIC',6,'BRAZILIAN_ROSEWOOD','ADIRONDACK'),('OLSON','SJ','ACOUSTIC',12,'INDIAN_ROSEWOOD','CEDAR')")
    void insertSpec();

    //查询spec信息
    @Select("select * from guitarSpec  where id=#{psecId}")
    GuitarSpec selectGuitarSpec(Integer specId);

    //插入查询条件
    @Insert("insert into guitarSpec (builder,model,type,numStrings,backWood,topWood) values (#{builder},#{model1},#{type},#{numStrings1},#{backWood},#{topWood}) ")
    void  addSpec(@Param("builder") String builder, @Param("model1") String model1,
                  @Param("type") String type,@Param("numStrings1") Integer numStrings1,
                  @Param("backWood") String backWood,@Param("topWood") String topWood);

    //查询最近记录
    @Select("select * from guitarSpec  order by id desc limit 1")
    GuitarSpec formmer();
}
