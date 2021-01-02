<template>
  <div style="width: 100%">

<!--    所有项目信息的表格-->
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
        width="180px">
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

    <!--    编辑项目信息时的对话框-->
    <el-dialog
      title="修改项目信息"
      :visible.sync="EidtDialogVisible"
      width="60%"
      center>

      <div>
        <!--    项目基本信息表单-->
        <el-form ref="projectForm" :model="projectInfo" label-width="80px" inline >
          <el-form-item label="项目名称" >
            <el-input v-model="projectInfo.projectName" style="width: 565px"></el-input>
          </el-form-item>
          <el-form-item label="项目经理">
            <el-input v-model="projectInfo.managerName" style="width: 235px"></el-input>
          </el-form-item>
          <el-form-item label="指导老师">
            <el-input v-model="projectInfo.teacherName" style="width: 235px"></el-input>
          </el-form-item>
          <el-form-item label="项目类型">
            <el-input v-model="projectInfo.projectType" style="width: 235px"></el-input>
          </el-form-item>
          <el-form-item label="特殊资源">
            <el-input v-model="resource" style="width: 235px"></el-input>
          </el-form-item>
          <el-form-item label="开始时间">
            <el-date-picker type="date"
                            v-model="projectInfo.startTime"
                            style="width: 235px;"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="开始时间">
            <el-date-picker type="date"
                            v-model="projectInfo.endTime"
                            style="width: 235px;"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="项目描述">
            <el-input type="textarea" v-model="projectInfo.projectDesc" style="width: 565px"></el-input>
          </el-form-item>
          <el-form-item label="项目成员">
            <div>
              <!-- 用户列表区域 -->
                <el-table :data="memberInfo" border stripe>
                  <el-table-column label="姓名" prop="tuserInfo.name" width="110px" align="center"></el-table-column>
                  <el-table-column label="班级" prop="tuserInfo.class" width="110px" align="center"></el-table-column>
                  <el-table-column label="学号" prop="sid" width="135px" align="center"></el-table-column>
                  <el-table-column label="岗位" prop="position" width="160px" align="center"></el-table-column>
                  <el-table-column label="操作" width="130px" align="center">
                    <template slot-scope="scope">
                      <!-- 增加成员按钮 -->
                      <el-button type="primary" icon="el-icon-plus" size="mini" circle
                                 @click="addDialogVisible=true"></el-button>
                      <!-- 删除成员按钮 -->
                      <el-button type="danger" icon="el-icon-delete" size="mini" circle
                                 @click="removeUserBySno(scope.row.sid)"></el-button>
                    </template>
                  </el-table-column>
                </el-table>
            </div>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="EidtDialogVisible = false">取消修改</el-button>
        <el-button type="primary" @click="onEditSubmit()">保存修改</el-button>
      </span>
    </el-dialog>



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
    <!--  编辑项目信息并操作增加用户的行为时出现的对话框-->
    <el-dialog title="添加新成员" :visible.sync="addDialogVisible" width="30%" @close="addDialogClosed">
      <!-- 内容主体区域 -->
      <el-form :model="newMemberInfo" ref="addFormRef" label-width="70px">
        <!--选择班级-->
        <el-form-item label="班级" prop="class">
          <el-select v-model="newMemberInfo.tuserInfo.class"
                     placeholder="选择成员所在班级" clearable
                     size="medium">
            <el-option
              v-for="item in classList"
              :key="item.class"
              :label="item.class"
              :value="item.class">
            </el-option>
          </el-select>
          <!--选择姓名-->
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-select v-model="newMemberInfo.tuserInfo.name"
                     placeholder="选择成员姓名" clearable
                     size="medium">
            <el-option
              v-for="item in selectorInfo"
              v-if="newMemberInfo.tuserInfo.class==item.class"
              :key="item.name"
              :label="item.name"
              :value="item.name">
            </el-option>
          </el-select>
          <!--选择学号-->
        </el-form-item>
        <el-form-item label="学号" prop="sid">
          <el-select v-model="newMemberInfo.sid"
                     placeholder="成员学号" clearable
                     size="medium">
            <el-option
              v-for="item in selectorInfo"
              v-if="newMemberInfo.tuserInfo.name==item.name"
              :key="item.sid"
              :label="item.sid"
              :value="item.sid">
            </el-option>
          </el-select>
          <!--选择角色-->
        </el-form-item>
        <el-form-item label="角色" prop="position">
          <el-select v-model="newMemberInfo.position"
                     placeholder="可通过输入创建新选项"
                     allow-create filterable clearable
                     size="medium">
            <el-option
              v-for="item in positionOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <!-- 对话框底部区域 -->
      <span slot="footer" class="dialog-footer">
              <el-button @click="addDialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="addMemberCommit(newMemberInfo)">确 定</el-button>
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
      this.ViewDialogVisible = true
    },

    // 处理点击修改项目信息的事件
    handleEditClick(row) {
      this.editRow = row
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
      this.EidtDialogVisible = true
    },

    // 处理提交编辑项目信息请求
    onEditSubmit(row) {
      let that =this
      let pid = this.editRow.pid
      // 隐藏编辑项目信息对话框
      this.EidtDialogVisible = false
      // 向后台发送编辑后的项目基本信息
      this.$put(`project?pid=${pid}`, that.projectInfo).then((r)=>{
        this.$message.success('项目基本信息修改成功！')
      })
      // 向后台发送编辑后的项目成员信息
      let memberInfo = []
      for(let i =0; i<this.memberInfo.length; i++){
        memberInfo[i] = {}
        memberInfo[i].sid = this.memberInfo[i].sid
        memberInfo[i].position = this.memberInfo[i].position
      }
      console.log('BUG')
      console.log(memberInfo)
      let data={"pid":pid, member:memberInfo}
      this.$put(`project/member_info?pid=${pid}`,data).then((r)=>{
        this.$message.success('项目成员信息修改成功！')
      })
      //
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
    },
    // 编辑项目信息相关的函数
    // 按照学号删除成员信息
    removeUserBySno (sno) {
      for (let i = 0; i < this.memberInfo.length; i++) {
        if (this.memberInfo[i].sid === sno) {
          this.memberInfo.splice(i, 1)
        }
      }
    },
    // 监听添加用户对话框的关闭事件,清空表单
    addDialogClosed () {
      this.newMemberInfo = {
        sid: '',
        position: '',
        tuserInfo: {
          name: '',
          class: ''
        }
      }
    },
    // 点击按钮，添加新用户
    addMemberCommit (info) {
      // 向memberInfo中添加新创建的成员信息
      this.memberInfo.push(info)
      // 通知添加成功
      this.$message.success('添加新成员成功！')
      // 隐藏添加用户的对话框
      this.addDialogVisible = false
    },
  },
  data() {
    return {
      // 正在编辑的项目的信息
      editRow: {},
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
      // 控制添加用户对话框的显示与隐藏
      addDialogVisible: false,
      // 需要被删除的行内容
      deleteRow: {},
      // 需要的特殊资源，不必传给后端，仅在前端展示
      resource: '服务器算力资源',
      // 新增成员时，存储新成员信息
      newMemberInfo: {
        sid: '',
        position: '',
        tuserInfo: {
          name: '',
          class: ''
        }
      },
      //新的后端传回的Pid
      createdPid:'',
      // 岗位选择器的选项
      positionOptions: [
        {
          value: '项目经理',
          label: '项目经理'
        },{
          value: '系统设计师',
          label: '系统设计师'
        },{
          value: '系统分析师',
          label: '系统分析师'
        },{
          value: '前端工程师',
          label: '前端工程师'
        },{
          value: '后端工程师',
          label: '后端工程师'
        },{
          value: '测试工程师',
          label: '测试工程师'
        },{
          value: '文档管理员',
          label: '文档管理员'
        },{
          value: '数据库管理员',
          label: '数据库管理员'
        }
      ],
      // 所有班级列表,升序排序,每个班级包括value和label两个字段
      classList: [],
      // 新成员姓名、班级、学号选择器选项
      selectorInfo: []

    }
  },
  mounted () {
    let that = this
    // 获得所有项目的概要信息，用于表格填充
    this.$get('project/all').then((r) => {
      this.tableData = r.data.data
    }),
    // 获取班级列表
    this.$get('project/all_class').then((r)=>{
      that.classList = r.data.data
      that.classList = that.classList.reverse()
    })
    // 获取学生信息
    this.$get('project/all_stu').then((r)=>{
      that.selectorInfo = r.data.data
    })
  },
  // updated() {
  //   this.$get('project/all').then((r) => {
  //     this.tableData = r.data.data
  //   })
  // }
}
</script>

<style scoped>

</style>
