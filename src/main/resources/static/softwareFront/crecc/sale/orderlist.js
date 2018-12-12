/**
 * Created by xiyuanbupt on 2018/12/7.
 */

Vue.component('orderlist-grid',{
    template: '#orderlist-template',
    replace:true,
    props:{
        data:Array, // 所有的订单
        columns:Array, // 表头的key
        columnNames:Array, // 表头要显示的名称
        columnIsImportant :Array, // 当前列是否是着重显示的列
        filterKey:String
    },
    data: function () {
        var sortOrders = {}
        this.columns.forEach(
            function (key) {
                sortOrders[key] = 1
            }
        )
        return {
            sortKey:'',
            sortOrders:sortOrders
        }
    },
    computed:{
        filteredData: function () {
            var sortKey = this.sortKey
            var filterKey = this.filterKey && this.filterKey.toLowerCase()
            var order = this.sortOrders[sortKey] || 1
            var data = this.data
            if (filterKey) {
                data = data.filter(function (row) {
                    return Object.keys(row).some(function (key) {
                        return String(row[key]).toLowerCase().indexOf(filterKey) > -1
                    })
                })
            }
            if (sortKey) {
                data = data.slice().sort(function (a, b) {
                    a = a[sortKey]
                    b = b[sortKey]
                    return (a === b ? 0 : a > b ? 1 : -1) * order
                })
            }
            return data
        }
    },
    filters:{

    },
    methods:{
        sortBy: function (key) {
            this.sortKey = key;
            this.sortOrders[key] = this.sortOrders[key] * -1;
        }
    }

});

var demo = new Vue(
    {
        el: 'dynamic-component',

        data:{
            searchQuery:'',
            gridColumns:[],

        }
    }
);
