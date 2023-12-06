package com.aisino.controller;



import com.aisino.base.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.aisino.service.PlatformPurchaseSalesGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;

/**
 * (PlatformPurchaseSalesGoods)表控制层
 *
 * @author cdy
 * @since 2023-06-13 10:08:37
 */
@Api(tags = "服务平台税务进销项发票详情")
@RestController
@RequestMapping("platformPurchaseSalesGoods")
public class PlatformPurchaseSalesGoodsController{
    /**
     * 服务对象
     */
    @Resource
    private PlatformPurchaseSalesGoodsService platformPurchaseSalesGoodsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param platformPurchaseSalesGoods 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = " 分页查询服务平台税务进销项发票详情")
    @GetMapping
    public R selectAll(Page<PlatformPurchaseSalesGoods> page, PlatformPurchaseSalesGoods platformPurchaseSalesGoods) {
        return success(this.platformPurchaseSalesGoodsService.page(page, new QueryWrapper<>(platformPurchaseSalesGoods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = " 查询服务服务平台税务进销项发票详情")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.platformPurchaseSalesGoodsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param platformPurchaseSalesGoods 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增服务平台税务进销项发票详情")
    @PostMapping
    public R insert(@RequestBody PlatformPurchaseSalesGoods platformPurchaseSalesGoods) {
        return success(this.platformPurchaseSalesGoodsService.savePlatformPurchaseSalesGoods(platformPurchaseSalesGoods));
    }

    /**
     * 修改数据
     *
     * @param platformPurchaseSalesGoods 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改服务平台税务进销项发票详情")
    @PutMapping
    public R update(@RequestBody PlatformPurchaseSalesGoods platformPurchaseSalesGoods) {
        return success(this.platformPurchaseSalesGoodsService.updateById(platformPurchaseSalesGoods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除服务平台税务进销项发票详情")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.platformPurchaseSalesGoodsService.removeByIds(idList));
    }
}

