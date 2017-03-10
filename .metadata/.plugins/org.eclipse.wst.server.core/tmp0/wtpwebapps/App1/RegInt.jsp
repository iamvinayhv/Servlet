<jsp:useBean id="reg" class="com.RegisterServlet" scope="request">
  <jsp:setProperty name="reg" property="*"/>
  
  </jsp:useBean>
  <jsp:forward page="/process"/>