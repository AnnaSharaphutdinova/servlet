package hometask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleWeb extends HttpServlet {
    Cookie biscuit = new Cookie("name", "0");

    private AtomicInteger count = new AtomicInteger(0);
    private List<String> innerState = new ArrayList<>();
    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);


    }
    @Override
    public void destroy() {
        System.out.println("Bye Then");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));

        req.setAttribute("count", count.toString());
        if (req.getParameter("ajax")!=null) {
            Cookie[] requsted  = req.getCookies();
            Cookie reqCook = null;
            for (Cookie cook : requsted) {
                if (cook.getName().equals("counter")) {
                    reqCook =cook;
                    break;
                }


            }
            if (reqCook != null) {
                reqCook.setValue(Integer.toString(Integer.parseInt(reqCook.getValue())+1));
                resp.getWriter().print("Cookie is incremented in get  ");
            }
            else
            {
               reqCook = new Cookie("counter", "0");
            }
            resp.addCookie(reqCook);

            biscuit.setValue(Integer.toString(Integer.parseInt(biscuit.getValue())+1));
            innerState.add("GET");
            resp.getWriter().print("THIS IS GET "+ biscuit.getValue()+"   ");
            resp.getWriter().print(innerState.toArray()[innerState.toArray().length-1]);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF\\jsp\\index.jsp");
            requestDispatcher.forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        req.setAttribute("count", count.toString());
        if (ajax) {
            Cookie[] requsted  = req.getCookies();
            Cookie reqCook = null;
            for (Cookie cook : requsted) {
                if (cook.getName().equals("counter")) {
                    reqCook =cook;
                    break;
                }


            }
            if (reqCook != null) {
                reqCook.setValue(Integer.toString(Integer.parseInt(reqCook.getValue())+1));
                resp.getWriter().print("Cookie is incremented in post ");
            }
            else
            {
                reqCook = new Cookie("counter", "0");
           }
            resp.addCookie(reqCook);

            innerState.add("POST");
            biscuit.setValue(Integer.toString(Integer.parseInt(biscuit.getValue())+1));
            resp.getWriter().print("THIS IS POST "+biscuit.getValue()+"   ");
           resp.getWriter().print(innerState.toArray()[innerState.toArray().length-1]);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF\\jsp\\index.jsp");
            requestDispatcher.forward(req,resp);

        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        req.setAttribute("count", count.toString());
        if (ajax) {
            Cookie[] requsted  = req.getCookies();
            Cookie reqCook = null;
            for (Cookie cook : requsted) {
                if (cook.getName().equals("counter")) {
                    reqCook =cook;
                    break;
                }


            }
            if (reqCook != null) {
                reqCook.setValue(Integer.toString(Integer.parseInt(reqCook.getValue())+1));
                resp.getWriter().print("Cookie is incremented in put ");
            }
            else
            {

                reqCook = new Cookie("counter", "0");

            }
            resp.addCookie(reqCook);
            innerState.add("PUT");
            biscuit.setValue(Integer.toString(Integer.parseInt(biscuit.getValue())+1));
            resp.getWriter().print("THIS IS PUT "+biscuit.getValue()+"  ");
            resp.getWriter().print(innerState.toArray()[innerState.toArray().length-1]);

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF\\jsp\\index.jsp");
            requestDispatcher.forward(req,resp);

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        req.setAttribute("count", count.toString());
        if (ajax) {
            Cookie[] requsted  = req.getCookies();
            Cookie reqCook = null;
            for (Cookie cook : requsted) {
                if (cook.getName().equals("counter")) {
                    reqCook =cook;
                    break;
                }


            }
            if (reqCook != null) {
                reqCook.setValue(Integer.toString(Integer.parseInt(reqCook.getValue())+1));
                resp.getWriter().print("Cookie is incremented in delete");
            }
            else
                {

                reqCook = new Cookie("counter", "0");

            }
            resp.addCookie(reqCook);

            innerState.add("DELETE");
            biscuit.setValue(Integer.toString(Integer.parseInt(biscuit.getValue())+1));
            resp.getWriter().print("THIS IS DELETE "+biscuit.getValue()+"   ");
            resp.getWriter().print(innerState.toArray()[innerState.toArray().length-1]);

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF\\jsp\\index.jsp");
            requestDispatcher.forward(req,resp);

        }



    }
}
