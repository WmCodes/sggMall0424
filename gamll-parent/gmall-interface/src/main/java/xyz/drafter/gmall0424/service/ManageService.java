package xyz.drafter.gmall0424.service;

import xyz.drafter.gmall0424.bean.*;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/26
 * @desciption
 */
public interface ManageService {

    List<BaseCatalog1> getBaseCatalog1();

    List<BaseCatalog2> getBaseCatalog2(String catalog1Id);

    List<BaseCatalog3> getBaseCatalog3(String catalog2Id);

    List<BaseAttrInfo> getAttrList(String catalog3Id);


    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseAttrValue> getAttrValueList(String attrId);

    BaseAttrInfo getAttrInfo(String attrId);

    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpuInfo(SpuInfo spuInfo);
}
