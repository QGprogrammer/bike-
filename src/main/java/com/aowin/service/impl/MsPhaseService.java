package com.aowin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aowin.dao.MsPhaseDao;
import com.aowin.model.MsPhase;
import com.aowin.service.IMsPhaseService;

/**
 * 权限service的实现类
 * @author Peter
 *
 */
@Service
public class MsPhaseService implements IMsPhaseService {
	@Resource
	private MsPhaseDao msPhaseDao;
	/**
	 * 模糊查询得权限List
	 */
	public List<MsPhase> getMsPhaseList(MsPhase msPhase) {
		return msPhaseDao.getMsPhaseList(msPhase);
	}
	/**
	 * 新增权限
	 */
	public int addMsPhase(MsPhase msPhase) {
		return msPhaseDao.addMsPhase(msPhase);
	}
	/**
	 * 校验权限是否存在
	 */
	public MsPhase checkMsPhase(String url) {
		return msPhaseDao.checkMsPhase(url);
	}
	/**
	 * 删除权限
	 */
	public int deleteMsPhase(Integer phaseid) {
		return msPhaseDao.deleteMsPhase(phaseid);
	}
	/**
	 * 查询某权限的信息
	 */
	public MsPhase getMsPhase(Integer phaseid) {
		return msPhaseDao.getMsPhase(phaseid);
	}
	/**
	 * 修改权限
	 */
	public int updateMsPhase(MsPhase msPhase) {
		return msPhaseDao.updateMsPhase(msPhase);
	}

}
