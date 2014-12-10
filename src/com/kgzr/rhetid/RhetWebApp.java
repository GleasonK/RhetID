/*
 * The temporary fifty retrieval service.
 */

package com.kgzr.rhetid;

import com.kgzr.rhetid.authors.Author;
import com.kgzr.rhetid.score.VectorScoring;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author GleasonK
 */

//@WebServlet("/upload")
@MultipartConfig
public class RhetWebApp extends HttpServlet {
    private OutputStreamWriter writer;


    public RhetWebApp() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        //Get File Part
        Part filePart   = request.getPart("file");

        //Create local File
        SimpleDateFormat date = new SimpleDateFormat("MMddyy-hhmmss");
        String dateTime = date.format(new Date());
        final String FILE_LOC = "/Users/GleasonK/NetBeansProjects/RhetID/logs/";

        //Input Stream for reading
        InputStream fileContent = filePart.getInputStream();
        InputStreamReader reader = new InputStreamReader(fileContent);

        File localFile = new File("/Users/GleasonK/NetBeansProjects/RhetID/logs/" + dateTime + ".txt");
        FileWriter fileWriter = new FileWriter(localFile);

        int data = reader.read();
        while (data != -1){
            char c = (char) data;
            fileWriter.write(c);
            data = reader.read();
        }
        fileWriter.close();
        System.out.println("Upload Complete");
        File file = new File("/Users/GleasonK/NetBeansProjects/RhetID/logs/" + dateTime + ".txt");
        Author userAnalysis = RhetIdApp.runWebApp(new Scanner(file));
        file.delete();
        Map<String,Double> authScores = VectorScoring.compareStats(userAnalysis.getVectorStat());

        String url = "/WEB-INF/JSP/results.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        request.setAttribute("userAnalysis", userAnalysis);
        request.setAttribute("authScores", authScores);
        rd.forward(request,response);
    }
}