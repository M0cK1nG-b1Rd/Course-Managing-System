<template xmlns:display="giveScore">

  <el-container>
<!--    设置打分规则-->
    <el-divider content-position="center" ></el-divider>
    <el-header id="setRuleHeader" height="34px">
      <dv-decoration-7>设置打分规则</dv-decoration-7>
    </el-header>
    <div style="margin: 30px 0 0 0">
      <el-main id="setRuleMain">
        <el-form  class="demo-form-inline" label-width="15%" label-position="left">
          <el-form-item label="过程考核">
            <el-col :span="22">
              <el-slider v-model="markRule.process" :step="5" show-stops show-input input-size="mini"></el-slider>
            </el-col>
          </el-form-item>
          <el-form-item label="文档及报告">
            <el-col :span="22">
              <el-slider v-model="markRule.docs" :step="5" show-stops show-input input-size="mini"></el-slider>
            </el-col>
          </el-form-item>
          <el-form-item label="完成情况">
            <el-col :span="22">
              <el-slider v-model="markRule.completion" :step="5" show-stops show-input input-size="mini"></el-slider>
            </el-col>
          </el-form-item>
          <el-form-item label="答辩表现">
            <el-col :span="22">
              <el-slider v-model="markRule.presentation" :step="5" show-stops show-input input-size="mini"></el-slider>
            </el-col>
          </el-form-item>
          <el-form-item><el-button type="primary" size="medium " @click="setMarkRule">完成打分规则设置</el-button></el-form-item>
        </el-form>
      </el-main>
    </div>


<!--    选择打分对象-->
    <el-divider content-position="center"></el-divider>
    <el-header id="selectStuHeader" height="34px">
      <dv-decoration-7>选择打分对象</dv-decoration-7>
    </el-header>
    <el-main id="selectStuMain">
      <!--选择项目-->
        <el-select v-model="markingObj.pid"
                   placeholder="选择项目" clearable
                   size="medium">
          <el-option
            v-for="item in projectOptions"
            :key="item.pid"
            :label="item.projectName"
            :value="item.pid">
          </el-option>
        </el-select>
      <!--选择该项目下的某一个学生，作为打分对象-->
      <el-select v-model="markingObj.sid"
                 placeholder="选择成员姓名" clearable
                 size="medium">
        <el-option
          v-for="item in studentOptions"
          v-if="markingObj.pid==item.pid"
          :key="item.sid"
          :label="item.tuserInfo.name"
          :value="item.sid">
        </el-option>
      </el-select>
    </el-main>

<!--   打分区-->
    <el-divider content-position="center" ></el-divider>
    <el-header id="markHeader" height="34px">
      <dv-decoration-7>开始打分</dv-decoration-7>
    </el-header>
    <el-main id="markMain">
      <el-form  class="demo-form-inline" label-width="15%" label-position="left">
        <el-form-item label="过程考核">
          <el-col :span="22">
            <el-slider v-model="markResult.processScore"
                       show-input input-size="mini" @change="onGiveSubScore">
            </el-slider>
          </el-col>
        </el-form-item>
        <el-form-item label="文档及报告">
          <el-col :span="22">
            <el-slider v-model="markResult.docsScore"
                       show-input input-size="mini" @change="onGiveSubScore">
            </el-slider>
          </el-col>
        </el-form-item>
        <el-form-item label="完成情况">
          <el-col :span="22">
            <el-slider v-model="markResult.completionScore"
                       show-input input-size="mini" @change="onGiveSubScore">
            </el-slider>
          </el-col>
        </el-form-item>
        <el-form-item label="答辩表现">
          <el-col :span="22">
            <el-slider v-model="markResult.presentationScore"
                       show-input input-size="mini" @change="onGiveSubScore">
            </el-slider>
          </el-col>
        </el-form-item>
        <el-form-item label="加权总分">
          <el-col :span="22">
            <a-progress
              :stroke-color="{
                  from: '#03aeff',
                  to: '#87d068',}"
              :percent="markResult.totalScore"
              :format="percent => `${percent} 分`"
              status="active"
            />
          </el-col>
        </el-form-item>
      </el-form>
    </el-main>

