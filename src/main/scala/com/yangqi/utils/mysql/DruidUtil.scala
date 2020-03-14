package com.yangqi.utils.mysql

import java.sql.{Connection, PreparedStatement, ResultSet, SQLException}
import java.util.Properties

import com.alibaba.druid.pool.{DruidDataSource, DruidDataSourceFactory}
import com.yangqi.utils.isnull.NullUtil
import com.yangqi.utils.properties.PropertiesUtil
import javax.sql.DataSource

/**
 * MySQL 连接的工具类
 *
 * @author Yankee
 * @date 2020/3/14 8:53
 */
class DruidUtil {
  private var druidDataSource: DruidDataSource = _
  // 解析配置文件
  private val prop: Properties = PropertiesUtil.getProperties("druid.properties")
  // 获取 DataSource 对象
  private var dataSource: DataSource = DruidDataSourceFactory.createDataSource(prop)

  /**
   * 通过自定义配置获取连接池对象
   */
  private def createConnection(): Unit = {
    if (NullUtil.isNull(druidDataSource)) {
      // 实例化 druidDataSource 对象
      druidDataSource = new DruidDataSource()

      // Druid 连接配置
      // 设置 mysql 连接地址
      druidDataSource.setUrl(prop.getProperty("url"))
      // 设置驱动类
      druidDataSource.setDriverClassName(prop.getProperty("driverClassName"))
      // 设置连接用户名
      druidDataSource.setUsername(prop.getProperty("username"))
      // 设置连接密码
      druidDataSource.setPassword(prop.getProperty("password"))

      // 数据库连接池相关配置
      // 设置初始化大小
      druidDataSource.setInitialSize(prop.getProperty("initialSize").toInt)
      // 设置最小空闲数量
      druidDataSource.setMinIdle(prop.getProperty("minIdle").toInt)
      // 设置最大空闲数量
      druidDataSource.setMaxActive(prop.getProperty("maxActive").toInt)
      // 设置获取连接超时等待时间
      druidDataSource.setMaxWait(prop.getProperty("maxWait").toLong)
      // 获取连接等待超时时间
      druidDataSource.setTimeBetweenEvictionRunsMillis(prop.getProperty("timeBetweenEvictionRunsMillis").toLong)
      // 连接池泄露检测
      druidDataSource.setRemoveAbandoned(true)
      druidDataSource.setRemoveAbandonedTimeout(Integer.parseInt(prop.getProperty("removeAbandonedTimeout")))
    }
  }

  /**
   * Gets connection.
   *
   * @return the connection
   */
  def getConnection: Connection = {
    try {
      // 通过连接池获取连接对象
      createConnection();
      return druidDataSource.getConnection();
    } catch {
      case e: SQLException => e.printStackTrace()
    }
    throw new RuntimeException("获取数据库连接异常");
  }

  /**
   * Gets connection by factory.
   *
   * @return the connection by factory
   */
  def getConnectionByFactory: Connection = {
    try {
      // 通过 druid 的工厂类获取
      return dataSource.getConnection();
    } catch {
      case e: SQLException => e.printStackTrace();
    }
    throw new RuntimeException("获取数据库连接异常");
  }

  /**
   * Release connection.
   *
   * @param rs   the rs
   * @param prep the prep
   * @param conn the conn
   */
  def releaseConnection(rs: ResultSet, prep: PreparedStatement, conn: Connection): Unit = {
    try {
      if (rs != null) {
        rs.close();
      }
      if (prep != null) {
        prep.close();
      }
      if (conn != null) {
        conn.close();
      }
    } catch {
      case e: SQLException => e.printStackTrace();
    }
  }
}

object DruidUtil extends DruidUtil {

}
