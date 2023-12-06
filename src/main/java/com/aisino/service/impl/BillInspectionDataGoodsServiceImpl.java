package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.BillInspectionDataGoodsDao;
import com.aisino.entity.BillInspectionDataGoods;
import com.aisino.service.BillInspectionDataGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (BillInspectionDataGoods)表服务实现类
 *
 * @author cdy
 * @since 2023-06-12 15:01:47
 */
@Service("billInspectionDataGoodsService")
public class BillInspectionDataGoodsServiceImpl extends ServiceImpl<BillInspectionDataGoodsDao, BillInspectionDataGoods> implements BillInspectionDataGoodsService {

    @Resource
    private IdGeneratorSnowflake snowflake;


    /**
    * 新增发票校验物品数据
    *
    * @param billInspectionDataGoods
    * @return BillInspectionDataGoods
    *
     */
    @Override
    public BillInspectionDataGoods saveBillInspectionDataGoods(BillInspectionDataGoods billInspectionDataGoods) {
        Long snowflakeId = snowflake.snowflakeId();
        billInspectionDataGoods.setId(snowflakeId.toString());
        this.save(billInspectionDataGoods);
        return billInspectionDataGoods;
    }
}

