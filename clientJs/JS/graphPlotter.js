/* Plotting the graph */
var Interest = []; // dataPoints
var Stress = []; // dataPoints
var Engagement = []; // dataPoints
var Relaxation = []; // dataPoints
var Excitement = []; // dataPoints
var Focus = []; // dataPoints

/* Rendering the Emotion graph */

function renderEmotionGraph(){
    var emotionChart = new CanvasJS.Chart("chartContainer", {
    title :{
        text: "Affective Data"
    },
    axisY: {
        includeZero: false
    },      
    data: [{
        type: "line",
        lineColor: window.interestColor,
        dataPoints: Interest
    },
    {
        type: "line",
        lineColor: window.engagementColor,
        dataPoints: Engagement
    },
    {
        type: "line",
        lineColor: window.relaxationColor,
        dataPoints: Relaxation
    },
    {
        type: "line",
        lineColor: window.excitementColor,
        dataPoints: Excitement
    },
    {
        type: "line",
        lineColor: window.stressColor,
        dataPoints: Stress
    },
    {
        type: "line",
        lineColor: window.focusColor,
        dataPoints: Focus
    }
    ]
});
emotionChart.render();
    
}

var xVal = 0;
var yVal = 100; 
var updateInterval = 1000;
var dataLength = 1000; // number of dataPoints visible at any point

/* Updating the chart on receiving new values from the server */

var updateChart = function (data) {

        if (data.Emotional.Interest != undefined){
            Interest.push({
            x: xVal,
            y: data.Emotional.Interest
        });
        }
        if (data.Emotional.Stress != undefined){
            Stress.push({
            x: xVal,
            y: data.Emotional.Stress
        });
        }
        if (data.Emotional.Focus != undefined){
            Focus.push({
            x: xVal,
            y: data.Emotional.Focus
        });
        }
        if (data.Emotional.Engagement != undefined){
            Engagement.push({
            x: xVal,
            y: data.Emotional.Engagement
        });
        }
        if (data.Emotional.Excitement != undefined){
            Excitement.push({
            x: xVal,
            y: data.Emotional.Excitement
        });
        }
        if (data.Emotional.Relaxation != undefined){
            Relaxation.push({
            x: xVal,
            y: data.Emotional.Relaxation
        });
        }
                xVal++;

    

    if (Interest.length > dataLength) {
        Interest.shift();
    }
    if (Stress.length > dataLength) {
        Stress.shift();
    }
    if (Engagement.length > dataLength) {
        Engagement.shift();
    }
    if (Focus.length > dataLength) {
        Focus.shift();
    }
    if (Relaxation.length > dataLength) {
        Relaxation.shift();
    }
    if (Excitement.length > dataLength) {
        Excitement.shift();
    }

renderEmotionGraph();
};

renderEmotionGraph();

var RaiseEyebrow = []; // dataPoints
var FurrowBrow = []; // dataPoints
var Smile = []; // dataPoints
var Clench = []; // dataPoints
var SmirkLeft = []; // dataPoints
var SmirkRight = []; // dataPoints
var Laugh = []; // dataPoints
var Blink = []; // dataPoints
var LookingLeft = []; // dataPoints
var LookingRight = []; // dataPoints
var RightWink = []; // dataPoints
var LeftWink = []; // dataPoints

/* Creating the Expression chart */

