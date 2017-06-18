/**
 * Created by wladek on 6/18/17.
 */
var app = new Vue({
    el: '#app',
    data: {
        items : [],
        error : null
    },
    mounted : function() {
        this.getAll();
    },
    methods : {
        getAll: function () {
            this.loadData();
        },
        loadData: function () {
            var self = this;
            $.ajax({
                type: "GET",
                url: "/api/newsfeed",
                dataType: "json",
                success: function (data) {
                    self.items = data;
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            })
        }
    }
});
