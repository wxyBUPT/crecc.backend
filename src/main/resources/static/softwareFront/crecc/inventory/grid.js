/**
 * Created by xiyuanbupt on 2018/12/6.
 */
// register the grid component
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

// bootstrap the demo
var demo = new Vue({
    el: '#demo',
    data: {
        searchQuery: '',
        gridColumns: ['id', 'buyerName' , 'buyerTel', 'buyerCompany', 'buyerCompanyAddress', 'lockCount', 'giveLockCount', 'updateLockCount', 'netLockCount'],
        gridData: [
            {
                "id": 1,
                "buyerName": "郭奋军",
                "buyerTel": "15935185626",
                "buyerCompany": "山西晋利工程造价咨询有限责任公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 1,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 12000,
                "invoiceInfos": [
                    {
                        "id": 1,
                        "invoices": [],
                        "title": "山西晋利工程造价咨询有限责任公司",
                        "price": 12000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 2,
                "buyerName": "吴醒洪",
                "buyerTel": "18617359917",
                "buyerCompany": "中铁广州工程局集团桥梁工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 2,
                        "invoices": [],
                        "title": "中铁广州工程局集团桥梁工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 3,
                "buyerName": "张春燕",
                "buyerTel": "18200555199",
                "buyerCompany": "四川公路桥梁建设集团有限公司大桥工程分公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 2,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 10000,
                "invoiceInfos": [
                    {
                        "id": 3,
                        "invoices": [],
                        "title": "四川公路桥梁建设集团有限公司大桥工程分公司",
                        "price": 10000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 4,
                "buyerName": "殷有伟",
                "buyerTel": "13848674840",
                "buyerCompany": "中铁十九局集团第一工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 4,
                        "invoices": [],
                        "title": "中铁十九局集团第一工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 5,
                "buyerName": "郑征",
                "buyerTel": "18686809825",
                "buyerCompany": "中铁建大桥工程局集团第四工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 5,
                        "invoices": [],
                        "title": "中铁建大桥工程局集团第四工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 6,
                "buyerName": "赵美娟",
                "buyerTel": "18675165906",
                "buyerCompany": "中铁十二局集团建筑安装工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 6,
                        "invoices": [],
                        "title": "中铁十二局集团建筑安装工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 7,
                "buyerName": "杨浩宇",
                "buyerTel": "18165039618",
                "buyerCompany": "榆林市旭辉路桥工程劳务有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 1,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 12000,
                "invoiceInfos": [
                    {
                        "id": 7,
                        "invoices": [],
                        "title": "榆林市旭辉路桥工程劳务有限公司",
                        "price": 12000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 8,
                "buyerName": "方宇",
                "buyerTel": "15906615917",
                "buyerCompany": "浙江铁道建设工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 1,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 12000,
                "invoiceInfos": [
                    {
                        "id": 8,
                        "invoices": [],
                        "title": "浙江铁道建设工程有限公司",
                        "price": 12000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 9,
                "buyerName": "董薇",
                "buyerTel": "13810584409",
                "buyerCompany": "中铁工程设计咨询集团有限公司郑州设计院",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 40000,
                "invoiceInfos": [
                    {
                        "id": 9,
                        "invoices": [],
                        "title": "中铁工程设计咨询集团有限公司郑州设计院",
                        "price": 40000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 10,
                "buyerName": "董薇",
                "buyerTel": "13810584409",
                "buyerCompany": "中铁工程设计咨询集团有限公司济南设计院",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 45000,
                "invoiceInfos": [
                    {
                        "id": 10,
                        "invoices": [],
                        "title": "中铁工程设计咨询集团有限公司济南设计院",
                        "price": 45000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 11,
                "buyerName": "董薇",
                "buyerTel": "13810584409",
                "buyerCompany": "中铁工程设计咨询集团有限公司太原设计院",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 35000,
                "invoiceInfos": [
                    {
                        "id": 11,
                        "invoices": [],
                        "title": "中铁工程设计咨询集团有限公司太原设计院",
                        "price": 35000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 12,
                "buyerName": "殷家林",
                "buyerTel": "15344044220",
                "buyerCompany": "神华甘泉铁路有限责任公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 3,
                "giveLockCount": 1,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 36000,
                "invoiceInfos": [
                    {
                        "id": 12,
                        "invoices": [],
                        "title": "神华甘泉铁路有限责任公司",
                        "price": 36000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 13,
                "buyerName": "胡科洁",
                "buyerTel": "15285022312",
                "buyerCompany": "中国铁路成都局集团有限公司贵阳北供电段",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 2,
                "giveLockCount": 0,
                "updateLockCount": 0,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 24000,
                "invoiceInfos": [
                    {
                        "id": 13,
                        "invoices": [],
                        "title": "中国铁路成都局集团有限公司贵阳北供电段",
                        "price": 24000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 14,
                "buyerName": "赵昕",
                "buyerTel": "18001022212",
                "buyerCompany": "北京全路通信信号研究设计院集团有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 1,
                "giveLockCount": 0,
                "updateLockCount": 2,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 22000,
                "invoiceInfos": [
                    {
                        "id": 14,
                        "invoices": [],
                        "title": "北京全路通信信号研究设计院集团有限公司",
                        "price": 22000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 15,
                "buyerName": "汪凯",
                "buyerTel": "18053501863",
                "buyerCompany": "中铁武汉电气化局集团有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 15,
                        "invoices": [],
                        "title": "中铁武汉电气化局集团有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 16,
                "buyerName": "童运伟",
                "buyerTel": "13660348865",
                "buyerCompany": "中铁广州工程局集团第二工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 2,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 10000,
                "invoiceInfos": [
                    {
                        "id": 16,
                        "invoices": [],
                        "title": "中铁广州工程局集团第二工程有限公司",
                        "price": 10000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 17,
                "buyerName": "杨红",
                "buyerTel": "13898193212",
                "buyerCompany": "中铁九局集团第四工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 2,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 10000,
                "invoiceInfos": [
                    {
                        "id": 17,
                        "invoices": [],
                        "title": "中铁九局集团第四工程有限公司",
                        "price": 10000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 18,
                "buyerName": "杜涛",
                "buyerTel": "18679515835",
                "buyerCompany": "中铁大桥局集团第五工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 18,
                        "invoices": [],
                        "title": "中铁大桥局集团第五工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 19,
                "buyerName": "易滔",
                "buyerTel": "15886399299",
                "buyerCompany": "中铁武汉电气化局集团有限公司广州分公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 19,
                        "invoices": [],
                        "title": "中铁武汉电气化局集团有限公司广州分公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 20,
                "buyerName": "郑国梁",
                "buyerTel": "13834169096",
                "buyerCompany": "山西中审华晋工程造价咨询有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 20,
                        "invoices": [],
                        "title": "山西中审华晋工程造价咨询有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 21,
                "buyerName": "徐祖彬",
                "buyerTel": "18755160352",
                "buyerCompany": "中铁四局集团有限公司第八工程分公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 21,
                        "invoices": [],
                        "title": "中铁四局集团有限公司第八工程分公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 22,
                "buyerName": "韩佳丽",
                "buyerTel": "13574880726",
                "buyerCompany": "中铁北京工程局集团有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 22,
                        "invoices": [],
                        "title": "中铁北京工程局集团有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 23,
                "buyerName": "李卫杰",
                "buyerTel": "18850388879",
                "buyerCompany": "中铁二十四局集团FPZQ-2标项目部",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 23,
                        "invoices": [],
                        "title": "中铁二十四局集团FPZQ-2标项目部",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 24,
                "buyerName": "王志东",
                "buyerTel": "18681872655",
                "buyerCompany": "中国铁路通信信号上海工程局集团有限公司西安分公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 24,
                        "invoices": [],
                        "title": "中国铁路通信信号上海工程局集团有限公司西安分公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 25,
                "buyerName": "肖寒",
                "buyerTel": "13037354555",
                "buyerCompany": "中铁武汉电气化局集团有限公司北京分公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 25,
                        "invoices": [],
                        "title": "中铁武汉电气化局集团有限公司北京分公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            },
            {
                "id": 26,
                "buyerName": "戴翔",
                "buyerTel": "15905609900",
                "buyerCompany": "中铁四局集团第四工程有限公司",
                "buyerCompanyAddress": "北京市海淀区北蜂窝路乙29号",
                "lockCount": 0,
                "giveLockCount": 0,
                "updateLockCount": 1,
                "netLockCount": 0,
                "netUpdateLockCount": 0,
                "netGiveCount": 0,
                "freeUpdateCount": 0,
                "borrowCount": 0,
                "damageCount": 0,
                "payAccountName": "中国建设银行",
                "payAccount": "23999499949",
                "payDate": "2018-12-03",
                "totalPrice": 5000,
                "invoiceInfos": [
                    {
                        "id": 26,
                        "invoices": [],
                        "title": "中铁四局集团第四工程有限公司",
                        "price": 5000,
                        "taxIdentificationNum": "297166376626",
                        "address": "北京市海淀区北蜂窝路乙29号中国铁路经济规划研究院有限公司",
                        "tel": "010-51879654",
                        "bank": "中国建设银行北蜂窝路支行",
                        "bankAccount": "1287736626551523",
                        "commonInvoice": true
                    }
                ],
                "outStock": null,
                "post": null
            }
        ]
    }
})

