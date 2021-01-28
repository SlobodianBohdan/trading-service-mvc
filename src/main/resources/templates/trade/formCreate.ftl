<#include "../include/header.ftl">
    <style>
        .containerForm{
            margin-top: 10%;
            margin-bottom: 10%;
        }
        .card{
        }
    </style>
<div class="containerForm">
    <div class="card mb-2">
        <div class="row justify-content-center mt-2">
            <form action="/trade/new" method="get" autocomplete="off">
                <h3 class="text-center font-italic font-weight-bold font-family">New Trade</h3>
                <div class="col-12 block pt-2" style="">
                    <table class="table table-hover">
                        <tr>
                            <th class="align-middle col-md-12" scope="row">Currency Pair:</th>
                            <td class="td-padding">
                                <input name="currencyPair" type="text"/>
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
                            <th class="align-middle col-md-12" scope="row">Media Links:</th>
                            <td class="td-padding">
                                <input name="mediaLinks" type="url">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <fieldset class="row justify-content-center tm-10 ">
                        <button name="Submit" type="submit" class="col-4 btn btn-primary text-center submitBtn" data-submit="...Sending">
                            Create
                        </button>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
<#include "../include/footer.ftl">