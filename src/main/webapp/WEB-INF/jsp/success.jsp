<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.proyecto.Jakarton.DAO.*" %>
<%@ page import="com.proyecto.Jakarton.sopa.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>

<%! ArrayList<Palabra> listaPalabras = null; %>

<%
    /*
    try {
        SQLConexion sqlConexion = new SQLConexion();
        sqlConexion.ConectarBasedeDatos();
        sqlConexion.DesconectarBasedeDatos();
        out.println("Paso inicial");
    } catch (Exception exception) {
        out.println(exception.toString());
    }
     */

    // SQL
    FactoriaDAO sqlDAOFactory = FactoriaDAO.getDAOFactory(FactoriaDAO.SQL);
    SQLUsuarioDAO usuarioDAO = (SQLUsuarioDAO) sqlDAOFactory.getUsuarioDAO();
    SQLPalabraDAO palabraDAO = (SQLPalabraDAO) sqlDAOFactory.getPalabraDAO();
    SQLJuegoDAO juegoDAO = (SQLJuegoDAO)sqlDAOFactory.getJuegoDAO();

    Juego juego = juegoDAO.getJuego();
    Palabra nuevaPalabra = null;
    String palabra = "";

    //listaPalabras = (ArrayList<Palabra>) palabraDAO.getPalabras().getListadoPalabras();
    juego.add(palabraDAO.getPalabras());

    listaPalabras = (ArrayList<Palabra>) juego.getPalabras().getListadoPalabras();

    if(listaPalabras == null) {
        palabra = "oca";
        nuevaPalabra = new Palabra(palabra, palabra.length(), 0, 0, 0);
        palabraDAO.crearElemento(nuevaPalabra);
        palabra = "flan";
        nuevaPalabra = new Palabra(palabra, palabra.length(), 1, 0, 0);
        palabraDAO.crearElemento(nuevaPalabra);
        palabra = "tuerca";
        nuevaPalabra = new Palabra(palabra, palabra.length(), 2, 0, 0);
        palabraDAO.crearElemento(nuevaPalabra);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <title>Sopa de Letras</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <style type="text/css">
        #sopa{
            margin: auto;

        }

        #contenedor{
            margin: auto;
            width: 410px;
            height: 410px;
            padding: 20px;
            border-radius: 10px;
            overflow: hidden;
        }

        .caja{
            margin: 3px;
            width: 45px;
            height: 45px;
            line-height: 45px;
            text-align: center;
            box-shadow: 0 0 5px rgba(0,0,0, 0.3);
            border-radius: 5px;
            float: left;
        }

        .resaltar{
            color: #fff;
            background-color: red;
        }
    </style>
</head>
<body>
<h3>Welcome ${username} </h3>

<div id="sopa">
    <div id="contenedor">
        <%

            if(listaPalabras != null) {
                String aux = listaPalabras.get(0).getPalabra().toUpperCase();
                out.println("<div class=\"caja " + aux.toLowerCase() + "\"><strong>" + aux.charAt(0) + "</strong></div>");
                out.println("<div class=\"caja " + aux.toLowerCase() + "\"><strong>" + aux.charAt(1) + "</strong></div>");
                out.println("<div class=\"caja " + aux.toLowerCase() + "\"><strong>" + aux.charAt(2) + "</strong></div>");
            }

        %>


        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>
        <div class="caja"><strong>A</strong></div>

    </div>
    <div>




        <script type="text/javascript">
            $(document).ready(function(){
                    $(".oca").hover(function(){
                            $(".oca").addClass("resaltar");
                        }
                    );

                    $(".oca").mouseleave(function(){
                            $(".oca").removeClass("resaltar");
                        }
                    );

                    $(".oca").click(function(){
                            $(".oca").css("color", "green");
                        }
                    );
                }
            );
        </script>
</body>
</html>
