package com.yangqi.utils.isnull

/**
 * 判断是否为空
 *
 * @author Yankee
 * @date 2020/3/13 19:50
 */
class NullUtil {
  /**
   * Is null boolean.
   * <p>
   * NullUtil.isNull(null) = true
   * NullUtil.isNull("") = true
   * NullUtil.isNull("  ") = true
   * </p>
   *
   * @param any the any
   * @return the boolean
   */
  def isNull(any: Any): Boolean = {
    any == null || "".equals(any.toString.trim())
  }

  /**
   * Is not null boolean.
   *
   * @param any the any
   * @return the boolean
   */
  def isNotNull(any: Any): Boolean = {
    if (any != null || !"".equals(any.toString.trim())) {
      return true
    }
    false
  }
}

object NullUtil extends NullUtil {

}
