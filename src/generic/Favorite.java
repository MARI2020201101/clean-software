package generic;

import java.util.HashMap;
import java.util.Map;

class FavoriteTest{
    public static void main(String[] args) {
        Favorite favorite = new Favorite();
        favorite.putFavorite(String.class, "Hello");
        favorite.putFavorite(Integer.class, 1);
        System.out.println(favorite.getFavorite(String.class));
        System.out.println(favorite.getFavorite(Integer.class));
    }
}
class Favorite {

    private Map<Class<?>, Object> favoriteMap = new HashMap<>();
    <T> void putFavorite(Class<T> klass, T something){
        favoriteMap.put(klass, something);
    }
    <T> T getFavorite(Class<T> klass){
        return klass.cast(favoriteMap.get(klass));
    }
}
