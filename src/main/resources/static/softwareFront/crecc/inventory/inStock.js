/**
 * Created by xiyuanbupt on 2018/12/6.
 */
// register the grid component
var inStockURL = 'http://localhost:8080/inventory/in_stocks';

var allInLocks =
Vue.component('demo-grid', {
    template: '#grid-template',
    replace: true,
    props: {
        data: Array,
        columns: Array,
        filterKey: String
    },
    data: function () {
        var sortOrders = {}
        this.columns.forEach(function (key) {
            sortOrders[key] = 1
        })
        return {
            sortKey: '',
            sortOrders: sortOrders
        }
    },
    computed: {
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
    filters: {
        capitalize: function (str) {
            return str.charAt(0).toUpperCase() + str.slice(1)
        }
    },
    methods: {
        sortBy: function (key) {
            this.sortKey = key
            this.sortOrders[key] = this.sortOrders[key] * -1
        }
    }
});



var InStock = new Vue(
    {
        el:'#in-stock',
        data:{
            newInStock:{
                count:null,
                startNum:null,
                endNum:null,
                producerName:"",
                receiverName:"",
                remark:null,
                inDate:null,
                isNet:"单机锁"
            },
            inStocks:[

            ],
            validation:{
                count:false,
                num:false
            },
            localStorage : window.localStorage
        },
        created: function () {
            this.init();
            this.loadData();
        },
        methods:{
            loadData: function (isNet) {
                $.ajax({
                    type:"GET",
                    data:{isNet:isNet},
                    crossDomain:true,
                    url:inStockURL + "/all",
                    success: function (responseData, textStatus, jqXHR) {
                        console.log(responseData)
                        console.log(textStatus)
                        console.log(jqXHR)
                    },
                    error: function (responseData, textStatus, jqXHR) {
                        console.log(responseData)
                        console.log(textStatus)
                        console.log(jqXHR)
                    },

                });
            },

            init: function () {
                // 获得当天的时间
                var today = new Date();
                var dd = today.getDate();
                if(dd<10){
                    dd = '0' + dd;
                }
                var mm = today.getMonth() + 1;
                if(mm < 10){
                    mm = '0' + mm;
                }
                var yyyy = today.getFullYear();
                today = yyyy + "-" + mm + "-" + dd;
                this.newInStock.inDate = today;
                // 在浏览器中获得缓存
                var inStock = this.newInStock;
                if(localStorage){
                    if(inStock.isNet == "单机锁"){
                        var last_in_stock_prefix = "last_in_stock_"
                        var key = {
                            producer : last_in_stock_prefix + "producer",
                            receiver : last_in_stock_prefix + "receiver",
                            number : last_in_stock_prefix + "number"
                        }
                        inStock.producerName = localStorage.getItem(key.producer) || null;
                        inStock.receiverName = localStorage.getItem(key.receiver) || null;
                        inStock.startNum = parseInt(localStorage.getItem(key.number)) + 1
                        console.log(inStock)
                        console.log(this.newInStock)
                    }else{
                        var last_in_stock_prefix = "last_in_stock_net_"
                        var key = {
                            producer : last_in_stock_prefix + "producer",
                            receiver : last_in_stock_prefix + "receiver",
                            number : last_in_stock_prefix + "number"
                        }
                        inStock.producerName = localStorage.getItem(key.producer);
                        inStock.receiverName = localStorage.getItem(key.receiver);
                        inStock.startNum = parseInt(localStorage.getItem(key.number)) + 1
                    }
                }
            },

            inStock: function () {
                var inStock = Object.assign({}, this.newInStock);
                inStock.count = parseInt(inStock.count);
                inStock.startNum = parseInt(inStock.startNum);
                inStock.endNum = parseInt(inStock.endNum);
                // 设置localstorage
                if(inStock.isNet == "单机锁"){
                    var last_in_stock_prefix = "last_in_stock_";
                    var key = {
                        producer : last_in_stock_prefix + "producer",
                        receiver : last_in_stock_prefix + "receiver",
                        number : last_in_stock_prefix + "number"
                    }
                    localStorage.setItem(key.producer,inStock.producerName );
                    localStorage.setItem(key.receiver, inStock.receiverName);
                    localStorage.setItem(key.number, inStock.endNum);
                }else{
                    var last_in_stock_prefix = "last_in_stock_net_"
                    var key = {
                        producer : last_in_stock_prefix + "producer",
                        receiver : last_in_stock_prefix + "receiver",
                        number : last_in_stock_prefix + "number"
                    };
                    localStorage.setItem(key.producer,inStock.producerName );
                    localStorage.setItem(key.receiver, inStock.receiverName);
                    localStorage.setItem(key.number, inStock.endNum);
                }
                console.log(inStock);
                if(inStock.count !== inStock.endNum - inStock.startNum + 1){
                    alert("加密锁数量和加密锁号不匹配");
                    return
                }
                $.post(

                )
            }
        },
    }
);

/**
var url = "http://ip-api.com/json";
new Vue({
    el:'#get-data-from-server-app',
    data: {
        locat: null,
        error: null
    },
    created: function(){
        this.init();
    },
    methods: {
        init: function(){
            this.loadData();
        },
        loadData: function() {

            this.$http.get(url).then((response) => {
                if(!!response.body) {
                this.locat = response.body;
            }
        }, (response) => {
                this.error = response;
            });


        }
    }
});

/**
// bootstrap the demo
var demo = new Vue({
    el: '#in_stock',
    data: {
        searchQuery: '',
        gridColumns: ['id', 'count', 'startNum', 'endNum', 'inDate', 'beforeCount', 'afterCount', 'producerName', 'remark'],
        gridData: [
            {
                "id": 181,
                "count": 10,
                "startNum": 20170000,
                "endNum": 20170009,
                "inDate": "2018-12-06",
                "beforeCount": 0,
                "afterCount": 10,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 0,
                "netLock": false
            },
            {
                "id": 182,
                "count": 10,
                "startNum": 20170010,
                "endNum": 20170019,
                "inDate": "2018-12-06",
                "beforeCount": 10,
                "afterCount": 20,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 0,
                "netLock": false
            },
            {
                "id": 183,
                "count": 10,
                "startNum": 20170020,
                "endNum": 20170029,
                "inDate": "2018-12-06",
                "beforeCount": 20,
                "afterCount": 30,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 0,
                "netLock": false
            },
            {
                "id": 184,
                "count": 10,
                "startNum": 20170030,
                "endNum": 20170039,
                "inDate": "2018-12-06",
                "beforeCount": 30,
                "afterCount": 40,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 8,
                "netLock": false
            },
            {
                "id": 185,
                "count": 10,
                "startNum": 20170040,
                "endNum": 20170049,
                "inDate": "2018-12-06",
                "beforeCount": 40,
                "afterCount": 50,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 186,
                "count": 10,
                "startNum": 20170050,
                "endNum": 20170059,
                "inDate": "2018-12-06",
                "beforeCount": 50,
                "afterCount": 60,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 187,
                "count": 10,
                "startNum": 20170060,
                "endNum": 20170069,
                "inDate": "2018-12-06",
                "beforeCount": 60,
                "afterCount": 70,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 188,
                "count": 10,
                "startNum": 20170070,
                "endNum": 20170079,
                "inDate": "2018-12-06",
                "beforeCount": 70,
                "afterCount": 80,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 189,
                "count": 10,
                "startNum": 20170080,
                "endNum": 20170089,
                "inDate": "2018-12-06",
                "beforeCount": 80,
                "afterCount": 90,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 190,
                "count": 10,
                "startNum": 20170090,
                "endNum": 20170099,
                "inDate": "2018-12-06",
                "beforeCount": 90,
                "afterCount": 100,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 191,
                "count": 10,
                "startNum": 20170100,
                "endNum": 20170109,
                "inDate": "2018-12-06",
                "beforeCount": 100,
                "afterCount": 110,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 192,
                "count": 10,
                "startNum": 20170110,
                "endNum": 20170119,
                "inDate": "2018-12-06",
                "beforeCount": 110,
                "afterCount": 120,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 193,
                "count": 10,
                "startNum": 20170120,
                "endNum": 20170129,
                "inDate": "2018-12-06",
                "beforeCount": 120,
                "afterCount": 130,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 194,
                "count": 10,
                "startNum": 20170130,
                "endNum": 20170139,
                "inDate": "2018-12-06",
                "beforeCount": 130,
                "afterCount": 140,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 195,
                "count": 10,
                "startNum": 20170140,
                "endNum": 20170149,
                "inDate": "2018-12-06",
                "beforeCount": 140,
                "afterCount": 150,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 196,
                "count": 10,
                "startNum": 20170150,
                "endNum": 20170159,
                "inDate": "2018-12-06",
                "beforeCount": 150,
                "afterCount": 160,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 197,
                "count": 10,
                "startNum": 20170160,
                "endNum": 20170169,
                "inDate": "2018-12-06",
                "beforeCount": 160,
                "afterCount": 170,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 198,
                "count": 10,
                "startNum": 20170170,
                "endNum": 20170179,
                "inDate": "2018-12-06",
                "beforeCount": 170,
                "afterCount": 180,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            },
            {
                "id": 199,
                "count": 10,
                "startNum": 20170180,
                "endNum": 20170189,
                "inDate": "2018-12-06",
                "beforeCount": 180,
                "afterCount": 190,
                "producerName": "王熙元",
                "receiverName": "张静",
                "remark": "普通的加密锁入库",
                "remainCount": 10,
                "netLock": false
            }
        ]
    }
})
 **/
