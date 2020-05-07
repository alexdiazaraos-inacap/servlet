<%@include file="template/header.jsp" %>
<div class="container" style="margin-top: 50px;">
    <div class="row">
        <form action="app.do" method="post" style="padding: 30px; border-radius: 10px;" class="col s6 offset-s3 z-depth-3">
            <h3 class="green-text">Cálculo Descuento</h3>
            <div class="row">
                <div class="input-field col s6">
                    <i class="material-icons prefix">monetization_on</i>
                    <input class="validate" type="text" name="precio" id="precio" value="${param.precio}" placeholder="Ingrese el precio">
                    <label for="precio">Precio:</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">monetization_on</i>
                    <select name="descuento">
                        <option value="">Seleccione descuento</option>
                        <option ${param.descuento=='0.1'?'selected':''} value="0.1">10%</option>
                        <option ${param.descuento=='0.2'?'selected':''} value="0.2">20%</option>
                        <option ${param.descuento=='0.3'?'selected':''} value="0.3">30%</option>
                        <option ${param.descuento=='0.4'?'selected':''} value="0.4">40%</option>
                    </select>
                    <label for="descuento">Descuento:</label>
                </div>
                <div class="input-field col s12">
                    <a class="btn waves-effect waves-light yellow green-text" href="index.jsp">
                        <i class="material-icons left">undo</i>Volver al Menu</a>
                        <button class="btn waves-effect waves-light blue" 
                                type="submit" name="enviar" value="calcular">Calcular
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
                        ${success}
                    </div>
                </c:if>
            </div>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>