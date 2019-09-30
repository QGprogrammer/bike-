package com.aowin.dao;

import java.util.List;

import com.aowin.model.MsPhase;

/**
 * 用户权限的数据库操作
 * @author Peter
 *
 */
public interface MsPhaseDao {

	/**
	 * 模糊查询用户权限
	 */
	List<MsPhase> getMsPhaseList(MsPhase msPhase);
	/**
	 * 新增权限
	 */
	int addMsPhase(MsPhase msPhase);
	/**
	 * 删除权限
	 */
	int deleteMsPhase(Integer phaseid);
	/**
	 * 查询某权限信息
	 */
	MsPhase getMsPhase(Integer phaseid);
	/**
	 * 修改权限
	 */
	int updateMsPhase(MsPhase msPhase);
	/**
	 * 校验权限是否存在
	 */
	MsPhase checkMsPhase(String url);
}
