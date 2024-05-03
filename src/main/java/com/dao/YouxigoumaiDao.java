package com.dao;

import com.entity.YouxigoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxigoumaiVO;
import com.entity.view.YouxigoumaiView;


/**
 * 游戏购买
 * 
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
public interface YouxigoumaiDao extends BaseMapper<YouxigoumaiEntity> {
	
	List<YouxigoumaiVO> selectListVO(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
	
	YouxigoumaiVO selectVO(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
	
	List<YouxigoumaiView> selectListView(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);

	List<YouxigoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
	
	YouxigoumaiView selectView(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
	

}
