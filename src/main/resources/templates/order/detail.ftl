<html>
<#include "../common/header.ftl">
<body>

<div  id="wrapper" class="toggled">
    <#--            边栏-->
    <#include "../common/nav.ftl">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-4 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>订单详情</th>
                        <th>订单总金额 </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.orderAmount}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>商品Id</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>总额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDTO.orderDetailList as orderDetail>
                        <tr>
                            <th>${orderDetail.productId}</th>
                            <th>${orderDetail.productName}</th>
                            <th>${orderDetail.productPrice}</th>
                            <th>${orderDetail.productQuantity}</th>
                            <th>${orderDetail.productPrice * orderDetail.productQuantity}</th>
                        </tr>
                    </#list>

                    </tbody>
                </table>
            </div>

            <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message= "新订单">
                    <a type="button" class="btn btn-default btn-primary" href="finish?orderId=${orderDTO.orderId}">完结订单</a>
                    <a type="button" class="btn btn-default btn-danger" href="cancel?orderId=${orderDTO.orderId}">取消订单</a>
                </#if>

            </div>
        </div>
    </div>
</div>


</body>
</html>