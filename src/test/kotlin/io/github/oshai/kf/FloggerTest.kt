package io.github.oshai.kf

import com.google.common.flogger.FluentLogger
import org.junit.jupiter.api.Test


class FloggerTest {

  private val logger: FluentLogger = FluentLogger.forEnclosingClass()
  @Test
  fun `test flogger`() {
    logger.atInfo().withCause(Exception()).log("Log message with: %s", "argument")
    println("DONE")
  }
}