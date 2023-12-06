package com.aisino.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.PlatformPurchaseSales;

/**
 * (PlatformPurchaseSales)表服务接口
 *
 * @author cdy
 * @since 2023-06-13 09:38:00
 */
public interface PlatformPurchaseSalesService extends IService<PlatformPurchaseSales> {

    /**
    * 保存服务平台税务进销项发票
    *
    * @param entity 实体对象
    * @return PlatforeSales
    */
    public PlatformPurchaseSales savePlatformPurchaseSalesS(PlatformPurchaseSales entity);
}

