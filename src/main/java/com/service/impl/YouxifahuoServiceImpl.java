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


import com.dao.YouxifahuoDao;
import com.entity.YouxifahuoEntity;
import com.service.YouxifahuoService;
import com.entity.vo.YouxifahuoVO;
import com.entity.view.YouxifahuoView;

@Service("youxifahuoService")
public class YouxifahuoServiceImpl extends ServiceImpl<YouxifahuoDao, YouxifahuoEntity> implements YouxifahuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxifahuoEntity> page = this.selectPage(
                new Query<YouxifahuoEntity>(params).getPage(),
                new EntityWrapper<YouxifahuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxifahuoEntity> wrapper) {
		  Page<YouxifahuoView> page =new Query<YouxifahuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouxifahuoVO> selectListVO(Wrapper<YouxifahuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxifahuoVO selectVO(Wrapper<YouxifahuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxifahuoView> selectListView(Wrapper<YouxifahuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxifahuoView selectView(Wrapper<YouxifahuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
