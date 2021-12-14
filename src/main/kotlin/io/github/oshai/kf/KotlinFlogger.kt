package io.github.oshai.kf

import com.google.common.flogger.AbstractLogger
import com.google.common.flogger.LogContext
import com.google.common.flogger.LogSite
import com.google.common.flogger.LoggingApi
import com.google.common.flogger.backend.Platform


// class KotlinFlogger {}

fun <API : LoggingApi<API>> AbstractLogger<API>.atInfo(f: LoggingApi<API>.() -> Unit) {
  this.atInfo()
    .withInjectedLogSite(LazyKotlinLogSite())
    .apply(f)
}

var <API : LoggingApi<API>> LoggingApi<API>.cause: Throwable
  get() = TODO()
  set(value) {
    withCause(value)
  }

var <API : LoggingApi<API>> LoggingApi<API>.every: Int
  get() = TODO()
  set(value) {
    every(value)
  }


private class LazyKotlinLogSite : LogSite() {

  private val internalLogSite: LogSite by lazy {
    Platform.getCallerFinder().findLogSite(
      LogContext::class.java, 1)
  }

  private val classNameKt: String by lazy {
    // io.github.oshai.kf.FloggerTestKt$myKMain$1
    // another option is to use internalLogSite.fileName
    val classNameLogSite = internalLogSite.className.substringBefore('$')
    if (classNameLogSite.endsWith("Kt")) {
      classNameLogSite.substring(0, classNameLogSite.length - 2)
    } else {
      classNameLogSite
    }
  }

  private val methodNameKt: String by lazy {
    // io.github.oshai.kf.FloggerTestKt$myKMain$1
    internalLogSite.className.substringBeforeLast('$').substringAfterLast('$')
  }

  override fun getClassName(): String {
    return classNameKt
  }

  override fun getMethodName(): String {
    return methodNameKt
  }

  override fun getLineNumber(): Int {
    return internalLogSite.lineNumber
  }

  override fun getFileName(): String? {
    return internalLogSite.fileName
  }

}