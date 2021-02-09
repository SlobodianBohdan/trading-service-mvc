
    <style>
        .footer{
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
            background: #000000;
            width: 100%;
            height: 120px;
            margin-top: auto;
        }
        .ulFooter{
            display: flex;
            margin-top: 10px;
        }
        .ulFooter .liFooter{
            position: relative;
            display: block;
            color: #666;
            font-size: 30px;
            height: 60px;
            width: 60px;
            background: #171515;
            line-height: 60px;
            border-radius: 50%;
            margin: 0 15px;
            cursor: pointer;
            transition: .5s;
        }
        .ulFooter .liFooter:before{
            position: absolute;
            content: '';
            top: 0;
            left: 0;
            height: inherit;
            width: inherit;
            /* background: #d35400; */
            border-radius: 50%;
            transform: scale(.9);
            z-index: -1;
            transition: .5s;
        }
        .ulFooter .liFooter:nth-child(1):before{
            background: #4267B2;
        }
        .ulFooter .liFooter:nth-child(2):before{
            background: #1DA1F2;
        }
        .ulFooter .liFooter:nth-child(3):before{
            background: #E1306C;
        }
        .ulFooter .liFooter:nth-child(4):before{
            background: #2867B2;
        }
        .ulFooter .liFooter:nth-child(5):before{
            background: #ff0000;
        }
        .ulFooter .liFooter:hover:before{
            filter: blur(3px);
            transform: scale(1.2);
            /* box-shadow: 0 0 15px #d35400; */
        }
        .ulFooter .liFooter:nth-child(1):hover:before{
            box-shadow: 0 0 15px #4267B2;
        }
        .ulFooter .liFooter:nth-child(2):hover:before{
            box-shadow: 0 0 15px #1DA1F2;
        }
        .ulFooter .liFooter:nth-child(3):hover:before{
            box-shadow: 0 0 15px #E1306C;
        }
        .ulFooter .liFooter:nth-child(4):hover:before{
            box-shadow: 0 0 15px #2867B2;
        }
        .ulFooter .liFooter:nth-child(5):hover:before{
            box-shadow: 0 0 15px #ff0000;
        }
        .ulFooter .liFooter:nth-child(1):hover{
            color: #456cba;
            box-shadow: 0 0 15px #4267B2;
            text-shadow: 0 0 15px #4267B2;
        }
        .ulFooter .liFooter:nth-child(2):hover{
            color: #26a4f2;
            box-shadow: 0 0 15px #1DA1F2;
            text-shadow: 0 0 15px #1DA1F2;
        }
        .ulFooter .liFooter:nth-child(3):hover{
            color: #e23670;
            box-shadow: 0 0 15px #E1306C;
            text-shadow: 0 0 15px #E1306C;
        }
        .ulFooter .liFooter:nth-child(4):hover{
            color: #2a6cbb;
            box-shadow: 0 0 15px #2867B2;
            text-shadow: 0 0 15px #2867B2;
        }
        .ulFooter .liFooter:nth-child(5):hover{
            color: #ff1a1a;
            box-shadow: 0 0 15px #ff0000;
            text-shadow: 0 0 15px #ff0000;
        }
        .fab{
            margin-top: 15px;
        }
    </style>

    <footer class="footer">
            <ul class="ulFooter">
                <li class="liFooter"><a href="#" class="fab fa-facebook-f" target="_blank"></a></li>
                <li class="liFooter"><a href="#" class="fab fa-twitter" target="_blank"></a></li>
                <li class="liFooter"><a href="#" class="fab fa-instagram" target="_blank"></a></li>
                <li class="liFooter"><a href="https://t.me/igorjkeeee" class="fab fa-telegram" target="_blank"></a></li>
                <li class="liFooter"><a href="#" class="fab fa-youtube" target="_blank"></a></li>
            </ul>
    </footer>

    <script>
        menu.onclick = function myFunction() {
            var x = document.getElementById('myTopNav');

            if (x.className === "top_nav") {
                x.className += " responsive";
            } else {
                x.className = "top_nav";
            }
        }
    </script>
    </body>
</html>
