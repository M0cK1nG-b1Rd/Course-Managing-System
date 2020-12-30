<template>
  <div>
<!--    页面头部信息-->
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-light header" >创建项目</div></el-col>
    </el-row>
<!--    项目基本信息表单-->
    <el-form ref="projectForm" :model="formData" label-width="80px">
      <el-form-item label="项目名称">
        <el-input v-model="formData.projectName" placeholder="填写项目名称"></el-input>
      </el-form-item>
      <el-form-item  label="负责人">
        <el-col :span="12">
          <el-input v-model="formData.managerName" placeholder="项目经理姓名"></el-input>
        </el-col>
        <el-col :span="12">
          <el-input v-model="formData.teacherName" placeholder="指导老师姓名"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="项目类型">
        <el-select v-model="formData.projectType" placeholder="请选择项目类型">
          <el-option label="web应用开发" value="web"></el-option>
          <el-option label="桌面应用开发" value="desktop"></el-option>
          <el-option label="微信小程序开发" value="wechat"></el-option>
          <el-option label="AI算法应用" value="ai"></el-option>
          <el-option label="其他类型" value="other"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="项目时间">
        <el-col :span="12">
          <el-date-picker type="date" placeholder="开始时间"
                          v-model="formData.startTime"
                          style="width: 100%;"
                          format="yyyy 年 MM 月 dd 日"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-col>
        <el-col class="line" :span="2"><span> </span></el-col>
        <el-col :span="12">
          <el-date-picker type="date" placeholder="选择日期"
                          v-model="formData.endTime"
                          style="width: 100%;"
                          format="yyyy 年 MM 月 dd 日"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="特殊资源">
        <el-radio-group v-model="resource">
          <el-radio label="服务器设备"></el-radio>
          <el-radio label="人力资源支持"></el-radio>
          <el-radio label="其他资源"></el-radio>
          <el-radio label="无需"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="项目描述">
        <el-input type="textarea" v-model="formData.projectDesc" placeholder="介绍一下你的项目吧"></el-input>
      </el-form-item>
<!--      添加项目成员信息-->
      <el-form-item >
        <div>
          <!-- 添加新成员 -->
          <el-row :gutter="20">
            <el-col :span="8">
              <el-button type="primary" @click="addDialogVisible = true">添加新成员</el-button>
            </el-col>
          </el-row>
          <!-- 用户列表区域 -->
          <el-row>
            <el-table :data="memberList" border stripe>
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
          </el-row>

          <!-- 添加用户的对话框 -->
          <el-dialog title="添加新成员" :visible.sync="addDialogVisible" width="25%" @close="addDialogClosed">
            <!-- 内容主体区域 -->
            <el-form  :model="newMemberInfo" ref="addFormRef" label-width="70px">
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
      </el-form-item>
<!--      底部按钮-->
      <el-form-item>
        <el-button type="success" @click="onSubmit">立即创建</el-button>
        <el-button type="danger" @click="resetForm('projectForm')">重置表单</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script>

export default {
  name: 'ProjectCreate',
  data() {
    return {
      // 控制添加用户对话框的显示与隐藏
      addDialogVisible: false,
      // 表单中的内容
      formData: {
        projectName: '',
        projectType: '',
        startTime: '',
        endTime: '',
        projectDesc: '',
        managerName: '',
        teacherName: '',
      },
      // 成员详细信息
      memberList: [],
      // 一个成员的详细信息
      newMemberInfo: {
        name: '',
        class: '',
        sno: '',
        position: ''
      },
      // 需要的特殊资源，不必传给后端，仅在前端展示
      resource: ''
    }
  },
  methods: {
    // 添加新成员相关的函数
    // 按照学号删除成员信息
    removeUserBySno(sno){
      for(let i = 0; i<this.memberList.length; i++){
        if(this.memberList[i].sno == sno){
          this.memberList.splice(i,1)
        }
      }
    },

    // 监听添加用户对话框的关闭事件,清空表单
    addDialogClosed() {
      console.log('表单关闭并清空')
      // this.$refs.addFormRef.resetFields()
      this.newMemberInfo={
        name: '',
          class: '',
          sno: '',
          position: ''
      }
    },

    // 点击按钮，添加新用户
    addMemberCommit(info) {
      console.log('新用户的信息')
      // 向memberList中添加新创建的成员信息
      console.log(info)
      console.log('添加前的memberList')
      console.log(this.memberList)
      this.memberList.push(info)
      console.log('添加后memberList')
      console.log(this.memberList)
      // 通知添加成功
      this.$message.success('添加新成员成功！')
      // 隐藏添加用户的对话框
      this.addDialogVisible = false
    },

    // 点击取消按钮，清空表单内容
    resetForm(form) {
      console.log(form)
      this.formData= {
        projectName: '',
          projectType: '',
          startTime: '',
          endTime: '',
          projectDesc: '',
          managerName: '',
          teacherName: ''
      }
      this.memberList = []
      this.resource = ''
      console.log('重置成功')
    },
    // 向后台提交新项目数据
    onSubmit() {
      console.log('submit!')
      let data = this.formData
      let list = this.memberList
      console.log('项目信息')
      console.log(data)
      // POST发送项目信息表单
      this.$post('/project/new',{data}).then(
        (r) => {
          this.$message.success('项目基本信息添加成功！')
        }).catch((err) => {
        this.$message.error('项目基本信息添加失败！')
      })

      console.log('项目成员')
      console.log(list)
      // POST发送成员信息列表
      this.$post('/project/new',{list}).then(
        (r) => {
          this.$message.success('项目成员信息添加成功！')
        }).catch((err) => {
        this.$message.error('项目成员信息添加失败！')
      })
    }
  }
}
</script>

<style>
.bg-purple-light {
  background: #61bcd1;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
/*header样式*/
.header {
  font-size: 20px;
  font-weight: bold;
  text-align: center;
}
</style>
