package com.msl.myroomdatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.msl.myroomdatabase.db.AppDatabase;
import com.msl.myroomdatabase.db.PolicyData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String jsonResponse = "{\"head\":{\"status\":\"Success\"},\"body\":{\"timestamp\":\"13721508\",\"getcpappdatalist\":[{\"policy_policynumber\":\"20570225\",\"policy_status\":\"In Force\",\"policy_activity\":\"Active\",\"policy_start_date\":\"2022-03-15 00:00:00\",\"policy_term\":\"19\",\"claim_status\":\"Initiated\",\"premium\":\"14102\",\"premium_frequency\":\"02\",\"premium_paying_term\":\"19\",\"next_due_date_of_premium\":\"2022-09-15 00:00:00\",\"first_name\":\"RUSHIL\",\"last_name\":\"CHAWAN\",\"birth_date\":\"1984-01-01 00:00:00\",\"email_addr\":\"juileeb@hdfclife.com\",\"policy_clientid\":\"13721508\",\"contact_country_cd\":\"Null\",\"mobile_num\":\"7977260429\",\"productname\":\"HDFC Life Smart Term Edge\",\"product_category\":\"Health/Protection\",\"maturity_date\":\"2041-03-15 00:00:00\",\"death_benefit_amount\":\"3200000\",\"survival_benefit_amount\":\"Null\",\"rider_cover_amount\":\"1000000\",\"rider_name\":\"Critical Illness Rider-04\",\"current_fund_value\":\"Null\"},{\"policy_policynumber\":\"20570225\",\"policy_status\":\"In Force\",\"policy_activity\":\"Active\",\"policy_start_date\":\"2022-03-15 00:00:00\",\"policy_term\":\"19\",\"claim_status\":\"Closed\",\"premium\":\"14102\",\"premium_frequency\":\"02\",\"premium_paying_term\":\"19\",\"next_due_date_of_premium\":\"2022-09-15 00:00:00\",\"first_name\":\"RUSHIL\",\"last_name\":\"CHAWAN\",\"birth_date\":\"1984-01-01 00:00:00\",\"email_addr\":\"juileeb@hdfclife.com\",\"policy_clientid\":\"13721508\",\"contact_country_cd\":\"Null\",\"mobile_num\":\"7977260429\",\"productname\":\"HDFC Life Smart Term Edge\",\"product_category\":\"Health/Protection\",\"maturity_date\":\"2041-03-15 00:00:00\",\"death_benefit_amount\":\"3200000\",\"survival_benefit_amount\":\"Null\",\"rider_cover_amount\":\"1000000\",\"rider_name\":\"Critical Illness Rider-04\",\"current_fund_value\":\"Null\"}]}}";
    Gson gson = new Gson();
    String timestamp="";
    Long timestampLong =(long)  13721508;

    Button deleteBtn,insetBtn;
    ArrayList<PolicyData> policyDataList = new ArrayList<PolicyData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deleteBtn = (Button) findViewById(R.id.deleteRoomBtn);
        insetBtn = (Button) findViewById(R.id.insetRoomBtn);


        setData();


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Perform API call and JSON parsing
                        // ...

                        // Access database on the background thread
                        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                        // ... (perform database operations here)
                        int rowsDeleted = db.policyDataDao().deleteAllApiResponses();
                        boolean isDataDeleted = rowsDeleted > 0;
                        Log.i("DatabaseRoom", "Delete Data Successfully = "+String.valueOf(isDataDeleted));


                        List<PolicyData> existingResponseTwo = db.policyDataDao().getPolicyDataByTimestamp(timestampLong);
                        Log.i("DatabaseRoom", "Delete return size = " + String.valueOf(existingResponseTwo.size()));
                        Log.i("DatabaseRoom", "Delete return = " + new Gson().toJson(existingResponseTwo));
                    }
                }).start();
            }
        });


        insetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database();
            }
        });


    }

    private void database() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Perform API call and JSON parsing
                    // ...

                    // Access database on the background thread
                    // ... (perform database operations here)

                    Log.i("DatabaseRoom", "init");
                    AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                    Log.i("DatabaseRoom", "Database Instance create Successfully");
                    List<PolicyData> existingResponse = db.policyDataDao().getPolicyDataByTimestamp(timestampLong);
                    Log.i("DatabaseRoom", "return size = " + String.valueOf(existingResponse.size()));
                    Log.i("DatabaseRoom", "return = " + new Gson().toJson(existingResponse));
                    if (existingResponse.size()==0) {
                        // Insert new data
                        for(int i=0;i<policyDataList.size();i++){
                            db.policyDataDao().insertPolicyData(policyDataList.get(i));
                        }

                        Log.i("DatabaseRoom", "Insert Data Successfully");
                    } else {
                        // Update existing data
                        // Insert new data
                        for(int i=0;i<policyDataList.size();i++){
                            int rowsUpdated =   db.policyDataDao().updateApiResponse(policyDataList.get(i));
                            boolean isDataUpdated = rowsUpdated > 0;
                            Log.i("DatabaseRoom", "Update Data Successfully = "+String.valueOf(isDataUpdated));


                        }
                        List<PolicyData> existingResponseTwo = db.policyDataDao().getPolicyDataByTimestamp(timestampLong);
                        Log.i("DatabaseRoom", "Update return size = " + String.valueOf(existingResponseTwo.size()));
                        Log.i("DatabaseRoom", "Update return = " + new Gson().toJson(existingResponseTwo));
                      /*  existingResponse.setGetcpappdatalist(apiResponse.getGetcpappdatalist());
                        db.policyDataDao().updateApiResponse(existingResponse);*/
                    }
                }
            }).start();

        }catch (Exception e){
            e.printStackTrace();
            Log.i("DatabaseRoom", "Database error = "+e.getMessage());
        }

    }

    private void setData() {
        try {
            if(policyDataList.size()>0){
                policyDataList.clear();
            }
            // Convert the string to a JSONObject
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Now you can access values using keys
            // Now you can access values using keys
            JSONObject headObject = jsonObject.getJSONObject("head");
            String status = headObject.getString("status");

            JSONObject bodyObject = jsonObject.getJSONObject("body");
            Log.i("DatabaseRoom", "status = "+status);
            timestamp = bodyObject.getString("timestamp");

            Log.i("DatabaseRoom", "timestamp: " + timestamp);
            // Access the "getcpappdatalist" array
            JSONArray getcpappdatalist = bodyObject.getJSONArray("getcpappdatalist");

            // Iterate through the array
            for (int i = 0; i < getcpappdatalist.length(); i++) {
                JSONObject policyData = getcpappdatalist.getJSONObject(i);
                PolicyData policyData1 = new PolicyData();
                // Access individual fields within each policyData object


                policyData1.setTimestamp(timestampLong);
                String policyNumber = policyData.getString("policy_policynumber");
                policyData1.setPolicyNumber(policyNumber);

                String policyStatus = policyData.getString("policy_status");
                policyData1.setPolicyStatus(policyNumber);

                String policyActivity = policyData.getString("policy_activity");
                policyData1.setPolicyActivity(policyActivity);

                String policyStartDate = policyData.getString("policy_start_date");
                policyData1.setPolicyStartDate(policyStartDate);

                String policyTerm = policyData.getString("policy_term");
                policyData1.setPolicyTerm(policyTerm);

                String policyClaimStatus = policyData.getString("claim_status");
                policyData1.setPolicyClaimStatus(policyClaimStatus);

                String policyPremium = policyData.getString("premium");
                policyData1.setPolicyPremium(policyPremium);

                String policyPremiumFrequency = policyData.getString("premium_frequency");
                policyData1.setPolicyPremiumFrequency(policyPremiumFrequency);

                String policyPremiumPayingTerm = policyData.getString("premium_paying_term");
                policyData1.setPolicyPremiumPayingTerm(policyPremiumPayingTerm);

                String policyNextDueDateOfPremium = policyData.getString("next_due_date_of_premium");
                policyData1.setPolicyNextDueDateOfPremium(policyNextDueDateOfPremium);

                String policyFirstName = policyData.getString("first_name");
                policyData1.setPolicyFirstName(policyFirstName);

                String policyLastName = policyData.getString("last_name");
                policyData1.setPolicyLastName(policyLastName);


                String policyBirthDate = policyData.getString("birth_date");
                policyData1.setPolicyBirthDate(policyBirthDate);

                String policyEmailAddress = policyData.getString("email_addr");
                policyData1.setPolicyEmailAddress(policyEmailAddress);

                String policyClientId = policyData.getString("policy_clientid");
                policyData1.setPolicyClientId(policyClientId);

                String policyContactCountryCd = policyData.getString("contact_country_cd");
                policyData1.setPolicyContactCountryCd(policyContactCountryCd);

                String policyMobileNum = policyData.getString("mobile_num");
                policyData1.setPolicyMobileNum (policyMobileNum);

                String policyProductName = policyData.getString("productname");
                policyData1.setPolicyProductName(policyProductName);


                String policyProductCategory = policyData.getString("product_category");
                policyData1.setPolicyProductCategory(policyProductCategory);

                String policyMaturityDate = policyData.getString("maturity_date");
                policyData1.setPolicyMaturityDate(policyMaturityDate);

                String policyDeathBenefitAmount = policyData.getString("death_benefit_amount");
                policyData1.setPolicyDeathBenefitAmount(policyDeathBenefitAmount);

                String policySurvivalBenefitAmount = policyData.getString("survival_benefit_amount");
                policyData1.setPolicySurvivalBenefitAmount(policySurvivalBenefitAmount);

                String policyRiderCoverAmount = policyData.getString("rider_cover_amount");
                policyData1.setPolicyRiderCoverAmount(policyRiderCoverAmount);

                String policyRiderName = policyData.getString("rider_name");
                policyData1.setPolicyRiderName(policyRiderName);

                String policyCurrentFundValue = policyData.getString("current_fund_value");
                policyData1.setPolicyCurrentFundValue(policyCurrentFundValue);


                policyDataList.add(policyData1);

                // Access other fields as needed

                // Print or use the retrieved values
                Log.i("DatabaseRoom", "Policy Number: " + policyNumber);
                Log.i("DatabaseRoom", "Policy Status: " + policyStatus);
                Log.i("DatabaseRoom", "policyDataList size: " + String.valueOf(policyDataList.size()));

            }

            // Print or use other fields

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("DatabaseRoom", "error = "+e.getMessage());
        }
    }


}