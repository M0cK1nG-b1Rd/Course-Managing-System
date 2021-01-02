<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="tuserInfo.name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="tuserInfo.class"
      label="班级"
      width="120">
    </el-table-column>
    <el-table-column
      prop="sid"
      label="学号"
      width="120">
    </el-table-column>
    <el-table-column
      sortable
      prop="totalScore"
      label="总成绩"
      width="100">
    </el-table-column>
    <el-table-column
      sortable
      prop="processScore"
      label="过程考核"
      width="120">
    </el-table-column>
    <el-table-column
      sortable
      prop="docsScore"
      label="文档报告"
      width="120">
    </el-table-column>
    <el-table-column
      sortable
      prop="completeScore"
      label="完成度"
      width="120">
    </el-table-column>
    <el-table-column
      sortable
      prop="presentationScore"
      label="答辩表现"
      width="120">
    </el-table-column>
    <el-table-column
      prop="feedback"
      label="评价及反馈"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button
          type="primary"
          size="mini"
          icon="el-icon-edit"
          @click="handleEdit(scope.row)">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>

</template>

<script>
export default {
  methods: {
    handleEdit(row) {
      console.log('正在编辑成绩')
      console.log(row);
    }
  },

  mounted() {
    let that = this
    this.$get('project/stu_score').then(r=>{
      that.tableData = r.data.data.stuScore
    })
  },

  data() {
    return {
      tableData: []
    }
  }
}
</script>
