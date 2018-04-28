/* Setting the constants value for the image source */
const BLINK = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/blink.jpeg";
const CLENCH = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/clench.jpeg";
const FURROW_BROW = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/furrow_brow.jpeg";
const LAUGH = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/laugh.jpeg";
const LOOK_LEFT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/look_left.jpeg";
const LOOK_RIGHT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/look_right.jpeg";
const NORMAL_LOWER = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/normal_lower.jpeg";
const NORMAL_UPPER = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/normal_upper.jpeg";
const RAISE_BROW = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/raise_brow.jpeg";
const SMILE = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/smile.jpeg";
const SMIRK_LEFT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/smirk_left.jpeg";
const SMIRK_RIGHT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/smirk_right.jpeg";
const WINK_LEFT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/wink_left.jpeg";
const WINK_RIGHT = "../../out/production/Project4_SER516/edu/ser516/project4/resources/images/wink_right.jpeg";

/* Updating the expressions of the face */
function expressionChanger(data){
    updateUpperFace(data);
    updateLowerFace(data);
}

/* Updating the upper face */

function updateUpperFace(data){
    var imgSrc = NORMAL_UPPER;
    if (data.Expressive.Blink){
        imgSrc = BLINK;
    } else if(data.Expressive.LeftWink){
        imgSrc = WINK_LEFT;
    } else if(data.Expressive.RightWink){
        imgSrc = WINK_RIGHT;
    } else if(data.Expressive.LookingLeft){
        imgSrc = LOOK_LEFT;
    } else if(data.Expressive.LookingRight){
        imgSrc = LOOK_RIGHT;
    } else if(data.Expressive.EyebrowRaise > 0){
        imgSrc = RAISE_BROW;
    } else if(data.Expressive.EyebrowFurrow > 0){
        imgSrc = FURROW_BROW;
    }
    $("#upper-face").attr("src",imgSrc);
}

/* Updating the lower face */

function updateLowerFace(data){
    var imgSrc = NORMAL_LOWER;
    if (data.Expressive.Smile > 0.5){
        imgSrc = SMILE;
    } else if(data.Expressive.Clench > 0.5){
        imgSrc = CLENCH;
    } else if(data.Expressive.SmirkLeft > 0){
        imgSrc = SMIRK_LEFT;
    } else if(data.Expressive.SmirkRight > 0){
        imgSrc = SMIRK_RIGHT;
    } else if(data.Expressive.Laugh > 0){
        imgSrc = LAUGH;
    }
    $("#lower-face").attr("src",imgSrc);
}