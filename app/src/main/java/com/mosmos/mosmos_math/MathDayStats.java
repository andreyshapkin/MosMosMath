package com.mosmos.mosmos_math;

import android.content.SharedPreferences;
import android.util.Log;

import com.mosmos.mosmos_math.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MathDayStats {
    private static final String TAG = "MathDayStats";

    private String keyDate()  {return user + "_STATS_DATE";}
    private String keyTotal() {return user + "_STATS_TOTAL";}
    private String keyRight() {return user + "_STATS_RIGHT";}
    private String keyWrong() {return user + "_STATS_WRONG";}

    // placeholder
    private String user = "user";
    // content of the preferences
    private String statsDate = "";
    private int total = 0;
    private int right = 0;
    private int wrong = 0;

    private SharedPreferences getSharedPreferences() {return MainActivity.sharedPreferences;}
    private SharedPreferences.Editor getSharedPreferencesEditor() {return MainActivity.sharedPreferencesEditor;}

    public void incTotal() {
        checkStatsUpToDate();
        this.total++;
        writeStats();
    }
    public void incRight() {
        checkStatsUpToDate();
        this.right++;
        writeStats();
    }
    public void incWrong() {
        checkStatsUpToDate();
        this.wrong++;
        writeStats();
    }
    public int getTotal() {
        checkStatsUpToDate();
        return total;
    }
    public int getRight() {
        checkStatsUpToDate();
        return right;
    }
    public int getWrong() {
        checkStatsUpToDate();
        return wrong;
    }


    private void checkStatsUpToDate() {
        String date = getDateString();
        Log.d(TAG, "checkStatsUpToDate: date=" + date);
        if (date.equals(statsDate)) {
            Log.d(TAG, "checkStatsUpToDate: local values are up to date");
            return;
        }
        statsDate = readDate();
        Log.d(TAG, "checkStatsUpToDate: pref_date=" + statsDate);
        if (date.equals(statsDate)) {
            Log.d(TAG, "checkStatsUpToDate: preference stats are up to date");
            readStats();
        } else {
            Log.d(TAG, "checkStatsUpToDate: resetting stats");
            resetStats();
        }
    }

    private String getString() {
        return "date=" + statsDate + " " + String.valueOf(total) + "/" + String.valueOf(right) + "/" + String.valueOf(wrong);
    }

    private void resetStats() {
        Log.d(TAG, "resetStats: resetting stats");
        total = 0;
        right = 0;
        wrong = 0;
        writeStats();
    }

    private String getDateString() {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Log.d(TAG, "getDateString: date [" + date + "]");
        return date;
    }

    private String readDate() {
        String stats_date = getSharedPreferences().getString(keyDate(), "no value");
        Log.d(TAG, "readDate: " + stats_date);
        return stats_date;
    }

    private void readStats() {
        total = getSharedPreferences().getInt(keyTotal(), 0);
        right = getSharedPreferences().getInt(keyRight(), 0);
        wrong = getSharedPreferences().getInt(keyWrong(), 0);
        Log.d(TAG, "readStats: " + getString());
    }

    private void writeStats() {
        getSharedPreferencesEditor().putString(keyDate(), getDateString());
        getSharedPreferencesEditor().putInt(keyTotal(), total);
        getSharedPreferencesEditor().putInt(keyRight(), right);
        getSharedPreferencesEditor().putInt(keyWrong(), wrong);
        getSharedPreferencesEditor().commit();
        Log.d(TAG, "writeStats: " + getString());
    }
}
