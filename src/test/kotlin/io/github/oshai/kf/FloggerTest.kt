package io.github.oshai.kf

import com.google.common.flogger.FluentLogger
import org.junit.jupiter.api.Test


private val logger: FluentLogger = FluentLogger.forEnclosingClass()

fun myKMain() {
  logger.atInfo { log("log myKMain message") }
}


class FloggerTest {

  @Test
  fun `test kotlin flogger - one log file function`() {
    myKMain()
  }

  @Test
  fun `test kotlin flogger - one log class function`() {
    logger.atInfo { log("log class function message") }
  }

  @Test
  fun `test kotlin flogger - properties`() {
    logger.atInfo {
      cause = Exception()
      every = 5
      log("log class function message")
    }
  }


}