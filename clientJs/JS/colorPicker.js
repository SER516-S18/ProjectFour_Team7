/*Functions to handle custom select color for performance metrics
 */
$("#pills-performance button").click(function(){
    if(this.id != "close" && this.id != "save"){
        window.buttonSelected = this.id;
    }
});

/* Changing the graph legend based on the colour picked */
$("#save").click(function(){
    var color = $(".custom-select").val();
    switch(window.buttonSelected) {
        case "interest":
            window.interestColor = color;
            break;
        case "excitement":
            window.excitementColor = color;
            break;
        case "engagement":
            window.engagementColor = color;
            break;
        case "stress":
            window.stressColor = color;
            break;
        case "relaxation":
            window.relaxationColor = color;
            break;
        case "focus":
            window.focusColor = color;
            break;
    }
    $("#"+window.buttonSelected).css("background-color",color);
    $('#exampleModal').modal('hide');
    renderEmotionGraph();
});