package xyz.drafter.gmall0424.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.drafter.gmall0424.bean.*;
import xyz.drafter.gmall0424.mapper.*;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/26
 * @desciption
 */
@Service
public class MangeServiceImpl implements ManageService {

    @Autowired
    private BaseCatelog1Mapper baseCatelog1Mapper;

    @Autowired
    private BaseCatelog2Mapper baseCatelog2Mapper;


    @Autowired
    private BaseCatelog3Mapper baseCatelog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;


    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Autowired
    private SpuInfoMapper spuInfoMapper;

    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    private SpuImageMapper spuImageMapper;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;


    @Override
    public List<BaseCatalog1> getBaseCatalog1() {
        return baseCatelog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);

        return baseCatelog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getBaseCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);

        return baseCatelog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);

        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    @Transactional
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {

        // 修改操作
        if (baseAttrInfo.getId() != null){
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);


        }else {
            // 保存数据
            baseAttrInfoMapper.insertSelective(baseAttrInfo);

        }

        BaseAttrValue delBaseAttrValue = new BaseAttrValue();
        delBaseAttrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(delBaseAttrValue);




        List<BaseAttrValue> attrValues = baseAttrInfo.getAttrValueList();

        if (!CollectionUtils.isEmpty(attrValues)){
            for (BaseAttrValue baseAttrValue : attrValues){
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(baseAttrValue);
            }

        }
    }


    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {

        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);

        List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.select(baseAttrValue);
        return baseAttrValues;
    }

    @Override
    public BaseAttrInfo getAttrInfo(String attrId) {

        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);

        List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValueList(baseAttrValues);

        return baseAttrInfo;
    }

    @Override
    public List<SpuInfo> getSpuList(SpuInfo spuInfo) {

        List<SpuInfo> spuInfoList = spuInfoMapper.select(spuInfo);


        return spuInfoList;
    }

    @Override
    public List<BaseSaleAttr> baseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {

        spuInfoMapper.insertSelective(spuInfo);

        List<SpuImange> spuImangeList = spuInfo.getSpuImangeList();
        if (CollectionUtils.isEmpty(spuImangeList)){
            for (SpuImange spuImange : spuImangeList){
                spuImange.setSpuId(spuInfo.getId());
                spuImageMapper.insertSelective(spuImange);
            }
        }

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (CollectionUtils.isEmpty(spuSaleAttrList)){
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList){
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insertSelective(spuSaleAttr);


                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if (CollectionUtils.isEmpty(spuSaleAttrValueList)){
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList){
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValueMapper.insertSelective(spuSaleAttrValue);

                    }
                }
            }
        }

    }
}
