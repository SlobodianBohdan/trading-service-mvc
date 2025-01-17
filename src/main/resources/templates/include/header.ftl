<#include "../include/coreDependencies.ftl">
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]/>

<html>
<style>
    *{
        margin: 0;
        padding: 0;
        list-style: none;
    }
    body{
        font-family: 'Open Sans', sans-serif;
        flex-direction: column;
        display: flex;
        min-height: 100vh;
    }

    .aHeader{
        text-decoration: none;
    }
    .header{
        width: 100%;
        background: #000;
        display: flex;
        justify-content: center;
    }
    .header_logo{
        text-transform: uppercase;
        color: #fff;
        font-weight: 600;
        font-size: 24px;
        cursor: pointer;
        margin-right: 20%;
        margin-top: 20px;


    }

    .navHeader{
        margin-top: 23px;
        margin-left: 23%;
    }
    .top_nav a{
        color: #fff;
        text-align: center;
        padding: 12px 16px;
        font-size: 14px;
        font-weight: bold;

    }
    .top_nav .icon{
        display: none;
    }
    .buttonLogOut{
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: center;
    }



    @media screen and (max-width: 1200px){
        .navHeader{
            margin-left: 20%;
        }
    }
    @media screen and (max-width: 1105px){
        .navHeader{
            margin-left: 10%;
        }
    }
    @media screen and (max-width: 1010px) {
        .top_nav a {
            display: none;
        }

        .top_nav a.icon {
            float: right;
            margin-top: -17px;
            display: block;
            color: #fff;
            font-size: 25px;
        }

        .navHeader {
            width: 100%;
        }

        .top_nav.responsive a.icon {
            position: absolute;
            top: -50px;
            right: -200px;
        }

        .top_nav.responsive a {
            float: none;
            display: block;
            text-align: center;
        }
    }


</style>

    <header class="header">
        <div class="header_logo">
            <p>Ihor Trade</p>
        </div>
        <nav class="navHeader">
            <div class="top_nav" id="myTopNav">
                <a class="aHeader" href="/">Home</a>
                <a class="aHeader" href="/trade/list">Trades</a>
                <a class="aHeader" href="/trade/archive">Archive</a>
<#--                <a class="aHeader" href="#">Fond</a>-->
                <a class="aHeader" href="/trade/progress">Progress</a>
                <a id="menu" class="icon">&#9776;</a>
            </div>
        </nav>
        <@sec.authorize access="isAuthenticated()">
            <form class="buttonLogOut" action="/trade/admin/logout" method="post" autocomplete="off">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">LogOut</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </@sec.authorize>
    </header>
<body>


