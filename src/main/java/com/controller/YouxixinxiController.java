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

import com.entity.YouxixinxiEntity;
import com.entity.view.YouxixinxiView;

import com.service.YouxixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 游戏信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@RestController
@RequestMapping("/youxixinxi")
public class YouxixinxiController {
    @Autowired
    private YouxixinxiService youxixinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi,
		HttpServletRequest request){
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();

		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, 
		HttpServletRequest request){
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();

		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxixinxiEntity youxixinxi){
       	EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxixinxi, "youxixinxi")); 
        return R.ok().put("data", youxixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxixinxiEntity youxixinxi){
        EntityWrapper< YouxixinxiEntity> ew = new EntityWrapper< YouxixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxixinxi, "youxixinxi")); 
		YouxixinxiView youxixinxiView =  youxixinxiService.selectView(ew);
		return R.ok("查询游戏信息成功").put("data", youxixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
		youxixinxi.setClicknum(youxixinxi.getClicknum()+1);
		youxixinxi.setClicktime(new Date());
		youxixinxiService.updateById(youxixinxi);
        return R.ok().put("data", youxixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
		youxixinxi.setClicknum(youxixinxi.getClicknum()+1);
		youxixinxi.setClicktime(new Date());
		youxixinxiService.updateById(youxixinxi);
        return R.ok().put("data", youxixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
    	youxixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.insert(youxixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
    	youxixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.insert(youxixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.updateById(youxixinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, HttpServletRequest request,String pre){
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "youxileixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "youxixinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YouxixinxiEntity> youxixinxiList = new ArrayList<YouxixinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                youxixinxiList.addAll(youxixinxiService.selectList(new EntityWrapper<YouxixinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        List<YouxixinxiEntity> pageList = (List<YouxixinxiEntity>)page.getList();
        if(youxixinxiList.size()<limit) {
            int toAddNum = (limit-youxixinxiList.size())<=pageList.size()?(limit-youxixinxiList.size()):pageList.size();
            for(YouxixinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(YouxixinxiEntity o2 : youxixinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    youxixinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(youxixinxiList.size()>limit) {
            youxixinxiList = youxixinxiList.subList(0, limit);
        }
        page.setList(youxixinxiList);
        return R.ok().put("data", page);
    }







}
