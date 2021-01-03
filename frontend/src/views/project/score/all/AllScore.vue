<template>

  <div>
    <!--  所有成绩信息的表格-->
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

    <!--  编辑成绩的对话框-->
    <el-dialog
      title="修改成绩"
      :visible.sync="editDialogVisible"
      width="60%"
      center>

    </el-dialog>
  </div>

</template>

<script>
export default {
  methods: {
    // 处理老师修改成绩事件
    handleEdit(row) {
      this.editDialogVisible = true
      this.editingRow = row
    },

  },

  mounted() {
    let that = this
    this.$get('project/stu_score').then(r=>{
      that.tableData = r.data.data.stuScore
    })
  },

  data() {
    return {
      // 表中的数据-所有同学的成绩信息
      tableData: [],
      // 被编辑后的这一位同学的成绩成员信息
      editedScore: {

      },
      // 编辑成绩对话框的可见性
      editDialogVisible: false,
      // 当前正在编辑的那一行的所有字段
      editingRow: {}
    }
  }
}
</script>
