package org.springframework.social.facebook.api

class Campaign {

    String id;

    String accountId;

    String buyingType;

    Boolean canUseSpendCap;

    String createdTime;

    EffectiveStatus effectiveStatus;

    String name;

    CampaignObjective objective;

    String spendCap;

    String startTime;

    Status status;

    String stopTime;

    String updatedTime;

    enum ConfiguredStatus {
        ACTIVE,
        PAUSED,
        DELETED,
        ARCHIVED
    }

    enum EffectiveStatus {
        ACTIVE,
        PAUSED,
        DELETED,
        PENDING_REVIEW,
        DISAPPROVED,
        PREAPPROVED,
        CAMPAIGN_PAUSED,
        ARCHIVED,
        ADSET_PAUSED
    }

    enum CampaignObjective {

        NONE,
        BRAND_AWARENESS,
        CANVAS_APP_INSTALLS,
        CANVAS_APP_ENGAGEMENT,
        CONVERSIONS,
        EVENT_RESPONSES,
        LEAD_GENERATION,
        LOCAL_AWARENESS,
        MOBILE_APP_ENGAGEMENT,
        MOBILE_APP_INSTALLS,
        APP_INSTALLS,
        OFFER_CLAIMS,
        PAGE_LIKES,
        POST_ENGAGEMENT,
        LINK_CLICKS,
        WEBSITE_CONVERSIONS,
        VIDEO_VIEWS,
        PRODUCT_CATALOG_SALES,
        UNKNOWN
    }

    enum Status {
        ACTIVE,
        PAUSED,
        DELETED,
        ARCHIVED
    }
}
