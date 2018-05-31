package zhou.com.xmkj.bean;

import java.util.List;

/**
 * Created by zhou on 2018/5/31.
 */

public class IntradeBean {

    /**
     * code : 200
     * msg : 获取流通交易数据成功
     * time : 1527741066
     * data : {"wallet":[{"type":0,"name":"VR主链","money":"10000.00"},{"type":1,"name":"定仓子链","money":"115355.76"},{"type":2,"name":"流通子链","money":"7350.85"},{"type":3,"name":"交易子链","money":"0.00"},{"type":4,"name":"重消子链","money":"10.00"},{"type":5,"name":"注册链","money":"0.00"}],"rewards":[{"x":"周五","y":"347.11"},{"x":"周六","y":"0.00"},{"x":"周日","y":"0.00"},{"x":"周一","y":"0.00"},{"x":"周二","y":"0.00"},{"x":"周三","y":"0.00"},{"x":"周四","y":"0.00"}],"dtmoney":"0.00"}
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
         * wallet : [{"type":0,"name":"VR主链","money":"10000.00"},{"type":1,"name":"定仓子链","money":"115355.76"},{"type":2,"name":"流通子链","money":"7350.85"},{"type":3,"name":"交易子链","money":"0.00"},{"type":4,"name":"重消子链","money":"10.00"},{"type":5,"name":"注册链","money":"0.00"}]
         * rewards : [{"x":"周五","y":"347.11"},{"x":"周六","y":"0.00"},{"x":"周日","y":"0.00"},{"x":"周一","y":"0.00"},{"x":"周二","y":"0.00"},{"x":"周三","y":"0.00"},{"x":"周四","y":"0.00"}]
         * dtmoney : 0.00
         */

        private String dtmoney;
        private List<WalletBean> wallet;
        private List<RewardsBean> rewards;

        public String getDtmoney() {
            return dtmoney;
        }

        public void setDtmoney(String dtmoney) {
            this.dtmoney = dtmoney;
        }

        public List<WalletBean> getWallet() {
            return wallet;
        }

        public void setWallet(List<WalletBean> wallet) {
            this.wallet = wallet;
        }

        public List<RewardsBean> getRewards() {
            return rewards;
        }

        public void setRewards(List<RewardsBean> rewards) {
            this.rewards = rewards;
        }

        public static class WalletBean {
            /**
             * type : 0
             * name : VR主链
             * money : 10000.00
             */

            private int type;
            private String name;
            private String money;

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

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            @Override
            public String toString() {
                return "WalletBean{" +
                        "type=" + type +
                        ", name='" + name + '\'' +
                        ", money='" + money + '\'' +
                        '}';
            }
        }

        public static class RewardsBean {
            /**
             * x : 周五
             * y : 347.11
             */

            private String x;
            private String y;

            public String getX() {
                return x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y;
            }

            public void setY(String y) {
                this.y = y;
            }

            @Override
            public String toString() {
                return "RewardsBean{" +
                        "x='" + x + '\'' +
                        ", y='" + y + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "dtmoney='" + dtmoney + '\'' +
                    ", wallet=" + wallet +
                    ", rewards=" + rewards +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IntradeBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
