package com.aisino.controller;



import com.aisino.base.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.PlatformPurchaseSales;
import com.aisino.service.PlatformPurchaseSalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;

/**
 * (PlatformPurchaseSales)表控制层
 *
 * @author cdy
 * @since 2023-06-13 09:37:59
 */
@Api(tags = "服务平台税务进销项发票")
@RestController
@RequestMapping("platformPurchaseSales")
public class PlatformPurchaseSalesController  {
    /**
     * 服务对象
     */
    @Resource
    private PlatformPurchaseSalesService platformPurchaseSalesService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param platformPurchaseSales 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public R selectAll(Page<PlatformPurchaseSales> page, PlatformPurchaseSales platformPurchaseSales) {
        return success(this.platformPurchaseSalesService.page(page, new QueryWrapper<>(platformPurchaseSales)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询税务进销项发票")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.platformPurchaseSalesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param platformPurchaseSales 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = " 新增税务进销项发票")
    @PostMapping
    public R insert(@RequestBody PlatformPurchaseSales platformPurchaseSales) {
//        Long snowflakeId = snowflake.snowflakeId();
//        platformPurchaseSales.setId(snowflakeId.toString());
//        platformPurchaseSales.setCfsj_1(new Date());
        return success(this.platformPurchaseSalesService.savePlatformPurchaseSalesS(platformPurchaseSales));
    }

    /**
     * 修改数据
     *
     * @param platformPurchaseSales 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改税务进销项发票")
    @PutMapping
    public R update(@RequestBody PlatformPurchaseSales platformPurchaseSales) {
        return success(this.platformPurchaseSalesService.updateById(platformPurchaseSales));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除税务进销项发票")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.platformPurchaseSalesService.removeByIds(idList));
    }
}

