<#include "../include/header.ftl">
    <style>
        .container{
            margin-top: 10%;
            margin-bottom: 10%;
        }
        .btnGoBack{
            padding-right: 10px;
        }
    </style>
<div class="container">
    <div class="card mb-2">
        <div class="row justify-content-center mt-2">
            <form action="/trade/new" method="post" autocomplete="off">
                <h3 class="text-center font-italic font-weight-bold font-family">New Trade</h3>
                <div class="col-12 block pt-2">
                    <table class="table table-hover">

                        <tr>
                            <th class="align-middle col-md-12" scope="row">Currency Pair:</th>
                            <td class="td-padding">
                                <input name="currencyPair" type="text" required/>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Buy Price:</th>
                            <td class="td-padding">
                                <input name="buyPrice" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Stop-Limit:</th>
                            <td class="td-padding">
                                <input name="stopLimit" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Targets:</th>
                            <td class="td-padding">
                                <input name="targets" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Expected Result:</th>
                            <td class="td-padding">
                                <input name="expectedResult" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Description:</th>
                            <td class="td-padding">
                                <input name="description" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Trade Type:</th>
                            <td class="td-padding">
                                <select class="select-program col-md-12" name="tradeType" required>
                                    <option name="tradeType" disabled selected>Trade Type</option>
                                    <option>LONG</option>
                                    <option>SHORT</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Trade Time:</th>
                            <td class="td-padding">
                                <select class="select-program col-md-12" name="tradeTime" required>
                                    <option name="tradeTime" disabled selected>Trade Time</option>
                                    <option>SHORT_TERM</option>
                                    <option>MEDIUM_TERM</option>
                                    <option>LONG_TERM</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Trade Status:</th>
                            <td class="td-padding">
                                <select class="select-program col-md-12" name="tradeStatus" required>
                                    <option name="tradeStatus" disabled selected>Trade Status</option>
                                    <option>ACTIVE</option>
                                    <option>COMPLETED_PLUS</option>
                                    <option>COMPLETED_MINUS</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Media Link:</th>
                            <td class="td-padding">
                                <input name="mediaLink" type="url">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <fieldset class="row justify-content-center tm-10 ">
                        <div class="btnGoBack">
                            <a class="btn btn-success" href="/trade/list" >Go Back</a>
                        </div>
                        <button name="Submit" type="submit" class="btn btn-warning" data-submit="...Sending">
                            Create
                        </button>
                    </fieldset>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>
<script>

</script>
<#include "../include/footer.ftl">