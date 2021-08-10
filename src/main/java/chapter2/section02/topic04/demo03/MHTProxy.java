package chapter2.section02.topic04.demo03;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/8/7 15:26
 */
public class MHTProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(MHTClassLoader classLoader, Class<?>[] interfaces, MHTInvocationHandler h) {
        try {
            // 动态生成源代码.java文件
            String src = generateSrc(interfaces);
            // java文件保存到磁盘
            String filePath = MHTProxy.class.getResource("").getPath();
            File f = new File(filePath+"$Proxy0.java");
            FileWriter fw = new FileWriter(f);;
            fw.write(src);
            fw.flush();
            fw.close();
            // 生成的java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            // 把编译生成的.class文件加载到JVM中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MHTInvocationHandler.class);
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package chapter2.section02.topic04.demo03;" + ln);
        sb.append("import chapter2.section02.topic04.demo01.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
            sb.append("MHTInvocationHandler h;" + ln);
            sb.append("public $Proxy0(MHTInvocationHandler h) { ");
                sb.append("this.h = h;" );
            sb.append(" }" + ln);
            // 获取需实现接口的所有方法
            for (Method m : interfaces[0].getMethods()) {
                Class<?>[] params = m.getParameterTypes();
                StringBuffer paramNames = new StringBuffer();// 参数名： 类型 + 名字
                StringBuffer paramValues = new StringBuffer();// 参数名：名字
                StringBuffer paramClasses = new StringBuffer();// 参数的类型
                for (int i = 0; i < params.length; i++) {
                    Class clazz = params[i];
                    String type = clazz.getName();
                    String paramName = toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramValues.append(paramName);
                    paramClasses.append(clazz.getName() + ".class");
                    if (i > 0 && i < params.length - 1) {
                        paramNames.append(",");
                        paramValues.append(",");
                        paramClasses.append(",");
                    }
                }
                // 生成实现方法的代码
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames + ") {" + ln);
                sb.append("try { " + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\""+ m.getName() +  "\", new Class[]{" + paramClasses + "});" + ln);
                sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") +
                        getCaseCode("this.h.invoke(this, m, new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
                sb.append("} catch(Error _ex) { }" + ln);
                sb.append("catch(Throwable throwable) {" + ln);
                sb.append(" throw new UndeclaredThrowableException(throwable); }}");
            }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static Map<Class, Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static String getReturnEmptyCode( Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }
}
