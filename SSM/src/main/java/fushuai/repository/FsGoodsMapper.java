package fushuai.repository;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import fushuai.entity.FsGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FsGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FsGoods record);

    int insertSelective(FsGoods record);

    FsGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsGoods record);

    int updateByPrimaryKey(FsGoods record);

    List<FsGoods> findByAll(FsGoods fsGoods);


}