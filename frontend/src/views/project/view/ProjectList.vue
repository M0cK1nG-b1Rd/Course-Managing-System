<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="pid"
      label="项目ID"
      width="80">
    </el-table-column>
    <el-table-column
      prop="projectName"
      label="项目名称"
      width="160">
    </el-table-column>
    <el-table-column
      show-overflow-tooltip
      prop="projectDesc"
      label="项目简介"
      width="160">
    </el-table-column>
    <el-table-column
      prop="projectType"
      label="类型"
      width="120">
    </el-table-column>
    <el-table-column
      prop="managerName"
      label="项目经理"
      width="120">
    </el-table-column>
    <el-table-column
      prop="teacherName"
      label="指导老师"
      width="120">
    </el-table-column>
    <el-table-column
      prop="startTime"
      label="开始时间"
      width="160">
    </el-table-column>
    <el-table-column
      prop="endTime"
      label="结束时间"
      width="160">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'ProjectView',
  methods: {
    handleClick(row) {
      console.log(row);
    }
  },
  data() {
    return {
      tableData: []
    }
  },
  mounted () {
    this.$get('project/all').then((r) => {
      console.log(r.data.data)
      this.tableData = r.data.data

    })
  }
}
</script>



<style scoped>

</style>
