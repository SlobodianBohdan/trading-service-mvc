<#include "../include/header.ftl">
<style>
    .container{
        margin-top: 3%;
    }
    .btnInfo{
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: center;
    }
    .rowButton{
        margin: 10px 10px 10px 10px;
    }
</style>
<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="card mb-2">
                <div class="row justify-content-center">
                    <div class="col-9 block">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                <#if trade.mediaLink??>
                                    <img class="card-img-top card-item-img" src="${trade.mediaLink}">
                                <#else>
                                    <img class="card-img-top card-item-img" src="https://pixy.org/src/120/1206832.jpg">
                                </#if>
                        </div>
                        <h4 class="card-title text-center">${trade.currencyPair}</h4>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-6 block pt-2">
                        <table class="table table-hover mb-2">
                            <tbody>
                            <tr>
                                <th class="align-middle" scope="row">Buy Price:</th>
                                <td class="td-padding">${trade.buyPrice}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Stop-Limit:</th>
                                <td class="td-padding">${trade.stopLimit}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Targets:</th>
                                <td class="td-padding">${trade.targets}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Expected Result:</th>
                                <td class="td-padding">${trade.expectedResult}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Trade Type:</th>
                                <td class="td-padding">${trade.tradeType}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Trade Status:</th>
                                <td class="td-padding">${trade.tradeStatus}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Trade Time:</th>
                                <td class="td-padding">${trade.tradeTime}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Description:</th>
                                <td class="td-padding " >${trade.description}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Created Date:</th>
                                <td class="td-padding">${trade.createdDate}</td>
                            </tr>
                            <tr>
                                <th class="align-middle" scope="row">Updated Date:</th>
                                <td class="td-padding " >${trade.updatedDate}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div class="btnInfo">
            <a href="/trade/list" class="rowButton ml-1">
                <button class="btn btn-success text-center" type="submit">Go Back</button>
            </a>
            <a href="/trade/formUpdate/${trade.id}" class="rowButton ml-1">
                <button class="btn btn-warning text-center" type="submit">Update trade</button>
            </a>
            <a href="/trade/delete/${trade.id}" class="rowButton ml-1" >
                <button class="btn btn-danger text-center" type="submit" >Delete</button>
            </a>
        </div>
    </div>
</main>
<#include "../include/footer.ftl">