package com.yangqi.utils.redis

import java.util
import java.util.Properties

import com.yangqi.utils.properties.PropertiesUtil
import redis.clients.jedis.{HostAndPort, Jedis, JedisCluster, JedisPoolConfig}

/**
 * 通过 Jedis 连接池获取 Jedis 对象
 * 此工具类基于 Jedis-3.0.0
 *
 * @author Yankee
 * @date 2020/3/13 14:17
 */
class JedisUtil {
  // Jedis 对象
  private var jedis: Jedis = _
  // 解析配置文件
  private val prop: Properties = PropertiesUtil.getProperties("redis.properties")

  /**
   * 创建 Jedis
   */
  private def createJedis(): Unit = {
    // Jedis 连接配置
    val server: String = prop.getProperty("server")
    // 连接 Redis 实例超时时间
    val connectionTimeout: Int = prop.getProperty("connectionTimeout").toInt
    // 读写 Redis 实例超时时间
    val soTimeout: Int = prop.getProperty("soTimeout").toInt

    // 注意：这里超时时间不要太短，会有超时重试机制
    jedis = new Jedis(server, connectionTimeout, soTimeout)
  }

  /**
   * 获取一个 Jedis 连接对象
   *
   * @return Jedis 连接
   */
  def getJedis: Jedis = {
    if (jedis == null) {
      createJedis()
    }
    jedis
  }
}

object JedisUtil extends JedisUtil {

}
