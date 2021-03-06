package com.zhiye.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.morphia.query.Query;
import com.zhiye.dao.QuestionDAO;
import com.zhiye.model.Question;
import com.zhiye.util.DB;

/**
 * @author TeaInCoffee
 *lastUpdatedAt:20:50 2011-05-24
 */
public class ViewAllQuestionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        QuestionDAO qdao = new QuestionDAO(DB.morphia, DB.mongo);
        Query<Question> query = qdao.createQuery().order("-createdAt");
        List<Question> questions = query.asList();
        req.setAttribute("questions", questions);
        req.setAttribute("title", "所有问题");
        req.getRequestDispatcher("questions.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
