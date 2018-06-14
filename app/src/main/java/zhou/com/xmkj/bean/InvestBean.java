package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class InvestBean implements Serializable {


    /**
     * code : 200
     * msg : 获取流通转账首页成功
     * time : 1528937491
     * data : {"walletName1":"流通子链","walletMoney1":"1009.47","walletName2":"注册链","walletMoney2":"200.00","type":[{"type":5,"name":"注册链"}]}
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
         * walletName1 : 流通子链
         * walletMoney1 : 1009.47
         * walletName2 : 注册链
         * walletMoney2 : 200.00
         * type : [{"type":5,"name":"注册链"}]
         */

        private String walletName1;
        private String walletMoney1;
        private String walletName2;
        private String walletMoney2;
        private List<TypeBean> type;

        public String getWalletName1() {
            return walletName1;
        }

        public void setWalletName1(String walletName1) {
            this.walletName1 = walletName1;
        }

        public String getWalletMoney1() {
            return walletMoney1;
        }

        public void setWalletMoney1(String walletMoney1) {
            this.walletMoney1 = walletMoney1;
        }

        public String getWalletName2() {
            return walletName2;
        }

        public void setWalletName2(String walletName2) {
            this.walletName2 = walletName2;
        }

        public String getWalletMoney2() {
            return walletMoney2;
        }

        public void setWalletMoney2(String walletMoney2) {
            this.walletMoney2 = walletMoney2;
        }

        public List<TypeBean> getType() {
            return type;
        }

        public void setType(List<TypeBean> type) {
            this.type = type;
        }

        public static class TypeBean {
            /**
             * type : 5
             * name : 注册链
             */

            private int type;
            private String name;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "TypeBean{" +
                        "type=" + type +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "walletName1='" + walletName1 + '\'' +
                    ", walletMoney1='" + walletMoney1 + '\'' +
                    ", walletName2='" + walletName2 + '\'' +
                    ", walletMoney2='" + walletMoney2 + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "InvestBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
