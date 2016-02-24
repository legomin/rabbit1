/**
 * Created by Виталий on 21.12.2015.
 */
function Messages($scope,$http){

    //parsing search line
    var strSearch   = window.location.search.substr(1),
       strPattern  = /([^=]+)=([^&]+)&?/ig,
       arrMatch    = strPattern.exec(strSearch),
       objRes      = {};
    while (arrMatch != null) {
       objRes[arrMatch[1]] = arrMatch[2];
       arrMatch = strPattern.exec(strSearch);
    }

    if (objRes['user'] !=null) {
        $http.get('/sendMessage?user=' + objRes['user']).
        success(function (data) {
            $scope.events = data;
            if ($scope.events.length > 0){
                var alert1 = $scope.events[$scope.events.length-1].alert;
                if (alert1!=null && alert1!= ''){
                    alert(alert1);
                }
            }
        });
    }
    $scope.sendMessage = function(color){
        var action;
        if (color==1) {
            action = 'pushBlueButton';
        }
        else  if (color==2) {
            action = 'pushRedButton';
        }
        else  if (color==3) {
            action = 'pushGreenButton';
        }
        else  if (color==4) {
            action = 'pushYellowButton';
        }
        $http.get('/sendMessage?user=' + objRes['user'] + '&action='+action).
        success(function (data) {
            $scope.events = data;
            if ($scope.events.length > 0){
                var alert1 = $scope.events[$scope.events.length-1].alert;
                if (alert1!=null && alert1!= ''){
                    alert(alert1);
                }
            }
        });

    }

}

