package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.PlatformPurchaseSalesDao;
import com.aisino.entity.PlatformPurchaseSales;
import com.aisino.service.PlatformPurchaseSalesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (PlatformPurchaseSales)表服务实现类
 *
 * @author cdy
 * @since 2023-06-13 09:38:01
 */
@Service("platformPurchaseSalesService")
public class PlatformPurchaseSalesServiceImpl extends ServiceImpl<PlatformPurchaseSalesDao, PlatformPurchaseSales> implements PlatformPurchaseSalesService {

    @Resource
    private IdGeneratorSnowflake snowflake;
    @Override
    public PlatformPurchaseSales savePlatformPurchaseSalesS(PlatformPurchaseSales entity) {
        Long snowflakeId = snowflake.snowflakeId();
        entity.setId(snowflakeId.toString());
        this.save(entity);
        return entity;
    }
}

