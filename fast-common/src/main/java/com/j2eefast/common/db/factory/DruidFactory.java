package com.j2eefast.common.db.factory;

import com.j2eefast.common.core.config.properties.DruidProperties;
import com.j2eefast.common.db.entity.SysDatabaseEntity;

/**
 * <p>数据库配置文件工厂</p>
 *
 * @author: yhli
 * @date: 2020-04-15 13:47
 * @web: http://www.j2eefast.com
 * @version: 1.0.1
 */
public class DruidFactory {
	/**
	 * 创建druid配置
	 *
	 * @author yhli
	 * @Date 2019-06-15 20:05
	 */
	public static DruidProperties createDruidProperties(SysDatabaseEntity databaseInfo) {

		DruidProperties druidProperties = new DruidProperties();
		druidProperties.setDriverClassName(databaseInfo.getJdbcDriver());
		druidProperties.setUsername(databaseInfo.getUserName());
		druidProperties.setPassword(databaseInfo.getPassword());
		druidProperties.setUrl(databaseInfo.getJdbcUrl());
		return druidProperties;

	}
}
