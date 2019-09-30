package com.aowin.service;

import java.util.List;

import com.aowin.model.MsPhase;

/**
 * 用户权限的service
 * @author Peter
 *
 */
public interface IMsPhaseService {

	/**
	 * 模糊查询得权限List
	 */
	List<MsPhase> getMsPhaseList(MsPhase msPhase);
	/**
	 * 新增权限
	 */
	int addMsPhase(MsPhase msPhase);
	/**
	 * 校验权限是否存在
	 */
	MsPhase checkMsPhase(String url);
	/**
	 * 删除权限
	 */
	int deleteMsPhase(Integer phaseid);
	/**
	 * 查询某权限的信息
	 */
	MsPhase getMsPhase(Integer phaseid);
	/**
	 * 修改权限
	 */
	int updateMsPhase(MsPhase msPhase);
}
