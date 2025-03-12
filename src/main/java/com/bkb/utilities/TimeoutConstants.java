package com.bkb.utilities;

import java.time.Duration;

public final class TimeoutConstants {
    // Constructor'ı private yaparak instantiation'ı engelliyoruz
    private TimeoutConstants() {
        throw new UnsupportedOperationException("Bu bir utility class'tır ve instance oluşturulamaz");
    }

    // Explicit Wait Timeout'ları
    public static final Duration EXPLICIT_WAIT_SHORT = Duration.ofSeconds(5);
    public static final Duration EXPLICIT_WAIT_MEDIUM = Duration.ofSeconds(10);
    public static final Duration EXPLICIT_WAIT_LONG = Duration.ofSeconds(20);
    public static final Duration EXPLICIT_WAIT_VERY_LONG = Duration.ofSeconds(30);

    // Implicit Wait Timeout'ları
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);

    // Page Load Timeout'ları
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);
    public static final Duration PAGE_LOAD_TIMEOUT_LONG = Duration.ofSeconds(60);

    // Script Timeout'ları
    public static final Duration SCRIPT_TIMEOUT = Duration.ofSeconds(30);

    // Polling Interval'ları
    public static final Duration POLLING_INTERVAL_SHORT = Duration.ofMillis(250);
    public static final Duration POLLING_INTERVAL_MEDIUM = Duration.ofMillis(500);
    public static final Duration POLLING_INTERVAL_LONG = Duration.ofSeconds(1);

    // Retry Timeout'ları
    public static final Duration RETRY_TIMEOUT = Duration.ofSeconds(10);
    public static final int RETRY_COUNT = 3;

    // Ajax Call Timeout'ları
    public static final Duration AJAX_ELEMENT_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration AJAX_PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);

    // Animation Timeout'ları
    public static final Duration ANIMATION_TIMEOUT = Duration.ofSeconds(2);
} 