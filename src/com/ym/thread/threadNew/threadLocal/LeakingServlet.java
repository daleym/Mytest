package com.ym.thread.threadNew.threadLocal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LeakingServlet {

	private static MyThreadLocal myThreadLocal = new MyThreadLocal();

    protected void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {

            MyCounter counter = myThreadLocal.get();
            if (counter == null) {
                    counter = new MyCounter();
                    myThreadLocal.set(counter);
            }

            response.getWriter().println(
                            "The current thread served this servlet " + counter.getCount()
                                            + " times");
            counter.increment();
    }
	
}
