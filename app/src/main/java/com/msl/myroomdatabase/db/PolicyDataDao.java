package com.msl.myroomdatabase.db;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PolicyDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPolicyData(PolicyData policyData);

    @Query("SELECT * FROM policy_data WHERE timestamp = :timestamp")
    List<PolicyData> getPolicyDataByTimestamp(long timestamp);


    @Update
    int updateApiResponse(PolicyData policyData);


    @Query("DELETE FROM policy_data")
    int deleteAllApiResponses();
}
