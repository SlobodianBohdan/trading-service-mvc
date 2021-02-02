<#include "../include/header.ftl">
<#assign pageSubmissionUrl = currencyPair???then('&currencyPair=${currencyPair}','') >

<style>
    .btnCreate {
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: center;
        margin-top: 2%;
        margin-bottom: 2%;
    }

    .alert {
        margin-top: 3%;
    }
</style>
<main>
    <div class="container">
        <div class="btnCreate">
            <a class="btn btn-warning" href="/trade/formCreate" role="button">Create New Trade</a>
        </div>
        <#if message??>
            <div class="alert alert-success" role="alert" id="dangerAlert">
                ${message}
            </div>
        </#if>

        <#if trades.totalPageNumber != 0 >
            <div class="row">
                <div class="input-group col text-center">
                    <form action="/trade/findList" class="form-inline mx-auto">
                        <#if currencyPair??>
                            <a href="/trade/list" class="btn btn-secondary m-1">Reset</a>
                        </#if>
                        <input name="currencyPair" type="text" class="form-control" placeholder="Currency Pair"
                               <#if trades.currencyPair??>value="${trades.currencyPair}"</#if>
                               aria-label="Currency Pair" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-info" type="submit">Search</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row justify-content-center" id="tradeList">
                <#list trades.content as trade>
                    <div class="col-4 clearfix d-none d-md-block mt-4">
                        <div class="card mb-2 zoom">
                            <a href="/trade/info/${trade.id}">
                                <#if trade.mediaLink??>
                                    <img class="card-img-top card-item-img" src="${trade.mediaLink}" alt="mediaLinkPhoto">
                                <#else>
                                    <img class="card-img-top card-item-img" src="https://pixy.org/src/120/1206832.jpg" alt="additionalPhoto">
                                </#if>
                            </a>
                            <div class="card-body">
                                <h4 class="card-title">${trade.currencyPair}</h4>
                                <p class="card-text">Buy Price: ${trade.buyPrice}</p>
                                <p class="card-text">Stop-Limit: ${trade.stopLimit}</p>
                                <p class="card-text">Targets: ${trade.targets}</p>
                                <p class="card-text">Trade Type: ${trade.tradeType}</p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
            <#if trades.totalPageNumber gt 1 >
                <div class="row justify-content-center">
                    <ul class="pagination">
                        <li class="page-item  <#if !trades.hasPreviousPage >disabled</#if>">
                            <a class="page-link" href="?page=${trades.currentPageNumber - 1}${pageSubmissionUrl}" tabindex="-1">Previous</a>
                        </li>
                        <#list 1..trades.totalPageNumber as pageNumber>
                            <li class="page-item <#if trades.currentPageNumber == pageNumber>active</#if>">
                                <a class="page-link" href="?page=${pageNumber}${pageSubmissionUrl}">${pageNumber}</a>
                            </li>
                        </#list>
                        <li class="page-item <#if !trades.hasNextPage >disabled</#if>">
                            <a class="page-link" href="?page=${trades.currentPageNumber + 1}${pageSubmissionUrl}" tabindex="-1">Next</a>
                        </li>
                    </ul>
                </div>
            </#if>
        <#else>
            <h1 class="text-center font-italic font-weight-bold font-family text-primary">THERE ARE CURRENTLY NO ACTIVE TRADES.</h1>
        </#if>
    </div>
</main>
<script>
    //alert closing
    setTimeout(function () {
        $('#dangerAlert').alert('close');
    }, 5000);
</script>
<#include "../include/footer.ftl">