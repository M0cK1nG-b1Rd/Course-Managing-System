webpackJsonp([21],{AGPb:function(t,o,n){var e=n("MCFm");"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);n("rjj0")("34be8508",e,!1,{})},MCFm:function(t,o,n){(t.exports=n("FZ+f")(!0)).push([t.i,"\n:root{\n  font: 14px/1.4 -apple-system, BlinkMacSystemFont,\n  Segoe UI, Helvetica, Arial, sans-serif,\n  Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol;\n}\n.todolist {\n  display: inline-block;\n  vertical-align: top;\n  max-width: 200px;\n  width: 100%;\n  padding: 20px;\n}\n.todolist a, .todolist input, .todolist button {\n  border: 1px solid #ddd;\n  border-radius: 3px;\n}\n.todolist a {\n  text-decoration: none;\n  color: #2d2d2d;\n}\n.todolist input {\n  padding: 2px 4px;\n  line-height: 1;\n  font-size: 16px;\n  color: #2d2d2d;\n  outline: none;\n}\n.todolist input:hover, .todolist input:focus {\n  border-color: #9e9e9e;\n}\n.todolist button {\n  padding: 0 4px;\n  border-color: #ff0000;\n  line-height: 1;\n  font-size: 12px;\n  color: #ff0000;\n  outline: none;\n}\n.todolist label, .todolist button {\n  cursor: pointer;\n}\n.todolist__header {\n  margin-bottom: 10px;\n}\n.todolist__main {\n  margin-bottom: 10px;\n}\n.todolist__main div {\n  margin-bottom: 5px;\n}\n.todolist__main li {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  padding: 5px 0;\n  border-bottom: 1px solid #ddd;\n  position: relative;\n}\n.todolist__main li label {\n  position: relative;\n  z-index: 1;\n}\n.todolist__main li button {\n  display: none;\n  margin-left: 5px;\n  position: relative;\n  z-index: 1;\n}\n.todolist__main li input[type=text] {\n  display: none;\n  width: 100%;\n  height: 100%;\n  position: absolute;\n  top: 0;\n  left: 0;\n  z-index: 2;\n  border: 0;\n}\n.todolist__main li:hover button {\n  display: block;\n}\n.todolist__main li.completed label {\n  text-decoration: line-through;\n}\n.todolist__main li.editing input[type=text] {\n  display: block;\n}\n.todolist__footer ul {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: start;\n      -ms-flex-align: start;\n          align-items: flex-start;\n  -webkit-box-pack: start;\n      -ms-flex-pack: start;\n          justify-content: flex-start;\n  list-style-type: none;\n  margin-top: 10px;\n}\n.todolist__footer li {\n  padding-right: 10px;\n}\n.todolist__footer a {\n  display: block;\n  padding: 2px 4px;\n}\n.todolist__footer a:hover, .todolist__footer a.active {\n  background-color: #ddd;\n}\n","",{version:3,sources:["C:/Users/shinelon/Desktop/Course-Managing-System/frontend/src/views/project/todolist/src/views/project/todolist/Todo.vue"],names:[],mappings:";AAsGA;EACA;;qDAEA;CACA;AACA;EACA,sBAAA;EACA,oBAAA;EACA,iBAAA;EACA,YAAA;EACA,cAAA;CACA;AACA;EACA,uBAAA;EACA,mBAAA;CACA;AACA;EACA,sBAAA;EACA,eAAA;CACA;AACA;EACA,iBAAA;EACA,eAAA;EACA,gBAAA;EACA,eAAA;EACA,cAAA;CACA;AACA;EACA,sBAAA;CACA;AACA;EACA,eAAA;EACA,sBAAA;EACA,eAAA;EACA,gBAAA;EACA,eAAA;EACA,cAAA;CACA;AACA;EACA,gBAAA;CACA;AACA;EACA,oBAAA;CACA;AACA;EACA,oBAAA;CACA;AACA;EACA,mBAAA;CACA;AACA;EACA,qBAAA;EAAA,qBAAA;EAAA,cAAA;EACA,+BAAA;EAAA,8BAAA;MAAA,wBAAA;UAAA,oBAAA;EACA,0BAAA;MAAA,uBAAA;UAAA,oBAAA;EACA,eAAA;EACA,8BAAA;EACA,mBAAA;CACA;AACA;EACA,mBAAA;EACA,WAAA;CACA;AACA;EACA,cAAA;EACA,iBAAA;EACA,mBAAA;EACA,WAAA;CACA;AACA;EACA,cAAA;EACA,YAAA;EACA,aAAA;EACA,mBAAA;EACA,OAAA;EACA,QAAA;EACA,WAAA;EACA,UAAA;CACA;AACA;EACA,eAAA;CACA;AACA;EACA,8BAAA;CACA;AACA;EACA,eAAA;CACA;AACA;EACA,qBAAA;EAAA,qBAAA;EAAA,cAAA;EACA,+BAAA;EAAA,8BAAA;MAAA,wBAAA;UAAA,oBAAA;EACA,yBAAA;MAAA,sBAAA;UAAA,wBAAA;EACA,wBAAA;MAAA,qBAAA;UAAA,4BAAA;EACA,sBAAA;EACA,iBAAA;CACA;AACA;EACA,oBAAA;CACA;AACA;EACA,eAAA;EACA,iBAAA;CACA;AACA;EACA,uBAAA;CACA",file:"Todo.vue",sourcesContent:['<template>\r\n  <section class="todolist">\r\n    <header class="todolist__header">\r\n      <input type="text" placeholder="添加新任务" v-model="newTodo" @keyup.enter="addTodo">\r\n    </header>\r\n    <article class="todolist__main">\r\n      <div>\r\n        <label>完成全部任务<input type="checkbox" v-model="allDone"></label>\r\n      </div>\r\n      <ul>\r\n        <li v-for="todo in filteredTodolist" :key="todo.id" :class="{completed: todo.completed, editing: todo === editing}">\r\n          <label @dblclick="editTodo(todo)"><input type="checkbox" v-model="todo.completed"> {{ todo.name }}</label>\r\n          <button @click.prevent="deleteTodo(todo)">删除</button>\r\n          <input type="text" v-model="todo.name" @keyup.esc="cancelEditTodo" v-focus="todo === editing">\r\n        </li>\r\n      </ul>\r\n    </article>\r\n    <footer class="todolist__footer" v-show="hasTodo">\r\n      <span>总共{{ remaining }}个任务</span>\r\n      <button v-show="completedTodo" @click.prevent="deleteCompletedTodo">删除所有待办任务</button>\r\n      <ul>\r\n        <li><a href="#" :class="{active: filter === \'all\'}" @click.prevent="filter = \'all\'">所有</a></li>\r\n        <li><a href="#" :class="{active: filter === \'todo\'}" @click.prevent="filter = \'todo\'">待办</a></li>\r\n        <li><a href="#" :class="{active: filter === \'done\'}" @click.prevent="filter = \'done\'">完成</a></li>\r\n      </ul>\r\n    </footer>\r\n  </section>\r\n</template>\r\n\r\n<script>\r\n  import Vue from \'vue\'\r\n  export default {\r\n    data () {\r\n      return {\r\n        todolist: [],\r\n        newTodo: \'\',\r\n        obsoleteTodo: \'\',\r\n        filter: \'all\',\r\n        editing: null\r\n      }\r\n    },\r\n    methods: {\r\n      addTodo () {\r\n        if (this.newTodo) this.todolist.push({name: this.newTodo, completed: false})\r\n        this.newTodo = \'\'\r\n      },\r\n      deleteTodo (todo) {\r\n        this.todolist = this.todolist.filter(t => t !== todo)\r\n      },\r\n      deleteCompletedTodo () {\r\n        this.todolist = this.todolist.filter(todo => !todo.completed)\r\n      },\r\n      editTodo (todo) {\r\n        this.editing = todo\r\n        this.obsoleteTodo = todo.name\r\n      },\r\n      doneTodo (todo) {\r\n        if (todo.name) this.editing = null\r\n      },\r\n      cancelEditTodo () {\r\n        this.editing.name = this.obsoleteTodo\r\n        this.doneTodo()\r\n      }\r\n    },\r\n    computed: {\r\n      allDone: {\r\n        get () {\r\n          return this.remaining === 0\r\n        },\r\n        set (value) {\r\n          this.todolist.forEach(todo => { todo.completed = value })\r\n        }\r\n      },\r\n      remaining () {\r\n        return this.todolist.filter(todo => !todo.completed).length\r\n      },\r\n      completedTodo () {\r\n        return this.todolist.filter(todo => todo.completed).length\r\n      },\r\n      filteredTodolist () {\r\n        if (this.filter === \'todo\') {\r\n          return this.todolist.filter(todo => !todo.completed)\r\n        } else if (this.filter === \'done\') {\r\n          return this.todolist.filter(todo => todo.completed)\r\n        }\r\n        return this.todolist\r\n      },\r\n      hasTodo () {\r\n        return this.todolist.length > 0\r\n      }\r\n    },\r\n    directives: {\r\n      focus (el, val) {\r\n        if (val) {\r\n          Vue.nextTick(_ => { el.focus() })\r\n        }\r\n      }\r\n    }\r\n  }\r\n<\/script>\r\n\r\n<style>\r\n  :root{\r\n    font: 14px/1.4 -apple-system, BlinkMacSystemFont,\r\n    Segoe UI, Helvetica, Arial, sans-serif,\r\n    Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol;\r\n  }\r\n  .todolist {\r\n    display: inline-block;\r\n    vertical-align: top;\r\n    max-width: 200px;\r\n    width: 100%;\r\n    padding: 20px;\r\n  }\r\n  .todolist a, .todolist input, .todolist button {\r\n    border: 1px solid #ddd;\r\n    border-radius: 3px;\r\n  }\r\n  .todolist a {\r\n    text-decoration: none;\r\n    color: #2d2d2d;\r\n  }\r\n  .todolist input {\r\n    padding: 2px 4px;\r\n    line-height: 1;\r\n    font-size: 16px;\r\n    color: #2d2d2d;\r\n    outline: none;\r\n  }\r\n  .todolist input:hover, .todolist input:focus {\r\n    border-color: #9e9e9e;\r\n  }\r\n  .todolist button {\r\n    padding: 0 4px;\r\n    border-color: #ff0000;\r\n    line-height: 1;\r\n    font-size: 12px;\r\n    color: #ff0000;\r\n    outline: none;\r\n  }\r\n  .todolist label, .todolist button {\r\n    cursor: pointer;\r\n  }\r\n  .todolist__header {\r\n    margin-bottom: 10px;\r\n  }\r\n  .todolist__main {\r\n    margin-bottom: 10px;\r\n  }\r\n  .todolist__main div {\r\n    margin-bottom: 5px;\r\n  }\r\n  .todolist__main li {\r\n    display: flex;\r\n    flex-direction: row;\r\n    align-items: center;\r\n    padding: 5px 0;\r\n    border-bottom: 1px solid #ddd;\r\n    position: relative;\r\n  }\r\n  .todolist__main li label {\r\n    position: relative;\r\n    z-index: 1;\r\n  }\r\n  .todolist__main li button {\r\n    display: none;\r\n    margin-left: 5px;\r\n    position: relative;\r\n    z-index: 1;\r\n  }\r\n  .todolist__main li input[type=text] {\r\n    display: none;\r\n    width: 100%;\r\n    height: 100%;\r\n    position: absolute;\r\n    top: 0;\r\n    left: 0;\r\n    z-index: 2;\r\n    border: 0;\r\n  }\r\n  .todolist__main li:hover button {\r\n    display: block;\r\n  }\r\n  .todolist__main li.completed label {\r\n    text-decoration: line-through;\r\n  }\r\n  .todolist__main li.editing input[type=text] {\r\n    display: block;\r\n  }\r\n  .todolist__footer ul {\r\n    display: flex;\r\n    flex-direction: row;\r\n    align-items: flex-start;\r\n    justify-content: flex-start;\r\n    list-style-type: none;\r\n    margin-top: 10px;\r\n  }\r\n  .todolist__footer li {\r\n    padding-right: 10px;\r\n  }\r\n  .todolist__footer a {\r\n    display: block;\r\n    padding: 2px 4px;\r\n  }\r\n  .todolist__footer a:hover, .todolist__footer a.active {\r\n    background-color: #ddd;\r\n  }\r\n</style>\r\n'],sourceRoot:""}])},jdtc:function(t,o,n){"use strict";Object.defineProperty(o,"__esModule",{value:!0});var e=n("7+uW"),i={data:function(){return{todolist:[],newTodo:"",obsoleteTodo:"",filter:"all",editing:null}},methods:{addTodo:function(){this.newTodo&&this.todolist.push({name:this.newTodo,completed:!1}),this.newTodo=""},deleteTodo:function(t){this.todolist=this.todolist.filter(function(o){return o!==t})},deleteCompletedTodo:function(){this.todolist=this.todolist.filter(function(t){return!t.completed})},editTodo:function(t){this.editing=t,this.obsoleteTodo=t.name},doneTodo:function(t){t.name&&(this.editing=null)},cancelEditTodo:function(){this.editing.name=this.obsoleteTodo,this.doneTodo()}},computed:{allDone:{get:function(){return 0===this.remaining},set:function(t){this.todolist.forEach(function(o){o.completed=t})}},remaining:function(){return this.todolist.filter(function(t){return!t.completed}).length},completedTodo:function(){return this.todolist.filter(function(t){return t.completed}).length},filteredTodolist:function(){return"todo"===this.filter?this.todolist.filter(function(t){return!t.completed}):"done"===this.filter?this.todolist.filter(function(t){return t.completed}):this.todolist},hasTodo:function(){return this.todolist.length>0}},directives:{focus:function(t,o){o&&e.default.nextTick(function(o){t.focus()})}}},r=function(){var t=this,o=t.$createElement,n=t._self._c||o;return n("section",{staticClass:"todolist"},[n("header",{staticClass:"todolist__header"},[n("input",{directives:[{name:"model",rawName:"v-model",value:t.newTodo,expression:"newTodo"}],attrs:{type:"text",placeholder:"添加新任务"},domProps:{value:t.newTodo},on:{keyup:function(o){return!o.type.indexOf("key")&&t._k(o.keyCode,"enter",13,o.key,"Enter")?null:t.addTodo(o)},input:function(o){o.target.composing||(t.newTodo=o.target.value)}}})]),t._v(" "),n("article",{staticClass:"todolist__main"},[n("div",[n("label",[t._v("完成全部任务"),n("input",{directives:[{name:"model",rawName:"v-model",value:t.allDone,expression:"allDone"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(t.allDone)?t._i(t.allDone,null)>-1:t.allDone},on:{change:function(o){var n=t.allDone,e=o.target,i=!!e.checked;if(Array.isArray(n)){var r=t._i(n,null);e.checked?r<0&&(t.allDone=n.concat([null])):r>-1&&(t.allDone=n.slice(0,r).concat(n.slice(r+1)))}else t.allDone=i}}})])]),t._v(" "),n("ul",t._l(t.filteredTodolist,function(o){return n("li",{key:o.id,class:{completed:o.completed,editing:o===t.editing}},[n("label",{on:{dblclick:function(n){return t.editTodo(o)}}},[n("input",{directives:[{name:"model",rawName:"v-model",value:o.completed,expression:"todo.completed"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(o.completed)?t._i(o.completed,null)>-1:o.completed},on:{change:function(n){var e=o.completed,i=n.target,r=!!i.checked;if(Array.isArray(e)){var l=t._i(e,null);i.checked?l<0&&t.$set(o,"completed",e.concat([null])):l>-1&&t.$set(o,"completed",e.slice(0,l).concat(e.slice(l+1)))}else t.$set(o,"completed",r)}}}),t._v(" "+t._s(o.name))]),t._v(" "),n("button",{on:{click:function(n){return n.preventDefault(),t.deleteTodo(o)}}},[t._v("删除")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:o.name,expression:"todo.name"},{name:"focus",rawName:"v-focus",value:o===t.editing,expression:"todo === editing"}],attrs:{type:"text"},domProps:{value:o.name},on:{keyup:function(o){return!o.type.indexOf("key")&&t._k(o.keyCode,"esc",27,o.key,["Esc","Escape"])?null:t.cancelEditTodo(o)},input:function(n){n.target.composing||t.$set(o,"name",n.target.value)}}})])}),0)]),t._v(" "),n("footer",{directives:[{name:"show",rawName:"v-show",value:t.hasTodo,expression:"hasTodo"}],staticClass:"todolist__footer"},[n("span",[t._v("总共"+t._s(t.remaining)+"个任务")]),t._v(" "),n("button",{directives:[{name:"show",rawName:"v-show",value:t.completedTodo,expression:"completedTodo"}],on:{click:function(o){return o.preventDefault(),t.deleteCompletedTodo(o)}}},[t._v("删除所有待办任务")]),t._v(" "),n("ul",[n("li",[n("a",{class:{active:"all"===t.filter},attrs:{href:"#"},on:{click:function(o){o.preventDefault(),t.filter="all"}}},[t._v("所有")])]),t._v(" "),n("li",[n("a",{class:{active:"todo"===t.filter},attrs:{href:"#"},on:{click:function(o){o.preventDefault(),t.filter="todo"}}},[t._v("待办")])]),t._v(" "),n("li",[n("a",{class:{active:"done"===t.filter},attrs:{href:"#"},on:{click:function(o){o.preventDefault(),t.filter="done"}}},[t._v("完成")])])])])])};r._withStripped=!0;var l={render:r,staticRenderFns:[]},A=l;var d=!1;var s=n("VU/8")(i,A,!1,function(t){d||n("AGPb")},null,null);s.options.__file="src/views/project/todolist/Todo.vue";o.default=s.exports}});
//# sourceMappingURL=21.8cbcbe3c33239abdc487.js.map