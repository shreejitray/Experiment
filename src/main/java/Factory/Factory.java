package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by schaud3 on 1/16/18.
 */
public class Factory {
    public static<T extends Dummy> T factory(Class<T> type) throws IllegalAccessException, InstantiationException {
        T object = type.newInstance();
        return object;
    }

    public static void main(String[] args) {
        try {
            Constructor<Dummy> constructor = Dummy.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Dummy dummy = constructor.newInstance();
            dummy.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
