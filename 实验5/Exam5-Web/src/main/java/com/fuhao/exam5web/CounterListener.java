package com.fuhao.exam5web;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class CounterListener implements HttpSessionListener {

    public static int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("sessionCreated:" + se.getSession().getId());
    }


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
    }
}
