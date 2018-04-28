/* connecting with server on the clicking of the Connect Server Button */
$("#connect-server").click(function(){
    var socket = new WebSocket("ws://localhost:8025/ws/status");
    socket.onmessage = onMessage;

    function onMessage(event) {
        var device = JSON.parse(event.data);
        updateChart(device);
        updateExpressionChart(device);
        expressionChanger(device);
        $(".status").text("Connected");
    }
});