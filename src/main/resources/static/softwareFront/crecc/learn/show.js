/**
 * Created by xiyuanbupt on 2018/12/6.
 *
 */

Vue.component('todo-item',{
    props:['todo'],
    template:'<li>{{todo.text}}</li>'
});


var app = new Vue(
    {
        el:"#app",
        data:{
            message:'Hello Vue!'
        }
    }
);

var app = new Vue({
    el:"#app-7",
    data:{
        groceryList: [
            { id: 0, text: '蔬菜' },
            { id: 1, text: '奶酪' },
            { id: 2, text: '随便其它什么人吃的东西' }
        ]
    }
});
