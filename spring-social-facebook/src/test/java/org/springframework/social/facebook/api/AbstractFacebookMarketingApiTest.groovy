package org.springframework.social.facebook.api

import org.junit.Before

class AbstractFacebookMarketingApiTest {

    @Before
    void setup() {
        ExpandoMetaClass.enableGlobally()
        Facebook.metaClass.adsOperations = { -> delegate.adsOperations() }
    }
}
