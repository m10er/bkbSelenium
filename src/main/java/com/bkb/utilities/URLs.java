package com.bkb.utilities;

public enum URLs {
    BASE_URL("https://www.bkb.ch/"),
    CONTACT_PAGE(BASE_URL.url + "/de/privatkunden/kontakt"),
    RECENT_TRANSACTIONS_PAGE(BASE_URL.url + "/bank/transaction.jsp");

    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
} 