<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp" %>
<div class="container" style="margin-top: 50px;">
    <div class="row">
        <form action="app.do" method="post" style="padding: 30px; border-radius: 10px;" class="col s6 offset-s3 z-depth-3">
            <h3 class="green-text center">Inicio de Sesión</h3>
            <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input class="validate" type="text" name="txt1" id="txt1" value="${param.txt1}" placeholder="Ingrese su nombre">
                <label for="txt1">Nombre:</label>
            </div>
            <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input class="validate" type="password" name="txt2" value="${param.txt2}" id="txt2" placeholder="Ingrese su contraseña">
                <label for="txt1">Contraseña:</label>
            </div>
            <div class="input-field col s12">
                <a class="btn waves-effect waves-light yellow green-text" href="index.jsp">
                <i class="material-icons left">undo</i>Volver al Menu</a>
                <button class="btn waves-effect waves-light blue" 
                        type="submit" name="enviar" value="login">Iniciar
                    <i class="material-icons right">send</i>
                </button>
            </div>
            <c:if test="${not empty errores}">
                <div style="color: red;">
                    ${errores}
                </div>
            </c:if>
            <c:if test="${not empty success}">
                <div style="color: green">
                    <strong>${success}</strong>
                    <br>${success2}
                </div>
                
            </c:if>
                
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>