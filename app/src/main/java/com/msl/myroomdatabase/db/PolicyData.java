package com.msl.myroomdatabase.db;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "policy_data")
public class PolicyData {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "timestamp")
    public long timestamp;
    @ColumnInfo(name = "policy_policynumber")
    public String policyNumber;
    @ColumnInfo(name = "policy_status")
    public String policyStatus;
    @ColumnInfo(name = "policy_activity")
    public String policyActivity;
    @ColumnInfo(name = "policy_start_date")
    public String policyStartDate;



    @ColumnInfo(name = "policy_term")
    public String policyTerm;
    @ColumnInfo(name = "claim_status")
    public String policyClaimStatus;
    @ColumnInfo(name = "premium")
    public String policyPremium;
    @ColumnInfo(name = "premium_frequency")
    public String policyPremiumFrequency;


    @ColumnInfo(name = "premium_paying_term")
    public String policyPremiumPayingTerm;
    @ColumnInfo(name = "next_due_date_of_premium")
    public String policyNextDueDateOfPremium;
    @ColumnInfo(name = "first_name")
    public String policyFirstName;
    @ColumnInfo(name = "last_name")
    public String policyLastName;


    @ColumnInfo(name = "birth_date")
    public String policyBirthDate;
    @ColumnInfo(name = "email_addr")
    public String policyEmailAddress;
    @ColumnInfo(name = "policy_clientid")
    public String policyClientId;
    @ColumnInfo(name = "contact_country_cd")
    public String policyContactCountryCd;


    @ColumnInfo(name = "mobile_num")
    public String policyMobileNum;
    @ColumnInfo(name = "productname")
    public String policyProductName;
    @ColumnInfo(name = "product_category")
    public String policyProductCategory;
    @ColumnInfo(name = "maturity_date")
    public String policyMaturityDate;


    @ColumnInfo(name = "death_benefit_amount")
    public String policyDeathBenefitAmount;


    @ColumnInfo(name = "survival_benefit_amount")
    public String policySurvivalBenefitAmount;
    @ColumnInfo(name = "rider_cover_amount")
    public String policyRiderCoverAmount;
    @ColumnInfo(name = "rider_name")
    public String policyRiderName;
    @ColumnInfo(name = "current_fund_value")
    public String policyCurrentFundValue;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getPolicyActivity() {
        return policyActivity;
    }

    public void setPolicyActivity(String policyActivity) {
        this.policyActivity = policyActivity;
    }

    public String getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(String policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public String getPolicyTerm() {
        return policyTerm;
    }

    public void setPolicyTerm(String policyTerm) {
        this.policyTerm = policyTerm;
    }

    public String getPolicyClaimStatus() {
        return policyClaimStatus;
    }

    public void setPolicyClaimStatus(String policyClaimStatus) {
        this.policyClaimStatus = policyClaimStatus;
    }

    public String getPolicyPremium() {
        return policyPremium;
    }

    public void setPolicyPremium(String policyPremium) {
        this.policyPremium = policyPremium;
    }

    public String getPolicyPremiumFrequency() {
        return policyPremiumFrequency;
    }

    public void setPolicyPremiumFrequency(String policyPremiumFrequency) {
        this.policyPremiumFrequency = policyPremiumFrequency;
    }

    public String getPolicyPremiumPayingTerm() {
        return policyPremiumPayingTerm;
    }

    public void setPolicyPremiumPayingTerm(String policyPremiumPayingTerm) {
        this.policyPremiumPayingTerm = policyPremiumPayingTerm;
    }

    public String getPolicyNextDueDateOfPremium() {
        return policyNextDueDateOfPremium;
    }

    public void setPolicyNextDueDateOfPremium(String policyNextDueDateOfPremium) {
        this.policyNextDueDateOfPremium = policyNextDueDateOfPremium;
    }

    public String getPolicyFirstName() {
        return policyFirstName;
    }

    public void setPolicyFirstName(String policyFirstName) {
        this.policyFirstName = policyFirstName;
    }

    public String getPolicyLastName() {
        return policyLastName;
    }

    public void setPolicyLastName(String policyLastName) {
        this.policyLastName = policyLastName;
    }

    public String getPolicyBirthDate() {
        return policyBirthDate;
    }

    public void setPolicyBirthDate(String policyBirthDate) {
        this.policyBirthDate = policyBirthDate;
    }

    public String getPolicyEmailAddress() {
        return policyEmailAddress;
    }

    public void setPolicyEmailAddress(String policyEmailAddress) {
        this.policyEmailAddress = policyEmailAddress;
    }

    public String getPolicyClientId() {
        return policyClientId;
    }

    public void setPolicyClientId(String policyClientId) {
        this.policyClientId = policyClientId;
    }

    public String getPolicyContactCountryCd() {
        return policyContactCountryCd;
    }

    public void setPolicyContactCountryCd(String policyContactCountryCd) {
        this.policyContactCountryCd = policyContactCountryCd;
    }

    public String getPolicyMobileNum() {
        return policyMobileNum;
    }

    public void setPolicyMobileNum(String policyMobileNum) {
        this.policyMobileNum = policyMobileNum;
    }

    public String getPolicyProductName() {
        return policyProductName;
    }

    public void setPolicyProductName(String policyProductName) {
        this.policyProductName = policyProductName;
    }

    public String getPolicyProductCategory() {
        return policyProductCategory;
    }

    public void setPolicyProductCategory(String policyProductCategory) {
        this.policyProductCategory = policyProductCategory;
    }

    public String getPolicyMaturityDate() {
        return policyMaturityDate;
    }

    public void setPolicyMaturityDate(String policyMaturityDate) {
        this.policyMaturityDate = policyMaturityDate;
    }

    public String getPolicyDeathBenefitAmount() {
        return policyDeathBenefitAmount;
    }

    public void setPolicyDeathBenefitAmount(String policyDeathBenefitAmount) {
        this.policyDeathBenefitAmount = policyDeathBenefitAmount;
    }

    public String getPolicySurvivalBenefitAmount() {
        return policySurvivalBenefitAmount;
    }

    public void setPolicySurvivalBenefitAmount(String policySurvivalBenefitAmount) {
        this.policySurvivalBenefitAmount = policySurvivalBenefitAmount;
    }

    public String getPolicyRiderCoverAmount() {
        return policyRiderCoverAmount;
    }

    public void setPolicyRiderCoverAmount(String policyRiderCoverAmount) {
        this.policyRiderCoverAmount = policyRiderCoverAmount;
    }

    public String getPolicyRiderName() {
        return policyRiderName;
    }

    public void setPolicyRiderName(String policyRiderName) {
        this.policyRiderName = policyRiderName;
    }

    public String getPolicyCurrentFundValue() {
        return policyCurrentFundValue;
    }

    public void setPolicyCurrentFundValue(String policyCurrentFundValue) {
        this.policyCurrentFundValue = policyCurrentFundValue;
    }
}
