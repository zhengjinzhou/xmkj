package zhou.com.xmkj.bean;

import java.io.Serializable;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class VrchInfoBean implements Serializable {

    /**
     * code : 200
     * msg : 加载成功
     * time : 1528854399
     * data : {"ktname":"可提主链","ktval":"0.00","vrchname":"vrch","vrchval":"0.01","price":"0.00","access_key":"","secret_key":""}
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
         * ktname : 可提主链
         * ktval : 0.00
         * vrchname : vrch
         * vrchval : 0.01
         * price : 0.00
         * access_key :
         * secret_key :
         */

        private String ktname;
        private String ktval;
        private String vrchname;
        private String vrchval;
        private String price;
        private String access_key;
        private String secret_key;

        public String getKtname() {
            return ktname;
        }

        public void setKtname(String ktname) {
            this.ktname = ktname;
        }

        public String getKtval() {
            return ktval;
        }

        public void setKtval(String ktval) {
            this.ktval = ktval;
        }

        public String getVrchname() {
            return vrchname;
        }

        public void setVrchname(String vrchname) {
            this.vrchname = vrchname;
        }

        public String getVrchval() {
            return vrchval;
        }

        public void setVrchval(String vrchval) {
            this.vrchval = vrchval;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAccess_key() {
            return access_key;
        }

        public void setAccess_key(String access_key) {
            this.access_key = access_key;
        }

        public String getSecret_key() {
            return secret_key;
        }

        public void setSecret_key(String secret_key) {
            this.secret_key = secret_key;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "ktname='" + ktname + '\'' +
                    ", ktval='" + ktval + '\'' +
                    ", vrchname='" + vrchname + '\'' +
                    ", vrchval='" + vrchval + '\'' +
                    ", price='" + price + '\'' +
                    ", access_key='" + access_key + '\'' +
                    ", secret_key='" + secret_key + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VrchInfoBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
