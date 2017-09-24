package org.springframework.social.facebook.api;

/**
 * Created by hanishi on 2017/08/03.
 */
interface AdsOperations {

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective, AdPromotedObject promotedObject, String buyingType,
                       Long spendCap, Campaign.Status status, boolean budgetRebalance, List<AdLabel> adlabels, ExecutionOption... executionOptions)

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective, String buyingType,
                       Long spendCap, Campaign.Status status, boolean budgetRebalance, List<AdLabel> adlabels, ExecutionOption... executionOptions)

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective)

    def createCampaign(String accountId, String name, Campaign.CampaignObjective campaignObjective, AdPromotedObject promotedObject)

    PagedList<Campaign> getCampaigns(String accountId, String... fields)

    PagedList<Campaign> getCampaigns(String accountId, PagingParameters pagedListParameters, String... fields)
}
