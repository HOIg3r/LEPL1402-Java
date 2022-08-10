public class Client extends Observer {

    protected String news;

    protected int zone;

    public Client(int zone){
        this.zone = zone;
        this.news = "";
    }

    @Override
    public void update(Object o) {
        if(o.getClass() == String.class){
            this.news = o.toString();
        }
    }

    @Override
    public int getZone() {
        return this.zone;
    }

    @Override
    public String getNews() {
        return this.news;
    }

}