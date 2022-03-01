<%@ page import="java.sql.*" %>
<%@ page import="utility.ConnectionManager" %>

<%
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    Statement st = con.createStatement();
    
    ResultSet rs = st.executeQuery("select * from gadgets");
%>
<html>
    <head>
        <script language="javascript">
            function edit(){
                document.getElementById('title').value=document.getElementsByTagName('td')[1].innerText;
                document.getElementById('price').value=document.getElementsByTagName('td')[2].innerText;
                document.getElementById('url').value=document.getElementsByTagName('td')[0].innerText;
                document.getElementById('quantity').value=document.getElementsByTagName('td')[3].innerText;
                document.getElementById('details').value=document.getElementsByTagName('td')[4].innerText;
                
            }


function deleteRow(r) {
  var i = r.parentNode.parentNode.rowIndex;
  document.getElementById("myTable").deleteRow(i);
}
        </script>
        <style type="text/css">
        .column {
    float: left;
    width: 50%;
  }
  
  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }
        </style>
    </head>
<body>
<div class="row">
    <div class="column">
        <table id="myTable" border="1" cellspacing="2" cellpadding="2">
            <tr>
                <th>
                    Gadget
                </th>
                <th>
                    Title
                </th>
                <th>
                    Price
                </th>
                <th>
                    Quantity
                </th>
                <th>
                    Details
                </th>
        <%
            while(rs.next())
            {
        %>
            </tr>
             <tr id="trr">          
                       
                        <td id="uu"><img src='<%=rs.getString(4)%>' width=100 height=100></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getFloat(3)%></td>
                        <td><%=rs.getInt(5)%></td>
                        <td><%=rs.getString(6)%></td>
                       
                        <td><button name="edit" onclick="edit('<%=rs.getInt(1)%>')">Edit</button></td>
                        <td><button name="delete" onclick="deleteRow(this)">Delete</button></td>
                        
                    </tr>
              
        <%
            }
        %>
        </table>
        
    </div>
    <div class="column">
        <h1>Edit/Delete Cover</h1>
        <table>
            <tr>
         <td> Title:  </td>  <td> <input type="text" id="title" size="60"/> </td> <br>
         </tr>
         <tr>
        <td>  Price: </td>  <td>  <input type="text" id="price" size="60"/> </td><br>
    </tr>
    <tr>
        <td>Image URL:  </td>  <td> <input type="text" id="url" size="60"/> </td><br>
    </tr>
    <tr>
        <td>Quantity:</td>  <td>  <input type="text" id="quantity" size="60"/> </td> <br>
    </tr>
    <tr>
        <td>Details:</td>  <td>  <input type="text" id="details" size="60"/> </td> <br>
    </tr>
    <tr>
        <td><button value="Update">Update</button></td>
        <td><button value="delete" onclick="deleteRow(this)">Delete</button></td>
        </tr>
    </table>
    </div>
  </div>
</body>
</html>