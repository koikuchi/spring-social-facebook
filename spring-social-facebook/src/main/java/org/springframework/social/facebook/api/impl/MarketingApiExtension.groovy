package org.springframework.social.facebook.api.impl

import groovy.transform.CompileStatic
import org.springframework.social.facebook.api.AdsOperations

class MarketingApiExtension {
    @CompileStatic
    static AdsOperations adsOperations(FacebookTemplate facebookTemplate) {
        return new AdsTemplate(facebookTemplate, facebookTemplate.getRestTemplate(), facebookTemplate.getJsonMessageConverter().getObjectMapper())
    }
}
