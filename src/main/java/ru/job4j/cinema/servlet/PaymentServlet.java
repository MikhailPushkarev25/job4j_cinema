package ru.job4j.cinema.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.storage.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Ticket ticket = GSON.fromJson(req.getReader(), Ticket.class);
        req.setCharacterEncoding("UTF-8");
        String result = PsqlStore.instOf().createTicket(ticket) ? "success" : "fail";
        resp.getWriter().print(result);
    }
}
