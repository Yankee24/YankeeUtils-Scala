package com.yangqi.utils.date

import java.time.{LocalDate, LocalDateTime, LocalTime}
import java.time.format.DateTimeFormatter

import com.yangqi.utils.isnull.NullUtil

/**
 * LocalDateTime 格式的日期格式化工具类
 *
 * @author Yankee
 * @date 2020/3/13 20:02
 */
class LocalDateTimeFormatUtil {
  // 时间格式为 yyyyMMddHHmmss
  private var ymdhmsFormat1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

  // 时间格式为 yyyyMMdd HH:mm:ss
  private var ymdhmsFormat2 = DateTimeFormatter.ofPattern("yyyyyMMdd HH:mm:ss")

  // 时间格式为 yyyy-MM-dd HH:mm:ss
  private var ymdhmsFormat3 = DateTimeFormatter.ofPattern("yyyyy-MM-dd HH:mm:ss")

  // 时间格式为 yyyy年MM月dd日 HH时mm分ss秒
  private var ymdhmsFormat4 = DateTimeFormatter.ofPattern("yyyyy年MM月dd日 HH时mm分ss秒")

  // 时间格式为 yyyyMMdd
  private var ymdFormat1 = DateTimeFormatter.ofPattern("yyyyMMdd")

  // 时间格式为 yyyy-MM-dd
  private var ymdFormat2 = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  // 时间格式为 yyyy年MM月dd日
  private var ymdFormat3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日")

  // 时间格式为 HHmmss
  private var hmsFormat1 = DateTimeFormatter.ofPattern("HHmmss")

  // 时间格式为 HH:mm:ss
  private var hmsFormat2 = DateTimeFormatter.ofPattern("HH:mm:ss")

  // 时间格式为 HH时mm分ss秒
  private var hmsFormat3 = DateTimeFormatter.ofPattern("HH时mm分ss秒")

