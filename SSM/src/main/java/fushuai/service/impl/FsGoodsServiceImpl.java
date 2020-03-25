package fushuai.service.impl;

import org.springframework.stereotype.Service;
import fushuai.repository.FsGoodsMapper;
import fushuai.entity.FsGoods;
import fushuai.service.FsGoodsService;

import java.util.List;

@Service
public class FsGoodsServiceImpl implements FsGoodsService {

    private final FsGoodsMapper fsGoodsMapper;

    public FsGoodsServiceImpl(FsGoodsMapper fsGoodsMapper) {
        this.fsGoodsMapper = fsGoodsMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return fsGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FsGoods record) {
        return fsGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(FsGoods record) {
        return fsGoodsMapper.insertSelective(record);
    }

    @Override
    public FsGoods selectByPrimaryKey(Integer id) {
        return fsGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FsGoods record) {
        return fsGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FsGoods record) {
        return fsGoodsMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<FsGoods> findByAll(FsGoods fsGoods) {
        return fsGoodsMapper.findByAll(fsGoods);
    }
}

