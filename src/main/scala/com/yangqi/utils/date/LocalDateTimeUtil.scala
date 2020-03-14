package com.yangqi.utils.date

import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalDate, LocalDateTime}

/**
 * 计算两个日期之间的时间差的工具类
 *
 * @author Yankee
 * @date 2020/3/13 20:18
 */
class LocalDateTimeUtil {
  /**
   * Days between early and late.
   *
   * @param early the early
   * @param late  the late
   * @return the days
   */
  def daysBetween(early: LocalDate, late: LocalDate): Long = {
    late.toEpochDay - early.toEpochDay
  }

  /**
   * Days between early and late.
   *
   * @param early             the early
   * @param late              the late
   * @param dateTimeFormatter the date time formatter
   * @return the days
   */
  def daysBetween(early: String, late: String, dateTimeFormatter: DateTimeFormatter): Long = {
    val earlyDate: LocalDate = LocalDateTimeFormatUtil.parseToLocalDate(early, dateTimeFormatter)
    val lateDate: LocalDate = LocalDateTimeFormatUtil.parseToLocalDate(late, dateTimeFormatter)
    daysBetween(earlyDate, lateDate)
  }

  /**
   * Month between early and late.
   *
   * @param early the early
   * @param late  the late
   * @return the month
   */
  def monthBetween(early: LocalDateTime, late: LocalDateTime): Long = {
    val betweenMonths: Duration = Duration.between(early, late)
    betweenMonths.toHours
  }

  /**
   * Month between early and late.
   *
   * @param early             the early
   * @param late              the late
   * @param dateTimeFormatter the date time formatter
   * @return the month
   */
  def monthBetween(early: String, late: String, dateTimeFormatter: DateTimeFormatter) {
    // 时间格式转换
    val earlyDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter)
    val lateDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter)
    monthBetween(earlyDate, lateDate)
  }

  /**
   * Minutes between early and late.
   *
   * @param eayly the eayly
   * @param late  the late
   * @return the minutes
   */
  def minutesBetween(eayly: LocalDateTime, late: LocalDateTime) {
    val betweenMinutes: Duration = Duration.between(eayly, late)
    betweenMinutes.toMinutes()
  }

  /**
   * Minutes between early and late.
   *
   * @param early             the early
   * @param late              the late
   * @param dateTimeFormatter the date time formatter
   * @return the minutes
   */
  def minutesBetween(early: String, late: String, dateTimeFormatter: DateTimeFormatter) {
    val earlyDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter)
    val lateDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter)
    minutesBetween(earlyDate, lateDate)
  }

  /**
   * Millis seconds between early and late.
   *
   * @param eayly the eayly
   * @param late  the late
   * @return the millisSeconds
   */
  def millisSecondsBetween(eayly: LocalDateTime, late: LocalDateTime): Long = {
    val betweenMinutes: Duration = Duration.between(eayly, late)
    betweenMinutes.toMillis
  }

  /**
   * Millis seconds between early and late.
   *
   * @param early             the early
   * @param late              the late
   * @param dateTimeFormatter the date time formatter
   * @return the millisSeconds
   */
  def millisSecondsBetween(early: String, late: String, dateTimeFormatter: DateTimeFormatter) {
    val earlyDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(early, dateTimeFormatter)
    val lateDate: LocalDateTime = LocalDateTimeFormatUtil.parseToLocalDateTime(late, dateTimeFormatter)
    millisSecondsBetween(earlyDate, lateDate)
  }
}

object LocalDateTimeUtil extends LocalDateTimeUtil {

}
