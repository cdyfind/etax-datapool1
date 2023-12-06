package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.TaxPurchaseSalesDao;
import com.aisino.entity.TaxPurchaseSales;
import com.aisino.service.TaxPurchaseSalesService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * (TaxPurchaseSales)表服务实现类
 *
 * @author cdy
 * @since 2023-06-13 10:26:16
 */
@Service("taxPurchaseSalesService")
public class TaxPurchaseSalesServiceImpl extends ServiceImpl<TaxPurchaseSalesDao, TaxPurchaseSales> implements TaxPurchaseSalesService {

    @Resource
    private IdGeneratorSnowflake snowflake;
    @Override
    public TaxPurchaseSales saveTax(TaxPurchaseSales entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setId(snowflakeId.toString());
        this.save(entity);
        return entity;
    }
}

