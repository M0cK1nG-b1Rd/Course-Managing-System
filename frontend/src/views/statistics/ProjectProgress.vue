<template>
  <div>
    <el-button type="text" @click="editDialogVisible = true">点击打开 Dialog</el-button>
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
  name: 'projectViewDialog',
  data() {
    return {
      // 修改成绩对话框可见性
      editDialogVisible: false,
      // 正在修改的学生的score
      editingScore: {
        sid: '',
        totalScore: '',
        processScore: '',
        docsScore: '',
        completionScore: '',
        presentationScore: '',
        feedback: '',
        isReleased: '0'
      },
    };
  },
  methods: {
    // 点击修改成绩按钮后的处理函数
    handleEdit(row) {
      this.editDialogVisible = true
      this.editingRow = row
    },
    // 关闭对话窗口时的确认
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    //
  },
  mounted() {

  }
};
</script>
