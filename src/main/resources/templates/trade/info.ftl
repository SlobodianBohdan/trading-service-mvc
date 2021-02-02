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
                    <div class="col-11 block">
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
                                <td class="td-padding">${trade.expectedResult}%</td>
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
            <#if trade.tradeStatus == "ACTIVE">
            <!-- Trigger the modal with a button -->
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">In Archive</button>
            </#if>
            <form class="rowButton ml-1" action="/trade/delete/${trade.id}" method="post" autocomplete="off">
                <button class="btn btn-dark text-center" type="submit" >Delete</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>

    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Expected Result</h4>
                </div>
                <form action="/trade/archive/${trade.id}" method="post" autocomplete="off">
                        <table class="table table-hover">
                            <tr>
                                <th class="align-middle col-md-7" scope="row">Expected Result:</th>
                                <td class="td-padding">
                                    <label>
                                        <input name="expectedResult" type="text" value="${trade.expectedResult}">
                                    </label>
                                </td>
                            </tr>
                        </table>
                        <fieldset class="row justify-content-center">
                            <button name="Submit" type="submit" class="btn btn-default" data-submit="...Sending">
                                In Archive
                            </button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </div>
</main>
<#include "../include/footer.ftl">