var expressionChart = new CanvasJS.Chart("expressionChartContainer", {
    title :{
        text: "Expressive Data"
    },
    axisY: {
        includeZero: false
    },      
    data: [{
        type: "line",
        dataPoints: RaiseEyebrow,
        lineColor: "blue"
    },
    {
        type: "line",
        dataPoints: FurrowBrow,
        lineColor: "green"
    },
    {
        type: "line",
        dataPoints: Smile,
        lineColor: "red"
    },
    {
        type: "line",
        dataPoints: Clench,
        lineColor: "black"
    },
    {
        type: "line",
        dataPoints: SmirkLeft,
        lineColor: "grey"
    },
    {
        type: "line",
        dataPoints: SmirkRight,
        lineColor: "violet"
    },
    {
        type: "line",
        dataPoints: Blink,
        lineColor: "orange"
    },
    {
        type: "line",
        dataPoints: LookingLeft,
        lineColor: "indigo"
    },
    {
        type: "line",
        dataPoints: LookingRight,
        lineColor: "pink"
    },
    {
        type: "line",
        dataPoints: RightWink,
        lineColor: "purple"
    },
    {
        type: "line",
        dataPoints: LeftWink,
        lineColor: "cyan"
    },
    {
        type: "line",
        dataPoints: Laugh,
        lineColor: "brown"
    }
    ]
});
expressionChart.render();

var xVal = 0;
var yVal = 100; 
var updateInterval = 1000;
var dataLength = 1000; // number of dataPoints visible at any point

/* Updating the Expression Chart */

var updateExpressionChart = function (data) {

        if (data.Expressive.Blink != undefined){
            Blink.push({
            x: xVal,
            y: (data.Expressive.Blink ? 1 : 0)
        });
        }
        if (data.Expressive.Clench != undefined){
            Clench.push({
            x: xVal,
            y: data.Expressive.Clench+3
        });
        }
        if (data.Expressive.EyebrowRaise != undefined){
            RaiseEyebrow.push({
            x: xVal,
            y: data.Expressive.EyebrowRaise +6
        });
        }
        if (data.Expressive.EyebrowFurrow != undefined){
            FurrowBrow.push({
            x: xVal,
            y: data.Expressive.EyebrowFurrow + 9
        });
        }
        if (data.Expressive.Laugh != undefined){
            Laugh.push({
            x: xVal,
            y: data.Expressive.Laugh + 12
        });
        }
        if (data.Expressive.LookingLeft != undefined){
            LookingLeft.push({
            x: xVal,
            y: (data.Expressive.LookingLeft ? 1 : 0) + 15
        });
        }
        if (data.Expressive.LookingRight != undefined){
            LookingRight.push({
            x: xVal,
            y: (data.Expressive.LookingRight ? 1 : 0) +18
        });
        }
        if (data.Expressive.LeftWink != undefined){
            LeftWink.push({
            x: xVal,
            y: (data.Expressive.LeftWink? 1 : 0)+21
        });
        }
        if (data.Expressive.RightWink != undefined){
            RightWink.push({
            x: xVal,
            y: (data.Expressive.RightWink? 1 : 0) + 24
        });
        }
        if (data.Expressive.Smile != undefined){
            Smile.push({
            x: xVal, 
            y: data.Expressive.Smile +27
        });
        }
        if (data.Expressive.SmirkRight != undefined){
            SmirkRight.push({
            x: xVal,
            y: data.Expressive.SmirkRight
        });
        }
        if (data.Expressive.SmirkLeft != undefined){
            SmirkLeft.push({
            x: xVal,
            y: data.Expressive.SmirkRight
        });
        }
        
                xVal++;

    

    if (Blink.length > dataLength) {
        Blink.shift();
    }
    if (Clench.length > dataLength) {
        Clench.shift();
    }
    if (FurrowBrow.length > dataLength) {
        FurrowBrow.shift();
    }
    if (RaiseEyebrow.length > dataLength) {
        RaiseEyebrow.shift();
    }
    if (LookingLeft.length > dataLength) {
        LookingLeft.shift();
    }
    if (LookingRight.length > dataLength) {
        LookingRight.shift();
    }
    if (RightWink.length > dataLength) {
        RightWink.shift();
    }
    if (LeftWink.length > dataLength) {
        LeftWink.shift();
    }
    if (Smile.length > dataLength) {
        Smile.shift();
    }
    if (SmirkRight.length > dataLength) {
        SmirkRight.shift();
    }
    if (Laugh.length > dataLength) {
        Laugh.shift();
    }
    if (SmirkLeft.length > dataLength) {
        LookingRight.shift();
    }
    expressionChart.render();
};