package com.yangqi.utils.date

import java.text.SimpleDateFormat
import java.util.Date

import com.yangqi.utils.isnull.NullUtil

/**
 * Date 类型的日期格式化
 *
 * @author Yankee
 * @date 2020/3/13 19:53
 */
class DateFormatUtil {
  // 时间格式为 yyyyMM
  private val ymFormat1: SimpleDateFormat = new SimpleDateFormat("yyyyMM")

  // 时间格式为 yyyy-MM
  private val ymFormat2: SimpleDateFormat = new SimpleDateFormat("yyyy-MM")

  // 时间格式为 yyyy年MM月
  private val ymFormat3: SimpleDateFormat = new SimpleDateFormat("yyyy年MM月")

  /**
   * Date parse to your format string.
   *
   * @param date             the date
   * @param simpleDateFormat the simple date format
   * @return the string
   */
  def parseToyyyyMM(date: Date, simpleDateFormat: SimpleDateFormat): String = {
    if (NullUtil.isNull(date)) {
      return null
    }
    simpleDateFormat.format(date)
  }

  /**
   * String parse to your format date.
   *
   * @param date             the date
   * @param simpleDateFormat the simple date format
   * @return the date
   */
  def parseToDate(date: String, simpleDateFormat: SimpleDateFormat): Date = {
    if (NullUtil.isNull(date)) {
      return null
    }
    simpleDateFormat.parse(date)
  }

  /**
   * Date parse to yyyyMM string.
   *
   * @param date the date
   * @return the string
   */
  def parseToyyyyMM1(date: Date): String = {
    if (NullUtil.isNull(date)) {
      return null
    }
    ymFormat1.format(date)
  }

  /**
   * String parse to yyyyMM date.
   *
   * @param date the date
   * @return the date
   */
  def parseToDate1(date: String): Date = {
    if (NullUtil.isNull(date)) {
      return null
    }
    ymFormat1.parse(date)
  }

  /**
   * Date parse to yyyy-MM string.
   *
   * @param date the date
   * @return the string
   */
  def parseToyyyyMM2(date: Date): String = {
    if (NullUtil.isNull(date)) {
      return null
    }
    ymFormat2.format(date)
  }

  /**
   * String parse to yyyy-MM date.
   *
   * @param date the date
   * @return the date
   */
  def parseToDate2(date: String): Date = {
    if (NullUtil.isNull(date)) {
      return null
    }
    return ymFormat2.parse(date)
  }

  /**
   * Date parse to yyyy年MM月 string.
   *
   * @param date the date
   * @return the string
   */
  def parseToyyyyMM3(date: Date): String = {
    if (NullUtil.isNull(date)) {
      return null
    }
    return ymFormat3.format(date)
  }

  /**
   * String parse to yyyy年MM月 date.
   *
   * @param date the date
   * @return the date
   */
  def parseToDate3(date: String): Date = {
    if (NullUtil.isNull(date)) {
      return null
    }
    ymFormat3.parse(date)
  }
}

object DateFormatUtil extends DateFormatUtil {

}
