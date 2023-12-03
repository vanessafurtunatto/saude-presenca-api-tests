package enums;

public enum ConfigEnum {
    BASE_URL("http://api.saudepresenca.cloud/v1");

    private String url;

    public String getUrl() {
        return url;
    }
    ConfigEnum(String url) {
        this.url = url;
    }
}

