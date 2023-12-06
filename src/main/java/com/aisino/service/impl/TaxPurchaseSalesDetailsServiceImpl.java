package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.TaxPurchaseSalesDetailsDao;
import com.aisino.entity.TaxPurchaseSalesDetails;
import com.aisino.service.TaxPurchaseSalesDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TaxPurchaseSalesDetails)表服务实现类
 *
 * @author cdy
 * @since 2023-06-13 10:35:38
 */
@Service("taxPurchaseSalesDetailsService")
public class TaxPurchaseSalesDetailsServiceImpl extends ServiceImpl<TaxPurchaseSalesDetailsDao, TaxPurchaseSalesDetails> implements TaxPurchaseSalesDetailsService {

    @Resource
    private IdGeneratorSnowflake snowflake;

    @Override
    public TaxPurchaseSalesDetails saveTaxPurchaseSalesDetails(TaxPurchaseSalesDetails entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setId(snowflakeId.toString());
        this.save(entity);
        return entity;
    }
}

