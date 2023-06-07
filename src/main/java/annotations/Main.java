package annotations;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker { // marker annotation
}

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{ // Single-Member Annotations
    int value(); // has only one member - we don't need to specify the name
}

@What(description = "class")
@MySingle(20)
public class Main {
    public static void main(String[] args) {
        myMeth("ee", 1);
    }

    @SneakyThrows
    @What(description = "kdfkjsdf")
    @MyAnno(str = "Annotation Example", val = 2)
    @MyMarker
    public static void myMeth(String str, int i) {
        Main ob = new Main();

        // Obtain the annotation of this method and display values

        // get a Class object that represents this class
        //Class<?> c = ob.getClass();
        Class<?> c = Main.class;
        // get a Method object that represents this method
        Method m = c.getMethod("myMeth", String.class, int.class);
        // get the annotation for this class
        MyAnno anno = m.getAnnotation(MyAnno.class);
        System.out.println(anno.str() + anno.val());

        Annotation[] mAnnotations = m.getAnnotations();
        Arrays.stream(mAnnotations).forEach(System.out::println);

        System.out.println();
        Annotation[] cAnnotations = c.getAnnotations();
        Arrays.stream(cAnnotations).forEach(System.out::println);

        System.out.println("==============");
        Main.check();

        if (c.isAnnotationPresent(MyMarker.class)) {
            System.out.println(MyMarker.class + " - marker on class");
        }
        if (m.isAnnotationPresent(MyMarker.class)) {
            System.out.println(MyMarker.class + " - marker on method");
        }

        System.out.println("=".repeat(100));
        System.out.println(c.getAnnotation(MySingle.class).value());

    }

    @What(description = "check description")
    public static void check() throws NoSuchMethodException {
        Class<?> check = Main.class;
        Annotation[] annotations = check.getAnnotations();
        Arrays.stream(annotations).forEach(p -> System.out.println(p.annotationType()));
        Method method = check.getMethod("check");
        What annotation = method.getAnnotation(What.class);
        System.out.println(annotation.description());
    }
}
