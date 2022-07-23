package com.example.demo.listener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.RetryListener
import org.springframework.stereotype.Component

@Component
class SampleRetryListener: RetryListener {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun <T : Any?, E : Throwable?> open(context: RetryContext?, callback: RetryCallback<T, E>?): Boolean {
        return true
    }

    override fun <T : Any?, E : Throwable?> close(
        context: RetryContext?,
        callback: RetryCallback<T, E>?,
        throwable: Throwable?
    ) {
        // Do Nothing
    }

    override fun <T : Any?, E : Throwable?> onError(
        context: RetryContext?,
        callback: RetryCallback<T, E>?,
        throwable: Throwable?
    ) {
        log.info("Retry OnError: count={}, message={}", context?.retryCount, throwable?.message)
    }
}
