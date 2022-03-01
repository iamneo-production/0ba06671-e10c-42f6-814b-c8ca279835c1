
<%@ page import="service.GadgetsDao" %>

<%
    GadgetsDao dao = new GadgetsDao();
    Gadgets g = dao.viewGadgetById(Integer.parseInt(request.getParameter("val")));
    out.println(g);
%>