<!--   点评区-->
    <el-divider content-position="center" ></el-divider>
    <el-header id="commentHeader" height="34px">
      <dv-decoration-7>点评及反馈</dv-decoration-7>
    </el-header>
    <el-main id="commentMain">
      <el-input
        type="textarea"
        rows="5"
        placeholder="请在此对学生进行点评及反馈"
        v-model="markResult.feedback">
      </el-input>
    </el-main>
    <el-main style="{align-content: center;}">
      <el-form>
        <el-form-item>
          <el-col :span="3">&nbsp</el-col>
          <el-col :span="6">
            <el-popover
              placement="top-start"
              title="温馨提示"
              width="200"
              trigger="hover"
              content="点击按钮后即可提交对当前同学的打分结果。">
              <el-button type="primary" @click="onSubmitScore" slot="reference">提交本次评价</el-button>
            </el-popover>
          </el-col>
          <el-col :span="1">&nbsp</el-col>
          <el-col :span="6">
            <el-popover
              placement="top-start"
              title="请注意"
              width="200"
              trigger="hover"
              content="请注意，点击按钮后将发布全班成绩，请先确保已完成所有学生的评价。">
              <el-button type="success" @click="onReleaseScore" slot="reference">发布全班成绩</el-button>
            </el-popover>
          </el-col>
          <el-col :span="1">&nbsp</el-col>
          <el-col :span="6">
            <el-popover
              placement="top-start"
              title="温馨提示"
              width="200"
              trigger="hover"
              content="点击按钮后将取消已发布发的成绩，原来的评分记录仍然存在，但学生无法查看。">
              <el-button type="warning" @click="onUnReleaseScore" slot="reference">暂停成绩发布</el-button>
            </el-popover>
          </el-col>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'GiveScore',
  // 数据区
  data() {
    return {
      // 打分规则-各项占比情况-0-100的值
      markRule: {
        process: '',// 过程考核占比
        docs: '', // 文档及报告占比
        completion: '', // 项目完成情况占比
        presentation: '' // 答辩得分占比
      },
      // 某学生的各项的得分及评价反馈
      markResult: {
        sid: '',
        totalScore: '',
        processScore: '',
        docsScore: '',
        completionScore: '',
        presentationScore: '',
        feedback: '',
        isReleased: '0'
      },
      // 总分进度条的颜色定制
      customColors: [
        {color: '#f56c6c', percentage: 60},
        {color: '#e6a23c', percentage: 90},
        {color: '#5cb87a', percentage: 100}
      ],
      // 布尔值表明是否已完成规则设置
      hasSetRule: false,
      // 所有项目的pid和projectName
      projectOptions: [{
        pid: '',
        projectName: ''
      }],
      // 当前选中的项目的所有成员信息
      studentOptions: [{
        pid: '',
        sid: '',
        tuserInfo: {
          name: ''
        }
      }],

      // 当前打分对象信息，包括pid和sid
      markingObj: {
        pid: '',
        sid: ''
      }
    }
  },
  // 刷新或者打开页面时，像后端请求数据库中存储的打分规则
  mounted () {
    let that = this
    // 从数据库获取已有的打分规则
    this.$get('project/score/rules').then((r) => {
      // this.data = r.data.data
      that.markRule.process = r.data.data[0].ratio
      that.markRule.docs = r.data.data[1].ratio
      that.markRule.completion = r.data.data[2].ratio
      that.markRule.presentation = r.data.data[3].ratio
    })
    // 从数据库获得已有的项目信息，包括项目名称+项目id
    this.$get('project/all').then(r=>{
      // 初始化projectOptions
      that.projectOptions = r.data.data
    }).catch()
      // 从数据库获得所有成员的信息，包括sid，sname和pid
    this.$get('project/all_member_info').then((r)=>{
      // 初始化studentOptions
      that.studentOptions = r.data.data
    })
  },

  // 行为区
  methods: {
    // 提交打分规则
    setMarkRule () {
      // 检查各项权重总和是否等于100
      let total = this.markRule.process + this.markRule.docs +
        this.markRule.completion + this.markRule.presentation
      if(total===100){
        this.hasSetRule = true
        // 向后端发送打分规则，让后端存储
        let rule = this.markRule
        this.$post('project/score/rules',rule).then((r) => {
            this.$message.success('打分规则设置成功！')
          }).catch((err) => {
          this.$message.error('打分规则设置失败！')
        })
      }
      else{
        this.$message.error('请确保所有选项之和为100！')
      }
    },

    // 当每一个子项打分完成时调用，即拖动滑块时
    onGiveSubScore() {
      // 检查是否已经设置好打分规则，若是则更新当前总分
      let total = this.markRule.process + this.markRule.docs +
        this.markRule.completion + this.markRule.presentation
      if(total===100){
        this.markResult.totalScore =
          this.markResult.processScore*this.markRule.process +
          this.markResult.presentationScore*this.markRule.presentation +
          this.markResult.docsScore*this.markRule.docs +
          this.markResult.completionScore*this.markRule.completion;
        this.markResult.totalScore /= 100
      }
      else{
        this.$message.error('请先完成打分规则设置！')
      }
    },

    // 提交成绩
    onSubmitScore() {
      this.markResult.sid = this.markingObj.sid
      let result = {}
      result.completionScore = this.markResult.completionScore
      result.docsScore = this.markResult.docsScore
      result.processScore = this.markResult.processScore
      result.presentationScore = this.markResult.presentationScore
      result.totalScore = this.markResult.totalScore
      result.feedback = this.markResult.feedback
      result.isReleased = this.markResult.isReleased
      result.sid = this.markResult.sid
      result.tuserInfo = {}
      result.tuserInfo.sid = this.markResult.sid
      console.log(result)
      // 1. this.markResult.sid是不带tuserInfo的
      // 2. result是带tuserInfo的
      this.$post('project/score', result).then(r=>{
        this.$message.success('打分提交成功！')
      })
      console.log('成绩提交成功！')
    },

    // 发布全班成绩
    onReleaseScore() {
      this.$put('project/release_score').then(r=>{
        this.$message.success('成绩已发布！')
      })
    },

    // 取消发布全班成绩
    onUnReleaseScore() {
      this.$put('project/unrelease_score').then(r=>{
        this.$message.info('成绩已暂停发布！')
      })
    }
  }
}
</script>

<style scoped>
  /*Header*/
  #commentHeader,#setRuleHeader,#selectStuHeader,#markHeader {
    background-color: #ffffff;
    font-size: 20px;
    font-weight: bolder;
    text-align: center;
    padding-top: 7px;
    width: 100%;
  }
  /*Main*/
  #commentMain,#setRuleMain,#selectStuMain,#markMain {
    width: 100%;
  }

  /*滑块*/
  el-slider {
    width: 10px;
  }
</style>
