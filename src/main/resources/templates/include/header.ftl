<#include "../include/coreDependencies.ftl">

<html>
<style>
    *{
        margin: 0;
        padding: 0;
        list-style: none;
    }
    body{
        font-family: 'Open Sans', sans-serif;
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
    /*.top_nav a:hover{*/
    /*    border-bottom: 3px solid #fcac45;*/
    /*}*/
    .top_nav .icon{
        display: none;
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
                <a class="aHeader" href="/trade/home">Home</a>
                <a class="aHeader" href="/trade/list">Trades</a>
                <a class="aHeader" href="#">Services</a>
                <a class="aHeader" href="#">Portfolio</a>
                <a class="aHeader" href="#">Testimonials</a>
                <a class="aHeader" href="#">Contact</a>
                <a id="menu" class="icon">&#9776;</a>
            </div>
        </nav>
    </header>
<body>


