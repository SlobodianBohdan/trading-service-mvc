<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    a{
        text-decoration: none;
    }
    li{
        list-style: none;
    }
    body{
        font-family: 'Open Sans', sans-serif;
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
        font-weight: 800;
        font-size: 24px;
        cursor: pointer;
        margin-right: 20%;
        margin-top: 20px;


    }

    nav{
        margin-top: 22px;
        margin-left: 20%;
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
        nav{
            margin-left: 20%;
        }
    }
    @media screen and (max-width: 1105px){
        nav{
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

        nav {
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
            text-align: left;
        }
    }

</style>



<head>
    <header class="header">
        <div class="header_logo">
            <p>Ihor Trade</p>
        </div>
        <nav>
            <div class="top_nav" id="myTopNav">
                <a href="#">Home</a>
                <a href="#">About</a>
                <a href="#">Services</a>
                <a href="#">Portfolio</a>
                <a href="#">Testimonials</a>
                <a href="#">Contact</a>
                <a href="#" id="menu" class="icon">&#9776;</a>
            </div>
        </nav>
    </header>
    <#include "../include/footer.ftl">
<body>

