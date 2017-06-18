/**
 * Created by wladek on 6/18/17.
 */
var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        feeds : [],
        error : null
    },
    methods : {
        refreshFeed : function () {
            this.loadData();
        },
        loadData : function () {
            $.ajax({
                type : "GET",
                url : "/api/newsfeed",
                dataType: "json",
                success: function (data) {
                    self.feeds = data;
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            });
        }
    }
});
