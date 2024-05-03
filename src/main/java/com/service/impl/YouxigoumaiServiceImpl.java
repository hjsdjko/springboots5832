package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YouxigoumaiDao;
import com.entity.YouxigoumaiEntity;
import com.service.YouxigoumaiService;
import com.entity.vo.YouxigoumaiVO;
import com.entity.view.YouxigoumaiView;

@Service("youxigoumaiService")
public class YouxigoumaiServiceImpl extends ServiceImpl<YouxigoumaiDao, YouxigoumaiEntity> implements YouxigoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxigoumaiEntity> page = this.selectPage(
                new Query<YouxigoumaiEntity>(params).getPage(),
                new EntityWrapper<YouxigoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxigoumaiEntity> wrapper) {
		  Page<YouxigoumaiView> page =new Query<YouxigoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouxigoumaiVO> selectListVO(Wrapper<YouxigoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxigoumaiVO selectVO(Wrapper<YouxigoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxigoumaiView> selectListView(Wrapper<YouxigoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxigoumaiView selectView(Wrapper<YouxigoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
