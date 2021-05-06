<#include "../include/header.ftl">

<style>
    .main {
        display: flex;
        flex-direction: column;
        width: 100%;


    }

    .main .main_welcome {
        background: #FBE5CD;
        text-align: center;
        padding: 250px 0 300px 0;
    }

    .main_welcome p {
        color: #999999;
        font-size: 20px;
    }

    .main .main_welcome h1 {
        color: #000;
        font-size: 44px;
    }

    .main .main_welcome h1:after {
        display: none;
    }

    .myCompany {
        color: #fcac45
    }

    .wrapper {
        width: 76%;
        margin: 0 auto;
    }

    .main .main_about {
        display: flex;
        padding: 100px 0 100px 0;
        justify-content: center;
    }

    .about_right {
        margin-left: 175px;
    }

    .about_right h1 {
        display: inline-block;
        border-bottom: 3px solid #fcac45;
        padding-bottom: 20px;
    }

    .about_right h1:after {
        display: none;
    }

    .about_right p {
        margin: 30px 0 50px 0;
        color: #6c6c6c;
    }

    .about_right .liHome {
        background: url(https://img.icons8.com/material-sharp/24/000000/bitcoin.png) 0px no-repeat;
        padding-left: 35px;
        margin-top: 10px;
        color: #5c5c5c;
    }

    .mw-100 {
        min-width: 100%;
    }

    .liHome {
        list-style: none;
    }

    .listCrypto {
        margin-left: 10%;
        width: 80%;
    }

</style>

<main class="main">
        <div class="main_welcome">
            <h1>WELCOME TO <span class="myCompany">MY TRADING PLATFORM</span></h1>
            <p>This platform is really cool!</p>
        </div>

        <div class="wrapper">
            <div class="main_about">
                <div class="about_left">
                    <img class="mw-100"
                         src="https://img.freepik.com/free-vector/bitcoin-golden-logo_48369-12177.jpg?size=338&ext=jpg"
                         alt="bitcoin">
                </div>
                <div class="about_right">
                    <h1>SOME WORDS ABOUT US</h1>
                    <p>This company is really cool!</p>
                    <ul>
                        <li class="liHome">This company is excellent!</li>
                        <li class="liHome">This company is excellent!</li>
                        <li class="liHome">This company is excellent!</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="coinMarketUrl">
            <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/coinMarquee.js"></script>
            <div class="listCrypto" id="coinmarketcap-widget-marquee" coins="1,1027,52,2,1831" currency="USD" theme="dark" transparent="false" show-symbol-logo="true">
            </div>
        </div>
</main>


<#include "../include/footer.ftl">