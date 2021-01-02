<template>
  <div>
    <el-dialog
      center
      title="项目详细信息"
      :visible.sync="dialogVisible"
      width="50%">
<!--对话框表单信息-->
      <span>
        <ViewDialogContent :projectInfo="projectInfo" :memberInfo="memberInfo"></ViewDialogContent>
      </span>
<!--对话框底部按钮-->
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>

    </el-dialog>
  </div>
</template>

<script>
import ViewDialogContent from './ViewDialogContent'

export default {
  name: 'projectViewDialog',
  props: ['projectInfo', 'memberInfo','dialogVisible'],
  components: {ViewDialogContent},
  data() {
    return {
    }
  },
  mounted() {
  },
  methods: {

  }
};
</script>
