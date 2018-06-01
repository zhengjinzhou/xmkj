package zhou.com.xmkj.bean;

/**
 * Created by zhou
 * on 2018/6/1.
 */

public class MyBaseAccountBean {
    String icon;
    String name;
    String content;

    public MyBaseAccountBean(String icon, String name, String content) {
        this.icon = icon;
        this.name = name;
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyBaseAccountBean{" +
                "icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
