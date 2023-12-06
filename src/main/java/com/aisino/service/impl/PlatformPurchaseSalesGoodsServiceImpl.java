package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.PlatformPurchaseSalesGoodsDao;
import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.aisino.service.PlatformPurchaseSalesGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (PlatformPurchaseSalesGoods)表服务实现类
 *
 * @author cdy
 * @since 2023-06-13 10:08:39
 */
@Service("platformPurchaseSalesGoodsService")
public class PlatformPurchaseSalesGoodsServiceImpl extends ServiceImpl<PlatformPurchaseSalesGoodsDao, PlatformPurchaseSalesGoods> implements PlatformPurchaseSalesGoodsService {

    @Resource
    private IdGeneratorSnowflake snowflake;

    @Override
    public PlatformPurchaseSalesGoods savePlatformPurchaseSalesGoods(PlatformPurchaseSalesGoods entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setId(snowflakeId.toString());
        this.save(entity);
        return entity;
    }
}

