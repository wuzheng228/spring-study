package chapter2.section02.topic06.demo03;

import chapter2.section02.topic05.demo02.MemberController;
import chapter2.section02.topic05.demo02.OrderController;
import chapter2.section02.topic05.demo02.SystemController;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76973 on 2021/8/8 10:47
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    public void  init() throws ServletException {
        try {
            Class<MemberController> memberControllerClass = MemberController.class;
            Handler handler = new Handler();
            handler.setController(memberControllerClass.newInstance());
            handler.setMethod(memberControllerClass.getMethod("getMemberById", String.class));
            handler.setUri("/web/getMemberById.json");
            handlerMapping.add(handler);
        } catch (Exception e) {

        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 每个url对应一个servlet
        String uri = request.getRequestURI();
        String mid = request.getParameter("mid");

        // 拿到servlet后通过url通过这个url找到对应的java方法
        Handler handle = null;
        for (Handler h : handlerMapping) {
            if (StringUtils.equals(uri, h.uri)) {
                handle = h;
                break;
            }
        }

        // 通过反射调用对应的Method
        Object obj = handle.getMethod().invoke(handle.getController(), request.getParameter("mid"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    class Handler {
        private Object controller;
        private Method method;
        private String uri;

        public Object getController() {
            return controller;
        }

        public Method getMethod() {
            return method;
        }

        public String getUri() {
            return uri;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
}
