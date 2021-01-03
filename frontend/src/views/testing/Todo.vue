<template>
  <section class="todolist">
    <header class="todolist__header">
      <input type="text" placeholder="add a new todo" v-model="newTodo" @keyup.enter="addTodo">
    </header>
    <article class="todolist__main">
      <div>
        <label>all as done <input type="checkbox" v-model="allDone"></label>
      </div>
      <ul>
        <li v-for="todo in filteredTodolist" :key="todo.id" :class="{completed: todo.completed, editing: todo === editing}">
          <label @dblclick="editTodo(todo)"><input type="checkbox" v-model="todo.completed"> {{ todo.name }}</label>
          <button @click.prevent="deleteTodo(todo)">delete</button>
          <input type="text" v-model="todo.name" @keyup.enter="doneEditTodo(todo)" @blur="doneEditTodo(todo)" @keyup.esc="cancelEditTodo" v-focus="todo === editing">
        </li>
      </ul>
    </article>
    <footer class="todolist__footer" v-show="hasTodo">
      <span>{{ remaining }} todolist</span>
      <button v-show="completedTodo" @click.prevent="deleteCompletedTodo">delete all todolist</button>
      <ul>
        <li><a href="#" :class="{active: filter === 'all'}" @click.prevent="filter = 'all'">all</a></li>
        <li><a href="#" :class="{active: filter === 'todo'}" @click.prevent="filter = 'todo'">to do</a></li>
        <li><a href="#" :class="{active: filter === 'done'}" @click.prevent="filter = 'done'">done</a></li>
      </ul>
    </footer>
  </section>
</template>

<script>
  import Vue from 'vue'
  export default {
    data () {
      return {
        todolist: [],
        newTodo: '',
        obsoleteTodo: '',
        filter: 'all',
        editing: null
      }
    },
    methods: {
      addTodo () {
        if (this.newTodo) this.todolist.push({name: this.newTodo, completed: false})
        this.newTodo = ''
      },
      deleteTodo (todo) {
        this.todolist = this.todolist.filter(t => t !== todo)
      },
      deleteCompletedTodo () {
        this.todolist = this.todolist.filter(todo => !todo.completed)
      },
      editTodo (todo) {
        this.editing = todo
        this.obsoleteTodo = todo.name
      },
      doneTodo (todo) {
        if (todo.name) this.editing = null
      },
      cancelEditTodo () {
        this.editing.name = this.obsoleteTodo
        this.doneTodo()
      }
    },
    computed: {
      allDone: {
        get () {
          return this.remaining === 0
        },
        set (value) {
          this.todolist.forEach(todo => { todo.completed = value })
        }
      },
      remaining () {
        return this.todolist.filter(todo => !todo.completed).length
      },
      completedTodo () {
        return this.todolist.filter(todo => todo.completed).length
      },
      filteredTodolist () {
        if (this.filter === 'todo') {
          return this.todolist.filter(todo => !todo.completed)
        } else if (this.filter === 'done') {
          return this.todolist.filter(todo => todo.completed)
        }
        return this.todolist
      },
      hasTodo () {
        return this.todolist.length > 0
      }
    },
    directives: {
      focus (el, val) {
        if (val) {
          Vue.nextTick(_ => { el.focus() })
        }
      }
    }
  }
</script>

<style>
  :root{
    font: 14px/1.4 -apple-system, BlinkMacSystemFont, Segoe UI, Helvetica, Arial, sans-serif, Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol;
  }
  .todolist {
    display: inline-block;
    vertical-align: top;
    max-width: 200px;
    width: 100%;
    padding: 20px;
  }
  .todolist a, .todolist input, .todolist button {
    border: 1px solid #ddd;
    border-radius: 3px;
  }
  .todolist a {
    text-decoration: none;
    color: #2d2d2d;
  }
  .todolist input {
    padding: 2px 4px;
    line-height: 1;
    font-size: 16px;
    color: #2d2d2d;
    outline: none;
  }
  .todolist input:hover, .todolist input:focus {
    border-color: #9e9e9e;
  }
  .todolist button {
    padding: 0 4px;
    border-color: #ff0000;
    line-height: 1;
    font-size: 12px;
    color: #ff0000;
    outline: none;
  }
  .todolist label, .todolist button {
    cursor: pointer;
  }
  .todolist__header {
    margin-bottom: 10px;
  }
  .todolist__main {
    margin-bottom: 10px;
  }
  .todolist__main div {
    margin-bottom: 5px;
  }
  .todolist__main li {
    display: flex;
    flex-direction: row;
    align-items: center;
    padding: 5px 0;
    border-bottom: 1px solid #ddd;
    position: relative;
  }
  .todolist__main li label {
    position: relative;
    z-index: 1;
  }
  .todolist__main li button {
    display: none;
    margin-left: 5px;
    position: relative;
    z-index: 1;
  }
  .todolist__main li input[type=text] {
    display: none;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 2;
    border: 0;
  }
  .todolist__main li:hover button {
    display: block;
  }
  .todolist__main li.completed label {
    text-decoration: line-through;
  }
  .todolist__main li.editing input[type=text] {
    display: block;
  }
  .todolist__footer ul {
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    list-style-type: none;
    margin-top: 10px;
  }
  .todolist__footer li {
    padding-right: 10px;
  }
  .todolist__footer a {
    display: block;
    padding: 2px 4px;
  }
  .todolist__footer a:hover, .todolist__footer a.active {
    background-color: #ddd;
  }
</style>
