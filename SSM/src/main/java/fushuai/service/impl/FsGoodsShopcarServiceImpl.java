package fushuai.service.impl;

import fushuai.dto.Shopcardto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fushuai.entity.FsGoodsShopcar;
import fushuai.repository.FsGoodsShopcarMapper;
import fushuai.service.FsGoodsShopcarService;

import java.util.List;

@Service
public class FsGoodsShopcarServiceImpl implements FsGoodsShopcarService{

    private final FsGoodsShopcarMapper fsGoodsShopcarMapper;

    public FsGoodsShopcarServiceImpl(FsGoodsShopcarMapper fsGoodsShopcarMapper) {
        this.fsGoodsShopcarMapper = fsGoodsShopcarMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return fsGoodsShopcarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FsGoodsShopcar record) {
        return fsGoodsShopcarMapper.insert(record);
    }

    @Override
    public int insertSelective(FsGoodsShopcar record) {
        return fsGoodsShopcarMapper.insertSelective(record);
    }

    @Override
    public FsGoodsShopcar selectByPrimaryKey(Integer id) {
        return fsGoodsShopcarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FsGoodsShopcar record) {
        return fsGoodsShopcarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FsGoodsShopcar record) {
        return fsGoodsShopcarMapper.updateByPrimaryKey(record);
    }
    @Override
    public List<Shopcardto> findByMemberId(Integer id) {
        return fsGoodsShopcarMapper.findByMemberId(id);
    }
    @Override
    public List<Shopcardto> findAll() {
        return fsGoodsShopcarMapper.findAll();
    }
}
