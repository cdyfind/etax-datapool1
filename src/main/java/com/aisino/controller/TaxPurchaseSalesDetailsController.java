package com.aisino.controller;



import com.aisino.base.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.TaxPurchaseSalesDetails;
import com.aisino.service.TaxPurchaseSalesDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;

/**
 * (TaxPurchaseSalesDetails)表控制层
 *
 * @author cdy
 * @since 2023-06-13 10:35:37
 */
@Api(tags = "税务进销项发票详情")
@RestController
@RequestMapping("taxPurchaseSalesDetails")
public class TaxPurchaseSalesDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private TaxPurchaseSalesDetailsService taxPurchaseSalesDetailsService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param taxPurchaseSalesDetails 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = " 分页查询所有数据")
    @GetMapping
    public R selectAll(Page<TaxPurchaseSalesDetails> page, TaxPurchaseSalesDetails taxPurchaseSalesDetails) {
        return success(this.taxPurchaseSalesDetailsService.page(page, new QueryWrapper<>(taxPurchaseSalesDetails)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "  通过id查询单条数据")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.taxPurchaseSalesDetailsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param taxPurchaseSalesDetails 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "  新增数据")
    @PostMapping
    public R insert(@RequestBody TaxPurchaseSalesDetails taxPurchaseSalesDetails) {
//        Long snowflakeId = snowflake.snowflakeId();
//        taxPurchaseSalesDetails.setId(snowflakeId.toString());
        return success(this.taxPurchaseSalesDetailsService.saveTaxPurchaseSalesDetails(taxPurchaseSalesDetails));
    }

    /**
     * 修改数据
     *
     * @param taxPurchaseSalesDetails 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "  修改数据")
    @PutMapping
    public R update(@RequestBody TaxPurchaseSalesDetails taxPurchaseSalesDetails) {
        return success(this.taxPurchaseSalesDetailsService.updateById(taxPurchaseSalesDetails));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = " 删除数据")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.taxPurchaseSalesDetailsService.removeByIds(idList));
    }

}