  /**
   * LocalDateTime parse to your format string.
   *
   * @param localDateTime     the local date time
   * @param dateTimeFormatter the date time formatter
   * @return the string
   */
  def parseToyyyyMMddHHmmss(localDateTime: LocalDateTime, dateTimeFormatter: DateTimeFormatter): String = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    localDateTime.format(dateTimeFormatter)
  }

  /**
   * String parse to your format local date time.
   *
   * @param localDateTime     the local date time
   * @param dateTimeFormatter the date time formatter
   * @return the local date time
   */
  def parseToLocalDateTime(localDateTime: String, dateTimeFormatter: DateTimeFormatter): LocalDateTime = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    LocalDateTime.parse(localDateTime, dateTimeFormatter)
  }

  /**
   * LocalDateTime parse to yyyyMMddHHmmss string.
   *
   * @param localDateTime the local date time
   * @return the string
   */
  def parseToyyyyMMddHHmmss1(localDateTime: LocalDateTime): String = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    localDateTime.format(ymdhmsFormat1)
  }

  /**
   * String parse to yyyyMMddHHmmss local date time.
   *
   * @param localDateTime the string
   * @return the local date time
   */
  def parseToLocalDateTime1(localDateTime: String): LocalDateTime = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    LocalDateTime.parse(localDateTime, ymdhmsFormat1)
  }

  /**
   * LocalDateTime parse to yyyyMMdd HH:mm:ss string.
   *
   * @param localDateTime the local date time
   * @return the string
   */
  def parseToyyyyMMddHHmmss2(localDateTime: LocalDateTime): String = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    localDateTime.format(ymdhmsFormat2)
  }

  /**
   * String parse to yyyyMMdd HH:mm:ss local date time.
   *
   * @param localDateTime the string
   * @return the local date time
   */
  def parseToLocalDateTime2(localDateTime: String): LocalDateTime = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    LocalDateTime.parse(localDateTime, ymdhmsFormat2)
  }

  /**
   * LocalDateTime parse to yyyyy-MM-dd HH:mm:ss string.
   *
   * @param localDateTime the local date time
   * @return the string
   */
  def parseToyyyyMMddHHmmss3(localDateTime: LocalDateTime): String = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    localDateTime.format(ymdhmsFormat3)
  }

  /**
   * String parse to yyyyy-MM-dd HH:mm:ss local date time.
   *
   * @param localDateTime the string
   * @return the local date time
   */
  def parseToLocalDateTime3(localDateTime: String): LocalDateTime = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    LocalDateTime.parse(localDateTime, ymdhmsFormat3)
  }

  /**
   * LocalDateTime parse to yyyyy年MM月dd日 HH时mm分ss秒 string.
   *
   * @param localDateTime the local date time
   * @return the string
   */
  def parseToyyyyMMddHHmmss4(localDateTime: LocalDateTime): String = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    localDateTime.format(ymdhmsFormat4)
  }

  /**
   * String parse to yyyyy年MM月dd日 HH时mm分ss秒 local date time.
   *
   * @param localDateTime the string
   * @return the local date time
   */
  def parseToLocalDateTime4(localDateTime: String): LocalDateTime = {
    if (NullUtil.isNull(localDateTime)) {
      return null
    }
    LocalDateTime.parse(localDateTime, ymdhmsFormat4)
  }

  /**
   * LocalDate parse to your format string.
   *
   * @param localDate         the local date
   * @param dateTimeFormatter the date time formatter
   * @return the string
   */
  def parseToyyyyMMdd(localDate: LocalDate, dateTimeFormatter: DateTimeFormatter): String = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    localDate.format(dateTimeFormatter)
  }

  /**
   * String parse to your format local date.
   *
   * @param localDate         the local date time
   * @param dateTimeFormatter the date time formatter
   * @return the local date time
   */
  def parseToLocalDate(localDate: String, dateTimeFormatter: DateTimeFormatter): LocalDate = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    LocalDate.parse(localDate, dateTimeFormatter)
  }

  /**
   * LocalDate parse to yyyyMMdd string.
   *
   * @param localDate the local date
   * @return the string
   */
  def parseToyyyyMMdd1(localDate: LocalDate): String = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    localDate.format(ymdFormat1)
  }

  /**
   * String parse to yyyyMMdd local date.
   *
   * @param localDate the string
   * @return the local date
   */
  def parseToLocalDate1(localDate: String): LocalDate = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    LocalDate.parse(localDate, ymdFormat1)
  }

  /**
   * LocalDate parse to yyyy-MM-dd string.
   *
   * @param localDate the local date
   * @return the string
   */
  def parseToyyyyMMdd2(localDate: LocalDate): String = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    localDate.format(ymdFormat2)
  }

  /**
   * String parse to yyyy-MM-dd local date.
   *
   * @param localDate the string
   * @return the local date
   */
  def parseToLocalDate2(localDate: String): LocalDate = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    return LocalDate.parse(localDate, ymdFormat2)
  }

  /**
   * LocalDate parse to yyyy年MM月dd日 string.
   *
   * @param localDate the local date
   * @return the string
   */
  def parseToyyyyMMdd3(localDate: LocalDateTime): String = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    localDate.format(ymdFormat3)
  }

  /**
   * String parse to yyyy年MM月dd日 local date.
   *
   * @param localDate the string
   * @return the local date
   */
  def parseToLocalDate3(localDate: String): LocalDate = {
    if (NullUtil.isNull(localDate)) {
      return null
    }
    LocalDate.parse(localDate, ymdFormat3)
  }

  /**
   * LocalTime parse to your format string.
   *
   * @param localTime         the local time
   * @param dateTimeFormatter the date time formatter
   * @return the string
   */
  def parseToHHmmss(localTime: LocalDateTime, dateTimeFormatter: DateTimeFormatter): String = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    localTime.format(dateTimeFormatter)
  }

  /**
   * String parse to your format local time.
   *
   * @param localTime         the local date time
   * @param dateTimeFormatter the date time formatter
   * @return the local date time
   */
  def parseToLocalTime(localTime: String, dateTimeFormatter: DateTimeFormatter): LocalTime = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    LocalTime.parse(localTime, dateTimeFormatter)
  }

  /**
   * LocalDate parse to HHmmss string.
   *
   * @param localTime the local time
   * @return the string
   */
  def parseToHHmmss1(localTime: LocalTime): String = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    localTime.format(hmsFormat1)
  }

  /**
   * String parse to yyyyMMddHHmmss local time.
   *
   * @param localTime the string
   * @return the localtime
   */
  def parseToLocalTime1(localTime: String): LocalTime = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    LocalTime.parse(localTime, hmsFormat1)
  }

  /**
   * LocalTime parse to HH:mm:ss string.
   *
   * @param localTime the local time
   * @return the string
   */
  def parseToHHmmss2(localTime: LocalTime): String = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    localTime.format(hmsFormat2)
  }

  /**
   * String parse to HH:mm:ss local time.
   *
   * @param localTime the string
   * @return the local time
   */
  def parseToLocalTime2(localTime: String): LocalTime = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    LocalTime.parse(localTime, hmsFormat2)
  }

  /**
   * LocalTime parse to HH时mm分ss秒 string.
   *
   * @param localTime the local time
   * @return the string
   */
  def parseToHHmmss3(localTime: LocalTime): String = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    localTime.format(hmsFormat3)
  }

  /**
   * String parse to HH时mm分ss秒 local time.
   *
   * @param localTime the string
   * @return the local time
   */
  def parseToLocalTime3(localTime: String): LocalTime = {
    if (NullUtil.isNull(localTime)) {
      return null
    }
    LocalTime.parse(localTime, hmsFormat3)
  }
}

object LocalDateTimeFormatUtil extends LocalDateTimeFormatUtil {

}
