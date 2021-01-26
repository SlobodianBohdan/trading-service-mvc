<#include "../include/header.ftl">
    <style>
        .btnCreate{
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
        }
    </style>
<main>

        <div class="btnCreate">
            <a class="btn btn-warning" href="/trade/formCreate" role="button">Create New Trade</a>
        </div>
<#--    <#if animals.content[0].animalStatus == "FREE">-->
<#--        <h1 class="text-center font-italic font-weight-bold font-family">Не купуй - візьми!</h1>-->
<#--    <#elseif animals.content[0].animalStatus == "TREATMENT">-->
<#--        <h1 class="text-center font-italic font-weight-bold font-family">Нам потрібна ваша підтримка!</h1>-->
<#--    </#if>-->

<#--    <#if trades.totalPageNumber != 0 >-->
        <#if trades?size!=0 >
            <div class="row justify-content-center" id="tradeList">
                <#list trades as trade>
                    <div class="col-4 clearfix d-none d-md-block mt-5">
                        <div class="card mb-2 zoom">
                            <a href="/trade/${trade.id}">
                                <#if trade.mediaLinks??>
                                    <img class="card-img-top card-item-img" src="${trade.mediaLinks}">
                                <#else>
                                    <img class="card-img-top card-item-img" src="https://pixy.org/src/120/1206832.jpg">
                                </#if>
                            </a>
                            <div class="card-body">
                                <h4 class="card-title">${trade.currencyPair}</h4>
                                <p class="card-text">${trade.description}</p>
    <#--                            <#if trade.tradeStatus == "ACTIVE">-->
    <#--                                <a href="/orders/new/${trade.id}" class="row justify-content-center">-->
    <#--                                    <button class="col-8 btn btn-primary text-center" type="submit">Створити замовлення</button>-->
    <#--                                </a>-->
    <#--                            <#elseif trade.tradeStatus == "TREATMENT">-->
    <#--                            &lt;#&ndash;Make payment by means of googlePay&ndash;&gt;-->
    <#--                                <a href="/" class="row justify-content-center">-->
    <#--                                    <button class="col-8 btn btn-primary text-center" type="submit">Пожертвувати</button>-->
    <#--                                </a>-->
    <#--                            </#if>-->
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        <#else>
            <h1 class="text-center font-italic font-weight-bold font-family text-primary">THERE ARE CURRENTLY NO ACTIVE TRADES.</h1>
        </#if>


<#--        <div class="row justify-content-center">-->
<#--            <ul class="pagination">-->
<#--                <li class="page-item  <#if !animals.hasPreviousPage >disabled</#if>">-->
<#--                    <a class="page-link" href="?page=${animals.currentPageNumber - 1}" tabindex="-1">Previous</a>-->
<#--                </li>-->
<#--                <#list 1..animals.totalPageNumber as pageNumber>-->
<#--                    <li class="page-item <#if animals.currentPageNumber == pageNumber>active</#if>">-->
<#--                        <a class="page-link" href="?page=${pageNumber}">${pageNumber}</a>-->
<#--                    </li>-->
<#--                </#list>-->
<#--                <li class="page-item <#if ! animals.hasNextPage >disabled</#if>">-->
<#--                    <a class="page-link"  href="?page=${animals.currentPageNumber + 1}" tabindex="-1">Next</a>-->
<#--                </li>-->
<#--            </ul>-->
<#--        </div>-->
<#--    </#if>-->



</main>

<#include "../include/footer.ftl">