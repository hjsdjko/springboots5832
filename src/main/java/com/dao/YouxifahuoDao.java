package com.dao;

import com.entity.YouxifahuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxifahuoVO;
import com.entity.view.YouxifahuoView;


/**
 * 游戏发货
 * 
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
public interface YouxifahuoDao extends BaseMapper<YouxifahuoEntity> {
	
	List<YouxifahuoVO> selectListVO(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
	
	YouxifahuoVO selectVO(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
	
	List<YouxifahuoView> selectListView(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);

	List<YouxifahuoView> selectListView(Pagination page,@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
	
	YouxifahuoView selectView(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
	

}
