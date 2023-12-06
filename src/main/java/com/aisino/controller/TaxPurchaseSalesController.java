package com.aisino.controller;

import com.aisino.base.R;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.TaxPurchaseSales;
import com.aisino.service.TaxPurchaseSalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;

/**
 * (TaxPurchaseSales)表控制层
 *
 * @author cdy
 * @since 2023-06-13 10:26:14
 */
@Api(tags = "税务进销项发票")
@RestController
@RequestMapping("taxPurchaseSales")
public class TaxPurchaseSalesController {
    /**
     * 服务对象
     */
    @Resource
    private TaxPurchaseSalesService taxPurchaseSalesService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param taxPurchaseSales 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页税务进销项发票")
    @GetMapping
    public R selectAll(Page<TaxPurchaseSales> page, TaxPurchaseSales taxPurchaseSales) {
        return success(this.taxPurchaseSalesService.page(page, new QueryWrapper<>(taxPurchaseSales)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = " 通过id查询数据")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.taxPurchaseSalesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param taxPurchaseSales 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = " 新增数据")
    @PostMapping
    public R insert(@RequestBody TaxPurchaseSales taxPurchaseSales) {
//        Long snowflakeId = snowflake.snowflakeId();
//        taxPurchaseSales.setId(snowflakeId.toString());
        return success(this.taxPurchaseSalesService.saveTax(taxPurchaseSales));
    }

    /**
     * 修改数据
     *
     * @param taxPurchaseSales 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "  修改数据")
    @PutMapping
    public R update(@RequestBody TaxPurchaseSales taxPurchaseSales) {
        return success(this.taxPurchaseSalesService.updateById(taxPurchaseSales));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "  删除数据")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.taxPurchaseSalesService.removeByIds(idList));
    }
}

