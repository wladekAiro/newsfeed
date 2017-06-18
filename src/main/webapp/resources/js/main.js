/**
 * Created by wladek on 6/18/17.
 */
Vue.http.options.emulateJSON = true;

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
        },
        rateLink : function (feed) {
            this.$http.put('/api/ratelink', JSON.stringify(feed));
        }
    },
    computed: {
        sortedArray: function () {
            function compare(a, b) {
                if (a.views < b.views)
                    return -1;
                if (a.views > b.views)
                    return 1;
                return 0;
            }

            return self.items.sort(compare);
        }
    }
});
