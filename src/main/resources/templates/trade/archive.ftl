<#include "../include/header.ftl">
<style>
    .archive{
        margin-left: 7%;
        margin-right: 7%;
    }
</style>
<main>
    <h1 class="text-center font-italic font-weight-bold font-family">Archive Trades!</h1>
<#--    <div class="row">-->
<#--        <div class="input-group col text-center">-->
<#--            <form action="/trade/find" class="form-inline mx-auto">-->
<#--                <#if currencyPair??>-->
<#--                    <a href="/trade/archive" class="btn btn-secondary m-1">Reset</a>-->
<#--                </#if>-->
<#--                <input name="name" type="text" class="form-control" placeholder="Currency Pair"-->
<#--                       <#if trades.currencyPair??>value="${trades.currencyPair}"</#if>-->
<#--                       aria-label="Currency Pair" aria-describedby="basic-addon2">-->
<#--                <div class="input-group-append">-->
<#--                    <button class="btn btn-info" type="submit">Search</button>-->
<#--                </div>-->
<#--            </form>-->
<#--        </div>-->
<#--    </div>-->
    <div class="archive">
        <table border="1" class="table <#if trades??>table <#else> table-dark </#if>">
            <thead class="<#if trades??>thead-dark <#else> thead </#if>">
            <tr class="d-flex">
                <th scope="col" class="col-1">ID</th>
                <th scope="col" class="col-2">Currency Pair</th>
                <th scope="col" class="col-1">Buy Price</th>
                <th scope="col" class="col-1">Stop-Limit</th>
                <th scope="col" class="col-1">Targets</th>
                <th scope="col" class="col-1">Trade Type</th>
                <th scope="col" class="col-2">Created Date</th>
                <th scope="col" class="col-1">Expected Result</th>
                <th scope="col" class="col-2">Result</th>
            </tr>
            </thead>
            <tbody>
                <#list trades.content as trade>
                    <tr class="d-flex">
                        <th scope="row" class="col-1">${trade.id}</th>
                        <td class="col-2"><a href="/trade/info/${trade.id}">${trade.currencyPair}</a></td>
                        <td class="col-1">${trade.buyPrice}</td>
                        <td class="col-1">${trade.stopLimit}</td>
                        <td class="col-1">${trade.targets}</td>
                        <td class="col-1">${trade.tradeType}</td>
                        <td class="col-2">${trade.createdDate}</td>
                        <td class="col-1">${trade.expectedResult}</td>
                        <#if trade.tradeStatus == "COMPLETED_PLUS">
                            <th class="col-2 text-center">
                                <button class="btn btn-success"  disabled>+</button>
                            </th>
                        <#elseif trade.tradeStatus == "COMPLETED_MINUS">
                            <th class="col-2 text-center" >
                                <button class="btn btn-danger" disabled>-</button>
                            </th>
                        </#if>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>

    <div class="row justify-content-center">
        <ul class="pagination">
            <li class="page-item  <#if !trades.hasPreviousPage >disabled</#if>">
                <a class="page-link" href="?page=${trades.currentPageNumber - 1}" tabindex="-1">Previous</a>
            </li>
            <#list 1..trades.totalPageNumber as pageNumber>
                <li class="page-item <#if trades.currentPageNumber == pageNumber>active</#if>">
                    <a class="page-link" href="?page=${pageNumber}">${pageNumber}</a>
                </li>
            </#list>
            <li class="page-item <#if !trades.hasNextPage >disabled</#if>">
                <a class="page-link" href="?page=${trades.currentPageNumber + 1}" tabindex="-1">Next</a>
            </li>
        </ul>
    </div>
</main>
<#include "../include/footer.ftl">