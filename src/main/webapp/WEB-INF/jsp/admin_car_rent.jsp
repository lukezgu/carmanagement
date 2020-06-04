<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent ${car.carId}</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body>
<jsp:include page="admin_main.jsp"></jsp:include>
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 25%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Rent ${car.carId}</h3>
        </div>
        <div class="panel-body">
            <form action="rentcardo.html?id=${car.carId}" method="post" id="rentcar" >
                <div class="input-group">
                    <span  class="input-group-addon">Plate number</span> <input type="text" readonly="readonly"
							class="form-control" name="carId" id="carId" value="${car.carId}">
					</div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">Customer ID</span>
                    <input type="text" class="form-control" name="customerId" id="customerId" placeholder="Customer Id" >
                </div>
                <br/>
                <input type="submit" value="Submit" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#rentcar").submit(function () {
                        if($("#carId").val()==''||$("#customerId").val()==''){
                            alert("Incomplete infomation");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
