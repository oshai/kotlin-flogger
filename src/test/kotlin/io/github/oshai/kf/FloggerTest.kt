package io.github.oshai.kf

import com.google.common.flogger.FluentLogger
import com.google.common.flogger.LogSites
import org.junit.jupiter.api.Test


private val logger: FluentLogger = FluentLogger.forEnclosingClass()

class FloggerTest {

  @Test
  fun `test flogger`() {
    logger.atInfo().log("Log1 message with: %s", "argument")
    logger.atInfo().withInjectedLogSite(
      LogSites.callerOf(KotlinFlogger::class.java)).log("Log2 message with: %s", "argument")
    logger.atInfo().withCause(Exception()).log("Log3 message with: %s", "argument")
    println("DONE")
  }
}