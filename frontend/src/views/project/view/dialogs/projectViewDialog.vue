<template>
  <div>
    <el-button type="text" @click="dialogVisible = true">点击打开 Dialog</el-button>
    <el-dialog
      center
      title="项目详细信息"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose">
<!--对话框表单信息-->
      <span>
        <dialogContent :projectInfo="projectInfo" :memberInfo="memberInfo"></dialogContent>
      </span>
<!--对话框底部按钮-->
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>

    </el-dialog>
  </div>
</template>

<script>
import dialogContent from './dialogContent'

export default {
  name: 'projectViewDialog',
  props: ['projectInfo', 'memberInfo'],
  components: {dialogContent},
  data() {
    return {
      dialogVisible: false
    }
  },
  mounted() {
    console.log('我是dialogContent')
    console.log(this.projectInfo)
    console.log(this.projectInfo)
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    }
  }
};
</script>
