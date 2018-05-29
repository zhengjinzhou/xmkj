package zhou.com.xmkj.bean;

/**
 * Created by zhou on 2018/5/29.
 * 我的粉丝-首页
 */

public class MyFansBean {

    /**
     * code : 200
     * msg : 获取粉丝首页信息成功
     * time : 1527559827
     * data : {"allFans":1,"oneFans":1,"twoFans":0,"threeFans":0}
     */

    private int code;
    private String msg;
    private String time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * allFans : 1
         * oneFans : 1
         * twoFans : 0
         * threeFans : 0
         */

        private int allFans;
        private int oneFans;
        private int twoFans;
        private int threeFans;

        public int getAllFans() {
            return allFans;
        }

        public void setAllFans(int allFans) {
            this.allFans = allFans;
        }

        public int getOneFans() {
            return oneFans;
        }

        public void setOneFans(int oneFans) {
            this.oneFans = oneFans;
        }

        public int getTwoFans() {
            return twoFans;
        }

        public void setTwoFans(int twoFans) {
            this.twoFans = twoFans;
        }

        public int getThreeFans() {
            return threeFans;
        }

        public void setThreeFans(int threeFans) {
            this.threeFans = threeFans;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "allFans=" + allFans +
                    ", oneFans=" + oneFans +
                    ", twoFans=" + twoFans +
                    ", threeFans=" + threeFans +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyFansBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
