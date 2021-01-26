<#include "../include/header.ftl">
<div class="container">
    <div class="card mb-2">
        <div class="row justify-content-center mt-2">
            <form action="/trade/new" method="get" autocomplete="off">
                <h3 class="text-center font-italic font-weight-bold font-family">New Trade</h3>
                <div class="col-14 block pt-5">
                    <table class="table table-hover mb-0">
                        <tbody>
                        <tr>
                            <th class="align-middle" scope="row">Currency Pair:</th>
                            <td class="td-padding">
                                <input name="currencyPair" placeholder=""
                                       type="text"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Description:</th>
                            <td class="td-padding">
                                <input name="description" placeholder="" value=""
                                       type="text" tabindex="4">
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Trade Type:</th>
                            <td class="td-padding">
                                <select class="select-program col-md-11" name="tradeType" required>
                                    <option name="tradeType" disabled selected>Trade Type</option>
                                    <option>LONG</option>
                                    <option>SHORT</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Trade Time:</th>
                            <td class="td-padding">
                                <select class="select-program col-md-11" name="tradeTime" required>
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
                                <select class="select-program col-md-11" name="tradeStatus" required>
                                    <option name="tradeStatus" disabled selected>Trade Status</option>
                                    <option>ACTIVE</option>
                                    <option>COMPLETED_PLUS</option>
                                    <option>COMPLETED_MINUS</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="align-middle" scope="row">Media Links:</th>
                            <td class="td-padding">
                                <input name="mediaLinks" placeholder="" value=""
                                       type="url" tabindex="5">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <fieldset class="row justify-content-center tm-10">
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