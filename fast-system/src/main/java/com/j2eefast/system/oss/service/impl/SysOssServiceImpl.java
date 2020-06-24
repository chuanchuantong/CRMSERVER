package com.j2eefast.system.oss.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.j2eefast.common.core.page.Query;
import com.j2eefast.common.core.utils.PageUtil;
import com.j2eefast.system.oss.dao.SysOssDao;
import com.j2eefast.system.oss.entity.SysOssEntity;
import com.j2eefast.system.oss.service.SysOssService;

@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtil queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.baseMapper.selectPage(new Query<SysOssEntity>(params).getPage(),null);
		return new PageUtil(page);
	}

	@Override
	public List<SysOssEntity> queryParams(Wrapper<SysOssEntity> params) {
		List<SysOssEntity> page = this.baseMapper.selectList(params);
		return page;
	}

}
