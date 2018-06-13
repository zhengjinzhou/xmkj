package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/13.
 */

public class RewardDetailBean implements Serializable{

    /**
     * code : 200
     * msg : 获取带加速明细成功
     * time : 1528859645
     * data : {"page":1,"pagesize":"10","total":43,"list":[{"id":37053,"money":"70.00","createtime":"2018-06-10 18:34:51","note":"ttt55投资￥1000.00,加速：1000.00*70%*10%","rewardtype":"直推加速(未释放)"},{"id":37048,"money":"70.00","createtime":"2018-06-10 18:33:11","note":"111113232投资￥1000.00,加速：1000.00*70%*10%","rewardtype":"直推加速(未释放)"},{"id":37050,"money":"70.00","createtime":"2018-06-10 18:33:11","note":"111113232投资￥1000.00,加速:1000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":37047,"money":"70.00","createtime":"2018-06-05 10:28:27","note":"22投资￥1000,加速:1000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":36746,"money":"35.00","createtime":"2018-05-29 21:17:04","note":"xh123投资￥500.00,加速:500*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":33114,"money":"140.00","createtime":"2018-05-26 00:07:33","note":"mcy888投资￥2000.00,加速:2000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":33103,"money":"35.00","createtime":"2018-05-26 00:06:53","note":"llh2投资￥500,加速:500*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":32967,"money":"12830.00","createtime":"2018-05-25 22:19:14","note":"wang666投资￥500000.00,当天已封顶,加速:12830","rewardtype":"对碰加速(未释放)"},{"id":32957,"money":"35000.00","createtime":"2018-05-25 22:18:26","note":"wang7777投资￥500000.00,加速:500000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":32909,"money":"2100.00","createtime":"2018-05-25 21:55:33","note":"wang777投资￥30000.00,加速:30000*70%*10%","rewardtype":"对碰加速(未释放)"}]}
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
         * page : 1
         * pagesize : 10
         * total : 43
         * list : [{"id":37053,"money":"70.00","createtime":"2018-06-10 18:34:51","note":"ttt55投资￥1000.00,加速：1000.00*70%*10%","rewardtype":"直推加速(未释放)"},{"id":37048,"money":"70.00","createtime":"2018-06-10 18:33:11","note":"111113232投资￥1000.00,加速：1000.00*70%*10%","rewardtype":"直推加速(未释放)"},{"id":37050,"money":"70.00","createtime":"2018-06-10 18:33:11","note":"111113232投资￥1000.00,加速:1000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":37047,"money":"70.00","createtime":"2018-06-05 10:28:27","note":"22投资￥1000,加速:1000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":36746,"money":"35.00","createtime":"2018-05-29 21:17:04","note":"xh123投资￥500.00,加速:500*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":33114,"money":"140.00","createtime":"2018-05-26 00:07:33","note":"mcy888投资￥2000.00,加速:2000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":33103,"money":"35.00","createtime":"2018-05-26 00:06:53","note":"llh2投资￥500,加速:500*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":32967,"money":"12830.00","createtime":"2018-05-25 22:19:14","note":"wang666投资￥500000.00,当天已封顶,加速:12830","rewardtype":"对碰加速(未释放)"},{"id":32957,"money":"35000.00","createtime":"2018-05-25 22:18:26","note":"wang7777投资￥500000.00,加速:500000*70%*10%","rewardtype":"对碰加速(未释放)"},{"id":32909,"money":"2100.00","createtime":"2018-05-25 21:55:33","note":"wang777投资￥30000.00,加速:30000*70%*10%","rewardtype":"对碰加速(未释放)"}]
         */

        private int page;
        private String pagesize;
        private int total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 37053
             * money : 70.00
             * createtime : 2018-06-10 18:34:51
             * note : ttt55投资￥1000.00,加速：1000.00*70%*10%
             * rewardtype : 直推加速(未释放)
             */

            private int id;
            private String money;
            private String createtime;
            private String note;
            private String rewardtype;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getRewardtype() {
                return rewardtype;
            }

            public void setRewardtype(String rewardtype) {
                this.rewardtype = rewardtype;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", money='" + money + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", note='" + note + '\'' +
                        ", rewardtype='" + rewardtype + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "page=" + page +
                    ", pagesize='" + pagesize + '\'' +
                    ", total=" + total +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RewardDetailBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
