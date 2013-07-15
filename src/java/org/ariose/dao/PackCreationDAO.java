package org.ariose.dao;



import java.util.List;

import org.ariose.model.CircleBean;
import org.ariose.model.Content;
import org.ariose.model.ContentScheduler;
import org.ariose.model.GraceActive;
import org.ariose.model.GraceRenewal;
import org.ariose.model.PackContent;
import org.ariose.model.PriceValueBean;
import org.ariose.model.PullService;
import org.ariose.model.RenewalPriceValueBean;
import org.ariose.model.SubscriptionPackBean;

/**
 *
 * @author A.Rahman
 */
public interface  PackCreationDAO extends DAO {

    public List getOperators()throws Exception;

    public List getCircles(int operator_id);
    
    public List getSubscriptionPacks(int circleId, int operatorId);
    
    public List getBasePacks(int circleId, int operatorId);

    public SubscriptionPackBean getPack(int pack_id);

    public List getPacks();

    public void removePack(int pack_id);

    public List getPackDMs(int dm_id);

    public List getContentIds(int packId);

    public Content getContent(Long contentId);

    public PackContent getDeliveryFrquency(int contentId);

    public List getDeliveryMechanisms();

    public List getContentOwner(int dm_id);

    public List getLanguages(int dm_id, String content_owner_name);

    public List getContents(int dm_id, String content_owner_name,String language);

    public void saveContentInfoFixedDailyDF(PackContent packContent);
    
    public void saveContentSchedulers(List contentSchedulers);

    public int removeContentSchedulers(int packId, int contentId);
    
    public void savePackChargingActiveFreq(GraceActive graceActive);

    public void savePackChargingRenewalFreq(GraceRenewal graceRenewal);

    public void removeContentInfo(int id);
    
    public PackContent getContentInfo(int id);

    public void savePackInfo(SubscriptionPackBean subscriptionPackBean);

    public List getContents();

    public List getActivePriceValues(int packId);

    public void saveActivePV(PriceValueBean priceValueBean);

    public void removeActivePV(int id);

    public List getRenewalPriceValues(int packId);    

    public void saveRenewalPV(RenewalPriceValueBean renewalPriceValueBean);

    public void removeRenewalPV(int id);

    public List getLanguages();

    public List getActiveGraceFreq(int packId);

    public List getRenewalGraceFreq(int packId);

    public List getGatewayInfo(int circleId,String beanName);
    
    public List getChargingGateway(int operatorId, int circleId);

    public List getPackByAppId(String appId);//packInfo is appId

    public List<ContentScheduler> getContentSchedulers();

    public void updateContentSchedulers();

    public void removeContentSchedulers(int pack_id);

    public List<CircleBean> getCircleName(int circle_id);
    public void removeRealtimeDashboardData(int packId,int circleId,int operatorId, int contentId);

    public List<ContentScheduler> getContentScheduler(int pack_id, int circleId, int operator_id);
    
    public List<PullService> getPullService(String requestLink);
    
}
