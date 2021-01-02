<template>
  <div style="width: 100%">
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
        width="145">
        <template slot-scope="scope">
          <!--        查看按钮-->
          <el-tooltip class="item" effect="dark" content="查看项目细节" placement="top">
            <el-button @click="handleViewClick(scope.row)"
                       size="mini" type="success"
                       icon="el-icon-view" circle >
            </el-button>
          </el-tooltip>
          <!--        编辑按钮-->
          <el-tooltip class="item" effect="dark" content="修改项目信息" placement="top">
            <el-button @click="handleEditClick(scope.row)"
                       size="mini" type="primary"
                       icon="el-icon-edit" circle >
            </el-button>
          </el-tooltip>
          <!--        删除按钮-->
          <el-tooltip class="item" effect="dark" content="删除该项目" placement="top">
            <el-button @click="handleDeleteClick(scope.row)"
                       size="mini" type="danger"
                       icon="el-icon-delete" circle >
            </el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <!--  查看项目细节对话框组件-->
    <div>
      <el-dialog
        center
        title="项目详细信息"
        :visible.sync="ViewDialogVisible"
        width="50%">
        <!--对话框表单信息-->
        <span>
        <div>
          <!--    项目基本信息表单-->
          <el-form ref="projectForm" :model="projectInfo" label-width="80px" inline >
            <el-form-item label="项目名称" >
              <el-input v-model="projectInfo.projectName" style="width: 485px" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目经理">
              <el-input v-model="projectInfo.managerName" disabled></el-input>
            </el-form-item>
            <el-form-item label="指导老师">
              <el-input v-model="projectInfo.teacherName" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目类型">
              <el-input v-model="projectInfo.projectType" disabled></el-input>
            </el-form-item>
            <el-form-item label="特殊资源">
              <el-input v-model="resource" disabled></el-input>
            </el-form-item>
            <el-form-item label="开始时间">
                <el-date-picker type="date"
                                disabled
                                v-model="projectInfo.startTime"
                                style="width: 195px;"
                                format="yyyy 年 MM 月 dd 日"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-form-item>
                <el-form-item label="开始时间">
                <el-date-picker type="date"
                                disabled
                                v-model="projectInfo.endTime"
                                style="width: 195px;"
                                format="yyyy 年 MM 月 dd 日"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="项目描述">
              <el-input type="textarea" v-model="projectInfo.projectDesc" style="width: 485px" disabled></el-input>
            </el-form-item>
            <el-form-item label="项目成员">
              <div>
                <!-- 用户列表区域 -->
                <el-row>
                  <el-table :data="memberInfo" border stripe disabled>
                    <el-table-column label="姓名" prop="tuserInfo.name" width="100px" align="center"></el-table-column>
                    <el-table-column label="班级" prop="tuserInfo.class" width="100px" align="center"></el-table-column>
                    <el-table-column label="学号" prop="sid" width="135px" align="center"></el-table-column>
                    <el-table-column label="岗位" prop="position" width="150px" align="center"></el-table-column>
                  </el-table>
                </el-row>
              </div>
            </el-form-item>
          </el-form>
        </div>
      </span>
        <!--对话框底部按钮-->
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="ViewDialogVisible = false">确 定</el-button>
      </span>

      </el-dialog>
    </div>
    <!--  删除项目警告对话框组件-->
    <el-dialog
      title="注意"
      :visible.sync="DeleteDialogVisible"
      width="30%"
      center>
      <span>&nbsp&nbsp项目删除后不可恢复，请谨慎操作！</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="DeleteDialogVisible = false">取 消</el-button>
    <el-button type="warning" @click="deleteProject(deleteRow)">确 定</el-button>
  </span>
    </el-dialog>
  </div>

</template>

<script>

export default {
  name: 'ProjectList',
  methods: {
    // 处理查看项目细节请求
    handleViewClick(row) {
      this.ViewDialogVisible = true
      let that = this
      let pid = row.pid
      // 获取当前项目的基本信息
      this.$get(`project/all?pid=${pid}`).then(r=>{
        that.projectInfo = r.data.data[0]
      })
      console.log(this.projectInfo)
      // 获取当前项目成员信息
      this.$get(`project/all_member_info?pid=${pid}`).then(r=>{
        this.memberInfo = r.data.data
      })
      console.log(this.memberInfo)
    },

    // 处理编辑项目信息请求
    handleEditClick(row) {
      // this.$get('project/all_member_info').then(r=>{
      //   // console.log(r)
      // })
    },
    // 处理删除项目信息请求
    handleDeleteClick(row) {
      this.deleteRow = row
      this.DeleteDialogVisible = true
    },
    // 点击警告对话框中的确认删除后，删除项目的操作
    deleteProject(row) {
      this.$delete(`project?pid=${row.pid}`).then(r=>{
        this.$message.success('该项目已成功删除！')
      })
      this.DeleteDialogVisible = false
    }
  },
  data() {
    return {
      // 表格内容信息，包含所有项目的简要信息，不含成员信息
      tableData: [],
      // 当前查看的这一个项目基本信息
      projectInfo: {},
      // 成员信息
      memberInfo: [],
      // 查看项目细节对话框可见性
      ViewDialogVisible: false,
      // 编辑项目细节对话框可见性
      EidtDialogVisible: false,
      // 删除项目细节对话框可见性
      DeleteDialogVisible: false,
      // 需要被删除的行内容
      deleteRow: {},
      // 需要的特殊资源，不必传给后端，仅在前端展示
      resource: '服务器算力资源'

    }
  },
  mounted () {
    // 获得所有项目的概要信息，用于表格填充
    this.$get('project/all').then((r) => {
      this.tableData = r.data.data
    })
  }
  // updated() {
  //   this.$get('project/all').then((r) => {
  //     this.tableData = r.data.data
  //   })
  // }
}
</script>

<style scoped>

</style>
