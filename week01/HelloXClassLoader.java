
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * 加载Hello.xlass
 *
 * @author Kelvin Chen
 * @date 2021-06-27 21:55:25
 */
public class HelloXClassLoader extends ClassLoader {

    public static void main(String[] args) {
        Class<?> helloClazz = null;
        try {
            helloClazz = new HelloXClassLoader().findClass("Hello");
            Method hello = helloClazz.getDeclaredMethod("hello");
            hello.invoke(helloClazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            File file = new File(getClass().getClassLoader().getResource("Hello.xlass").getPath());
            byte[] bytes = Files.readAllBytes(file.toPath());
            bytes = decode(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] decode(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
