package bridge;

public class MainClass {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        Theme lightTheme = new LightTheme();
        WebPage about = new About(darkTheme);
        WebPage careers = new Careers(lightTheme);
        System.out.println(about.getContent());
        System.out.println(careers.getContent());
    }
}
