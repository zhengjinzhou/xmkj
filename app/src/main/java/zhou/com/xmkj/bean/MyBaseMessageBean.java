package zhou.com.xmkj.bean;

/**
 * Created by zhou
 * on 2018/6/1.
 */

public class MyBaseMessageBean {
    int icon;
    String name;
    String content;

    public MyBaseMessageBean( int icon, String name,String content) {
        this.name = name;
        this.icon = icon;
        this.content = content;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyBaseMessageBean{" +
                "  name='" + name + '\'' +
                ", icon=" + icon +
                ", content='" + content + '\'' +
                '}';
    }
}
