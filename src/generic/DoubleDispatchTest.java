package generic;

class DoubleDispatchTest {
    public static void main(String[] args) {
        Content text = new Text("Hello");
        text.postOn(new Instagram());
        Content pic = new Picture("World");
        pic.postOn(new Twitter());
    }
}

interface Sns{
    void post(Text text);
    void post(Picture picture);
}
class Instagram implements Sns{
    public void post(Text text){
        System.out.println("Instagram text = "+text.text);
    }
    public void post(Picture picture){
        System.out.println("Instagram picture = " +picture.picture);
    }
}
class Twitter implements Sns{
    public void post(Text text){
        System.out.println("Twitter text = "+text.text);
    }
    public void post(Picture picture){
        System.out.println("Twitter picture = " +picture.picture);
    }
}
interface Content{
    void postOn(Sns sns);
}
class Text implements Content{
    String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void postOn(Sns sns){
        sns.post(this);
    }
}
class Picture implements Content{
    String picture;

    public Picture(String picture) {
        this.picture = picture;
    }

    @Override
    public void postOn(Sns sns) {
        sns.post(this);
    }
}
