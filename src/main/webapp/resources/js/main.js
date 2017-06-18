/**
 * Created by wladek on 6/18/17.
 */
var app = new Vue({
    el: '#app',
    data: {
        items : [],
        error : null
    },
    methods : {
        ready: function () {
            this.loadData();
        },
        loadData: function () {
            $.ajax({
                type: "GET",
                url: "/api/newsfeed",
                dataType: "json",
                success: function (data) {
                    this.items = data;
                    alert(data);
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            })
        }
    }
});
