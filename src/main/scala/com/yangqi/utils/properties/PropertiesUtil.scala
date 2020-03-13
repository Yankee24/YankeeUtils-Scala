package com.yangqi.utils.properties

import java.io.InputStream
import java.util.Properties

/**
 * 解析配置文件工具类
 *
 * @author Yankee
 * @date 2020/3/13 12:29
 */
class PropertiesUtil {
  private var prop: Properties = new Properties()

  /**
   * 通过配置文件名获取配置文件中 key 对应的 value 值
   *
   * @param key       key
   * @param propName 配置文件名
   * @return value
   */
  def getStringByKey(key: String, propName: String): String = {
    // 获取 Properties 对象
    prop = getProperties(propName)
    // 获取对应 key 的 value 值
    val value: String = prop.getProperty(key)
    if (value != null) {
      value
    } else {
      null
    }
  }

  /**
   * 加载配置文件
   *
   * @param propName 配置文件名称
   * @return Properties 对象
   */
  def getProperties(propName: String): Properties = {
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream(propName)
    // 加载配置文件
    prop.load(inputStream)
    // 返回 Properties 对象
    prop
  }
}

object PropertiesUtil extends PropertiesUtil {

}
