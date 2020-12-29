<template>
  <div>
      <!-- 添加新成员 -->
      <el-row :gutter="20">
        <el-col :span="8">
          <el-button type="primary" @click="addDialogVisible = true">添加新成员</el-button>
        </el-col>
      </el-row>

      <!-- 用户列表区域 -->
      <el-table :data="memberlist" border stripe>
<!--        <el-table-column type="index"></el-table-column>-->
        <el-table-column label="姓名" prop="name" width="100px" align="center"></el-table-column>
        <el-table-column label="班级" prop="class" width="100px" align="center"></el-table-column>
        <el-table-column label="学号" prop="sno" width="150px" align="center"></el-table-column>
        <el-table-column label="岗位" prop="position" width="150px" align="center"></el-table-column>
        <el-table-column label="操作" width="70px" align="center">
          <template slot-scope="scope">
            <!-- 删除按钮 -->
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeUserBySno(scope.row.sno)"></el-button>
          </template>
        </el-table-column>
      </el-table>

    <!-- 添加用户的对话框 -->
    <el-dialog title="添加新成员" :visible.sync="addDialogVisible" width="25%" @close="addDialogClosed">
      <!-- 内容主体区域 -->
      <el-form :model="newMemberInfo"  ref="addFormRef" label-width="70px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="newMemberInfo.name"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="class">
          <el-input v-model="newMemberInfo.class"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="sno">
          <el-input v-model="newMemberInfo.sno"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="position">
          <el-input v-model="newMemberInfo.position"></el-input>
        </el-form-item>
      </el-form>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addMemberCommit(newMemberInfo)">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'addMember',
  data() {

    return {
      // 表格中数据-所有成员信息
      memberList: [],
      // 控制添加用户对话框的显示与隐藏
      addDialogVisible: false,
      // 添加成员的表单数据
      newMemberInfo: {
        name: '',
        class: '',
        sno: '',
        position: ''
      },
    }
  },
  created() {

  },

  methods: {
    // 按照学号删除成员信息
    removeUserBySno(sno){

    },
    // 监听添加用户对话框的关闭事件,清空表单
    addDialogClosed() {
      console.log('表单关闭并清空')
      this.$refs.addFormRef.resetFields()
    },
    // 点击按钮，添加新用户
    addMemberCommit(info) {
      console.log('添加提交')
      // 向memberList中添加新创建的成员信息
      console.log(info)
      this.memberlist.push(this.info)
      console.log(this.memberList)
      // 通知添加成功
      this.$message.success('添加新成员成功！')
      // 隐藏添加用户的对话框
      this.addDialogVisible = false
    }
  }
}
</script>

<style lang="less" scoped>

</style>


