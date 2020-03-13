package com.yangqi.utils.redis

import java.util
import java.util.Properties

import com.yangqi.utils.properties.PropertiesUtil
import redis.clients.jedis.{HostAndPort, JedisCluster, JedisPoolConfig}

/**
 * 通过 Jedis 连接池获取 JedisCluster
 * 此工具类基于 Jedis-3.0.0
 *
 * @author Yankee
 * @date 2020/3/13 12:56
 */
class JedisPoolUtil {
  // JedisCluster
  private var jedisCluster: JedisCluster = _
  // 解析配置文件
  private val prop: Properties = PropertiesUtil.getProperties("redis.properties")

  /**
   * 创建 JedisCluster
   * JedisCluter 不需要单独构建连接池，其已经基于连接池实现
   */
  private def createJedisCluster(): Unit = {
    // JedisCluster 连接配置
    val serverArray: Array[String] = prop.getProperty("servers").split(",")
    // 连接 RedisCluster 实例超时时间
    val connectionTimeout: Int = prop.getProperty("connectionTimeout").toInt
    // 读写 RedisCluster 实例超时时间
    val soTimeout: Int = prop.getProperty("soTimeout").toInt
    // 连接 RedisCluster 实例失败重试次数
    val maxAttempts: Int = prop.getProperty("maxAttempts").toInt

    // Jedis 连接池配置
    // 建立连接池配置参数
    val config: JedisPoolConfig = new JedisPoolConfig
    // 设置最大连接数
    config.setMaxTotal(prop.getProperty("maxTotal").toInt)
    // 设置最大阻塞时间，单位是毫秒
    config.setMaxWaitMillis(prop.getProperty("maxWaitMillis").toInt)
    // 设置最大空闲连接数
    config.setMaxIdle(prop.getProperty("maxIdle").toInt)
    // 设置最小空闲连接数
    config.setMinIdle(prop.getProperty("minIdle").toInt)
    // Jedis 实例是否可用
    config.setTestOnBorrow(prop.getProperty("testOnBorrow").toBoolean)
    // 从连接池获取不到则连接阻塞
    config.setBlockWhenExhausted(prop.getProperty("blockWhenExhausted").toBoolean)
    // 连接对象后进先出
    config.setLifo(prop.getProperty("lifo").toBoolean)
    // 归还连接到连接池测试连接
    config.setTestOnReturn(prop.getProperty("testOnReturn").toBoolean)
    // 测试连接池空闲的连接
    config.setTestWhileIdle(prop.getProperty("testWhileIdle").toBoolean)
    // 测试连接池空闲连接的时间间隔，testWhileIdle = true 时生效
    config.setTimeBetweenEvictionRunsMillis(prop.getProperty("timeBetweenEvictionRunsMillis").toInt)

    // 存储 RedisCluster 集群的服务器地址
    val nodes: util.Set[HostAndPort] = new util.HashSet[HostAndPort]()
    for (ipPort <- serverArray) {
      val ipPortPair: Array[String] = ipPort.split(":")
      nodes.add(new HostAndPort(ipPortPair(0).trim, ipPortPair(1).trim.toInt))
    }

    // 注意：这里超时时间不要太短，会有超时重试机制
    jedisCluster = new JedisCluster(nodes, connectionTimeout, soTimeout, maxAttempts, config)
  }

  /**
   * 获取一个 Jedis 连接对象
   *
   * @return Jedis 连接对象
   */
  def getJedisCluster: JedisCluster = {
    if (jedisCluster == null) {
      createJedisCluster()
    }
    jedisCluster
  }
}

object JedisPoolUtil extends JedisPoolUtil {

}
