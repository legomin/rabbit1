/**
 * Created by Виталий on 21.12.2015.
 */
function Queques($scope,$http){
    $http.get('/filters').
    success(function(data) {
        $scope.events = data;
    });

    $scope.saveQueques = function() {
        if ($scope.user == null || $scope.event == null){
            alert("user & event must be filled!");
            return;
        }

        if ($scope.events == null || $scope.events == ''){
            $scope.events = [{user: $scope.user, event: $scope.event, alert: $scope.alert}];
        }
        else {
            $scope.events.push({user: $scope.user, event: $scope.event, alert: $scope.alert} );
        }

        $http.post('/save', angular.toJson($scope.events)).success(function(response){
            //alert(response);
        });

            //alert($scope.event);
    };


}

