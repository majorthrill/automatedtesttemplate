package expleo;

import com.google.common.base.MoreObjects;

public class NameValuePair {

    private String name;

    private String value;

    public NameValuePair() {
        super();
    }

    public NameValuePair(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(name).addValue(value).toString();
    }
}
