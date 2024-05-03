package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YouxigoumaiEntity;
import com.entity.view.YouxigoumaiView;

import com.service.YouxigoumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 游戏购买
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@RestController
@RequestMapping("/youxigoumai")
public class YouxigoumaiController {
    @Autowired
    private YouxigoumaiService youxigoumaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxigoumaiEntity youxigoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			youxigoumai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YouxigoumaiEntity> ew = new EntityWrapper<YouxigoumaiEntity>();

		PageUtils page = youxigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxigoumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxigoumaiEntity youxigoumai, 
		HttpServletRequest request){
        EntityWrapper<YouxigoumaiEntity> ew = new EntityWrapper<YouxigoumaiEntity>();

		PageUtils page = youxigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxigoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxigoumaiEntity youxigoumai){
       	EntityWrapper<YouxigoumaiEntity> ew = new EntityWrapper<YouxigoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxigoumai, "youxigoumai")); 
        return R.ok().put("data", youxigoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxigoumaiEntity youxigoumai){
        EntityWrapper< YouxigoumaiEntity> ew = new EntityWrapper< YouxigoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxigoumai, "youxigoumai")); 
		YouxigoumaiView youxigoumaiView =  youxigoumaiService.selectView(ew);
		return R.ok("查询游戏购买成功").put("data", youxigoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxigoumaiEntity youxigoumai = youxigoumaiService.selectById(id);
        return R.ok().put("data", youxigoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxigoumaiEntity youxigoumai = youxigoumaiService.selectById(id);
        return R.ok().put("data", youxigoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxigoumaiEntity youxigoumai, HttpServletRequest request){
    	youxigoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxigoumai);
        youxigoumaiService.insert(youxigoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxigoumaiEntity youxigoumai, HttpServletRequest request){
    	youxigoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxigoumai);
        youxigoumaiService.insert(youxigoumai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxigoumaiEntity youxigoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxigoumai);
        youxigoumaiService.updateById(youxigoumai);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxigoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
