package org.springframework.social.facebook.api.impl

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.springframework.social.facebook.api.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * Created by hanishi on 2017/08/03.
 */
@CompileStatic
class AdsTemplate implements AdsOperations {

    final GraphApi graphApi

    AdsTemplate(GraphApi graphApi, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.graphApi = graphApi
    }

    PagedList<Campaign> getCampaigns(String accountId, String... fields) {
        graphApi.fetchConnections "act_" + accountId, "campaigns", Campaign.class, fields
    }

    PagedList<Campaign> getCampaigns(String accountId, PagingParameters pagedListParameters,
                                     String... fields) {
        graphApi.fetchConnections "act_" + accountId, "campaigns", Campaign.class, pagedListParameters.toMap(), fields
    }

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective, String buyingType, Long spendCap, Campaign.Status status, boolean budgetRebalance, List<AdLabel> adlabels, ExecutionOption... executionOptions) {
        return createCampaign(accountId, name, campaignObjective, null, buyingType, spendCap, status, budgetRebalance, adlabels, executionOptions)
    }

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective, AdPromotedObject promotedObject = null, String buyingType = null,
                       Long spendCap = null, Campaign.Status status = Campaign.Status.PAUSED, boolean budgetRebalance = false, List<AdLabel> adlabels = null,
                       ExecutionOption... executionOptions = EnumSet.of(ExecutionOption.INCLUDE_RECOMMENDATIONS)) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>()
        map.with {
            set 'name', name
            set 'objective', campaignObjective.name()
            if (buyingType) {
                set 'buying_type', buyingType
            }
            if (promotedObject) {
                set 'promoted_object', promotedObject
            }
            if (spendCap) {
                set 'spend_cap', spendCap
            }
            if (status) {
                set 'status', status.name()
            }
        }
        graphApi.publish "act_" + accountId, "campaigns", map
    }

    PagedList<Campaign> getAdSets(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "adsets", Campaign.class, fields);
    }

    PagedList<Campaign> getAdSets(String objectId, PagingParameters pagedListParameters,
                                         String... fields) {
        return graphApi
                .fetchConnections(objectId, "adsets", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getAds(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "ads", Campaign.class, fields);
    }

    PagedList<Campaign> getAds(String objectId, PagingParameters pagedListParameters,
                                      String... fields) {
        return graphApi
                .fetchConnections(objectId, "ads", Campaign.class, pagedListParameters.toMap(), fields);
    }

    PagedList<Campaign> getAdCreatives(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "adcreatives", Campaign.class, fields);
    }

    PagedList<Campaign> getAdCreatives(String objectId, PagingParameters pagedListParameters,
                                              String... fields) {
        return graphApi
                .fetchConnections(objectId, "adcreatives", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getAdImages(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "adimages", Campaign.class, fields);
    }

    PagedList<Campaign> getAdImages(String objectId, PagingParameters pagedListParameters,
                                           String... fields) {
        return graphApi
                .fetchConnections(objectId, "adimages", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getAdVideos(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "advideos", Campaign.class, fields);
    }

    PagedList<Campaign> getAdVideos(String objectId, PagingParameters pagedListParameters,
                                           String... fields) {
        return graphApi
                .fetchConnections(objectId, "advideos", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getActivities(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "activities", Campaign.class, fields);
    }

    PagedList<Campaign> getActivities(String objectId, PagingParameters pagedListParameters,
                                             String... fields) {
        return graphApi
                .fetchConnections(objectId, "activities", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getCustomAudiences(String objectId, String... fields) {
        return graphApi
                .fetchConnections("act_" + objectId, "customaudiences", Campaign.class, fields);
    }

    PagedList<Campaign> generatepreviews(String objectId,
                                                PagingParameters pagedListParameters, String... fields) {
        return graphApi.fetchConnections("act_" + objectId, "customaudiences", Campaign.class,
                pagedListParameters.toMap(), fields);
    }

    PagedList<Campaign> offsitepixels(String objectId, PagingParameters pagedListParameters,
                                             String... fields) {
        return graphApi
                .fetchConnections(objectId, "offsitepixels", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getPartnercategories(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "partnercategories", Campaign.class, fields);
    }

    PagedList<Campaign> getPartnercategories(String objectId,
                                                    PagingParameters pagedListParameters, String... fields) {
        return graphApi.fetchConnections(objectId, "partnercategories", Campaign.class,
                pagedListParameters.toMap(), fields);
    }

    PagedList<Campaign> getReachestimate(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "reachestimate", Campaign.class, fields);
    }

    PagedList<Campaign> getTargetingSentenceLines(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "targetingsentencelines", Campaign.class, fields);
    }

    PagedList<Campaign> getTargetingSentenceLines(String objectId,
                                                         PagingParameters pagedListParameters, String... fields) {
        return graphApi.fetchConnections(objectId, "targetingsentencelines", Campaign.class,
                pagedListParameters.toMap(), fields);
    }

    PagedList<Campaign> getUsers(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "users", Campaign.class, fields);
    }

    PagedList<Campaign> getUsers(String objectId, PagingParameters pagedListParameters,
                                        String... fields) {
        return graphApi
                .fetchConnections(objectId, "users", Campaign.class, pagedListParameters.toMap(), fields);
    }

    PagedList<Campaign> getInsights(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "insights", Campaign.class, fields);
    }

    PagedList<Campaign> getInsights(String objectId, PagingParameters pagedListParameters,
                                           String... fields) {
        return graphApi
                .fetchConnections(objectId, "insights", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> getAdKeywordStats(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "insights", Campaign.class, fields);
    }

    PagedList<Campaign> getAdKeywordStats(String objectId,
                                                 PagingParameters pagedListParameters, String... fields) {
        return graphApi
                .fetchConnections(objectId, "insights", Campaign.class, pagedListParameters.toMap(),
                fields);
    }

    PagedList<Campaign> trackingtag(String objectId, String... fields) {
        return graphApi.fetchConnections(objectId, "insights", Campaign.class, fields);
    }

}
