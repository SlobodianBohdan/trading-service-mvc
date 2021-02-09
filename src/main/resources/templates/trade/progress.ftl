<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<#include "../include/header.ftl">
    <style>
        .textProgress{
            margin-top: 5%;
            margin-bottom: 3%;
        }

        .chart{
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
            margin-top: 5%;
            margin-bottom: 5%;
        }
    </style>
    <main>
        <div class="container">
            <div class="textProgress">
                <h1 class="text-center font-italic font-weight-bold font-family">Progress of my trades since 2017 in percent!</h1>            </div>
            <div class="chart" id="myfirstchart"></div>
        </div>
    </main>

    <script>
        new Morris.Line({
            // ID of the element in which to draw the chart.
            element: 'myfirstchart',
            // Chart data records -- each entry in this array corresponds to a point on
            // the chart.

            data: [
                { year: '2017', value: -80 },
                { year: '2018', value: 120 },
                { year: '2019', value: 180 },
                { year: '2020', value: 250 },
                { year: '2021', value: 300 }
            ],
            // The name of the data record attribute that contains x-values.
            xkey: 'year',
            // A list of names of data record attributes that contain y-values.
            ykeys: ['value'],
            // Labels for the ykeys -- will be displayed when you hover over the
            // chart.
            labels: ['Value']
        });
    </script>

<#include "../include/footer.ftl">