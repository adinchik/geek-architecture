package bridge;

public abstract class WebPage {

    protected Theme theme;
    public WebPage(Theme theme) {
        this.theme = theme;
    }

    abstract public String getContent();
}
