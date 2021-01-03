<template>
  <div style="width: 100%;height: 100%;text-align: center">
    <el-row style="font-weight: bold;font-size: 25px; color: #000c17">
      <dv-decoration-7>任务看板-TodoList</dv-decoration-7>
    </el-row>
    <el-row style="margin-top: 40px">
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员1</div>
        <div><Todo></Todo></div>
      </el-col>
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员2</div>
        <div><Todo></Todo></div>
      </el-col>
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员3</div>
        <div><Todo></Todo></div>
      </el-col>
    </el-row>
    <el-row style="margin-top: 40px">
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员4</div>
        <div><Todo></Todo></div>
      </el-col>
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员5</div>
        <div><Todo></Todo></div>
      </el-col>
      <el-col :span="8">
        <div style="font-size: 20px;font-weight: bolder;color: #1c1e21">成员6</div>
        <div><Todo></Todo></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import Todo from './Todo'
export default {
  name: "Todolist",
  components: {Todo}
}
</script>

<style scoped>

</style>
