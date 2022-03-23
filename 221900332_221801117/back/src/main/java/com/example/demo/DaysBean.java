package com.example.demo;

import java.io.Serializable;
import java.util.List;

public class DaysBean implements Serializable {
    public DataBean data;
    public static class DataBean implements Serializable {
        public int total;
        public List<MatchListBean> matchList;

        public static class MatchListBean implements Serializable {
            public String homeid;
            public String h5pageid;
            public String statusname;
            public String itemcode;
            public String subitemname;
            public String id;
            public String vrtotalurl;
            public String enddatecn;
            public String albumurl;
            public String title;
            public String vrlivecode;
            public String deletedflag;
            public String documentcode;
            public String totaltitle;
            public String imageurl;
            public String vrliveurl;
            public String pageid;
            public String startdatecn;
            public String venuename;
            public String subitemcode;
            public String awayid;
            public String totalguid;
            public String status;
            public String combatflag;
            public String lockflag;
            public String mvlivecode;
            public String homename;
            public String liveurl;
            public String awayname;
            public String reserve3;
            public String venue;
            public String awayscore;
            public String reserve2;
            public String homecode;
            public String reserve1;
            public String vrtotalcode;
            public String homescore;
            public String livecode;
            public String itemcodename;
            public String totalurl;
            public String mvliveurl;
            public String awaycode;
            public String adcode;
            public String medal;
        }
    }//每日赛程的bean


}
