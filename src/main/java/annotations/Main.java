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

@What(description = "class")
public class Main {
    public static void main(String[] args) {
        myMeth("ee",1);
    }
    @SneakyThrows
    @What(description = "kdfkjsdf")
    @MyAnno(str = "Annotation Example", val = 2)
    public static void myMeth(String str, int i){
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

    }
}
