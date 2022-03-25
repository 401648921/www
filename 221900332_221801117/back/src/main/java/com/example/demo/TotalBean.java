package com.example.demo;

import java.io.Serializable;
import java.util.List;

public class TotalBean implements Serializable {//总榜的bean

    public DataBean data;

    public static class DataBean implements Serializable {
        public int total;
        public List<MedalsListBean> medalsList;

        public static class MedalsListBean implements Serializable {
            public String bronze;
            public String rank;
            public String count;
            public String silver;
            public String countryname;
            public String gold;
            public String countryid;
        }
    }
}
