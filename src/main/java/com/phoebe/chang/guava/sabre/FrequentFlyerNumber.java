package com.phoebe.chang.guava.sabre;

/**
 * Created by phoebe on 7/19/15.
 */
public class FrequentFlyerNumber {

    private String ffn;
    private String carrierCode;

    public FrequentFlyerNumber(String carrierCode, String ffn) {
        this.carrierCode = carrierCode;
        this.ffn = ffn;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getFfn() {
        return ffn;
    }

    public void setFfn(String ffn) {
        this.ffn = ffn;
    }
}
