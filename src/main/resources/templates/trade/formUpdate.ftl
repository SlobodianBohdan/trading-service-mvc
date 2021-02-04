<#include "../include/header.ftl">
<style>
    .container{
        margin-top: 3%;
        margin-bottom: 3%;
    }
    fieldset.scheduler-border {
        text-align: center;
        align-items: center;
        justify-content: center;
        border: 1px groove #ddd !important;
        padding: 0.5em 0.5em 0.3em 0.5em !important;
        margin: 0 0 0.5em 0 !important;
        -webkit-box-shadow:  0 0 0 0 #000;
        box-shadow:  0 0 0 0 #000;
    }

    label.scheduler-border {
        font-size: 1em !important;
        font-weight: bold !important;
        text-align: left !important;
        margin-left: 0;
    }
    .inputValue{
        width: 60%;
    }
    .btnUpdate{
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: center;
    }
    .btnGoBack{
        padding-right: 10px;
    }
    .alert{
        margin-top: 3%;
    }

</style>
<div class="container">
    <#if message??>
        <div class="alert alert-success" role="alert" id="dangerAlert">
            ${message}
        </div>
    </#if>
    <div class="card mb-2">
        <div class="row justify-content-center">
            <form action="/trade/admin/update" method="post" autocomplete="off">
                <h3 class="text-center font-italic font-weight-bold font-family">Update Trade</h3>
                <div class="col-12 block pt-5">
                    <table class="table table-hover mb-0">
                        <tbody>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Id:
                                    <input class="text-center" type="text" name="id" value="${trade.id}" readonly>
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Currency Pair:
                                    <input type="text" name="currencyPair" value="${trade.currencyPair}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Buy Price:
                                    <input type="text" name="buyPrice" value="${trade.buyPrice}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Stop-Limit:
                                    <input type="text" name="stopLimit" value="${trade.stopLimit}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Targets:
                                    <input type="text" name="targets" value="${trade.targets}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Expected Result:
                                    <input type="text" name="expectedResult" value="${trade.expectedResult}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border" scope="row">Trade Type:</label>
                                <select class="inputValue" name="tradeType" required>
                                    <option name="tradeType">${trade.tradeType}</option>
                                    <option>LONG</option>
                                    <option>SHORT</option>
                                </select>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border" scope="row">Trade Time:</label>
                                <select class="inputValue" name="tradeTime" required>
                                    <option name="tradeTime" >${trade.tradeTime}</option>
                                    <option>SHORT_TERM</option>
                                    <option>MEDIUM_TERM</option>
                                    <option>LONG_TERM</option>
                                </select>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Description:
                                    <input type="text" name="description" value="${trade.description}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Media Link:
                                    <input type="url" name="mediaLink" value="${trade.mediaLink}">
                                </label>
                            </fieldset>
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Created Date:
                                    <input type="text" value="${trade.createdDate}">
                                </label>
                            </fieldset >
                            <fieldset class="scheduler-border">
                                <label class="scheduler-border">Updated Date:
                                    <input type="text" value="${trade.updatedDate}">
                                </label>
                            </fieldset>
                        </tbody>
                            <fieldset class="btnUpdate justify-content-center tm-10">
                                <div class="btnGoBack">
                                    <a class="btn btn-success" href="/trade/info/${trade.id}" >Go Back</a>
                                </div>
                                <button name="Submit" type="submit" class="btn btn-warning" data-submit="...Sending">
                                    Update
                                </button>
                            </fieldset>
                    </table>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>

</div>
<script>
    //alert closing
    setTimeout(function () {
        $('#dangerAlert').alert('close');
    }, 5000);
</script>
<#include "../include/footer.ftl">