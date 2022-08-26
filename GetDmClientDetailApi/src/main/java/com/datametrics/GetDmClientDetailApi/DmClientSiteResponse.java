package com.datametrics.GetDmClientDetailApi;

import java.io.Serializable;

public class DmClientSiteResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
/*
  public DmClientSiteResponse(int clientSiteId, String clientSiteName, String clientSiteLogoUrl, String clientSiteUrl,
  			String brandMappingType, int sortOrder, float goodReturnsPct, int bbCalculationLookbackDays,
  			int isActiveFlag) {
  		super();
  		this.clientSiteId = clientSiteId;
  		this.clientSiteName = clientSiteName;
  		this.clientSiteLogoUrl = clientSiteLogoUrl;
  		this.clientSiteUrl = clientSiteUrl;
  		this.brandMappingType = brandMappingType;
  		this.sortOrder = sortOrder;
  		this.goodReturnsPct = goodReturnsPct;
  		this.bbCalculationLookbackDays = bbCalculationLookbackDays;
  		this.isActiveFlag = isActiveFlag;
  	}

  */

	private Long clientSiteId;

   // @Column(name = "client_site_name", nullable = false)
    private String clientSiteName;

   // @Column(name = "client_site_logo_url", length = 1000)
    private String clientSiteLogoUrl;

   // @Column(name = "client_site_url", length = 1000)
    private String clientSiteUrl;
    
    //@Column(name = "brand_mapping_type", length = 1000)
    private String brandMappingType;

    //@Column(name = "sort_order", length = 100)
    private int sortOrder;

    //@Column(name = "good_returns_pct")
    private float goodReturnsPct;

    //@Column(name = "bb_calculation_lookback_days")
    private int bbCalculationLookbackDays;

    private int isActiveFlag;
    
	public Long getClientSiteId() {
		return clientSiteId;
	}

	public void setClientSiteId(Long clientSiteId) {
		this.clientSiteId = clientSiteId;
	}

	public String getClientSiteName() {
		return clientSiteName;
	}

	public void setClientSiteName(String clientSiteName) {
		this.clientSiteName = clientSiteName;
	}

	public String getClientSiteLogoUrl() {
		return clientSiteLogoUrl;
	}

	public void setClientSiteLogoUrl(String clientSiteLogoUrl) {
		this.clientSiteLogoUrl = clientSiteLogoUrl;
	}

	public String getClientSiteUrl() {
		return clientSiteUrl;
	}

	public void setClientSiteUrl(String clientSiteUrl) {
		this.clientSiteUrl = clientSiteUrl;
	}

	public String getBrandMappingType() {
		return brandMappingType;
	}

	public void setBrandMappingType(String brandMappingType) {
		this.brandMappingType = brandMappingType;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public float getGoodReturnsPct() {
		return goodReturnsPct;
	}

	public void setGoodReturnsPct(float goodReturnsPct) {
		this.goodReturnsPct = goodReturnsPct;
	}

	public int getBbCalculationLookbackDays() {
		return bbCalculationLookbackDays;
	}

	public void setBbCalculationLookbackDays(int bbCalculationLookbackDays) {
		this.bbCalculationLookbackDays = bbCalculationLookbackDays;
	}

	public int getIsActiveFlag() {
		return isActiveFlag;
	}

	public void setIsActiveFlag(int isActiveFlag) {
		this.isActiveFlag = isActiveFlag;
	}
    
    


}