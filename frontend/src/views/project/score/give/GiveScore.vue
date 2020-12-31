<template xmlns:display="giveScore">

  <el-container>
<!--    设置打分规则-->
    <el-header id="setRuleHeader" height="34px">设置打分规则</el-header>
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

<!--    选择打分对象-->
    <el-header id="selectStuHeader" height="34px">选择打分对象</el-header>
    <el-main id="selectStuMain">
      <a-cascader
        v-model="markResult.sid"
        :options="projectOptions"
        :load-data="loadData"
        placeholder="请选择需要打分的学生"
        change-on-select
      />
    </el-main>

<!--   打分区-->
    <el-header id="markHeader" height="34px">开始打分</el-header>
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
            <el-progress :percentage="markResult.totalScore" show-text="false"
                         :format="format" :color="customColors">
            </el-progress>
          </el-col>
        </el-form-item>
      </el-form>
    </el-main>

<!--   点评区-->
    <el-header id="commentHeader" height="34px">点评及反馈</el-header>
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
          <el-col :span="2">&nbsp</el-col>
          <el-col :span="10">
            <el-popover
              placement="top-start"
              title="温馨提示"
              width="200"
              trigger="hover"
              content="点击按钮后即可提交对当前同学的打分结果。">
              <el-button type="primary" size="medium " @="onSubmitScore" slot="reference">提交成绩及评价</el-button>
            </el-popover>
          </el-col>
          <el-col :span="10">
            <el-popover
              placement="top-start"
              title="请注意"
              width="200"
              trigger="hover"
              content="请注意，点击按钮后将发布全班成绩，请先确保已完成所有学生的评价。">
              <el-button type="primary" size="success " @="onReportScore" slot="reference">发布全班成绩</el-button>
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
      // 选择打分对象的选项-即列出所有项目
      projectOptions: [],
      //
      memberInfo: []
    }
  },
  // 刷新或者打开页面时，像后端请求数据库中存储的打分规则
  mounted () {
    let that = this
    // 从数据库获取已有的打分规则
    this.$get('project/score/rules').then((r) => {
      console.log(r)
      // this.data = r.data.data
      that.markRule.process = r.data.data[0].ratio
      that.markRule.docs = r.data.data[1].ratio
      that.markRule.completion = r.data.data[2].ratio
      that.markRule.presentation = r.data.data[3].ratio
    })
    // 从数据库获得已有的项目信息，包括项目名称+项目id
    this.$get('project/all').then(r=>{
        console.log(r)
      // 初始化projectOptions
      for(let i = 0; i<r.data.data.length; i++){
        let obj = {}
        obj.value = r.data.data[i].pid
        obj.label = r.data.data[i].projectName
        obj.isLeaf = false
        that.projectOptions[i] = obj
      }
      console.log('projectOptions')
      console.log(this.projectOptions)
    }).catch()
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

    // 返回总分进度条的format-即显示在右侧的分数
    format() {
      return this.markResult.totalScore + '分';
    },

    // 级联选择时动态加载学生信息供选择
    loadData(selectedOptions) {
      console.log(selectedOptions)
      const targetOption = selectedOptions[selectedOptions.length - 1];
      targetOption.loading = true;
      let that = this
      // load options lazily
      setTimeout(() => {
        targetOption.loading = false;
        // 通过PID向后台请求成员信息，返回结果必须包含该项目所有成员的学号+姓名
        this.$get(`project/all_member_info?pid=${targetOption.value}`).then(r=>{
          console.log(r)
          let thisMemberInfo = r.data.data
          // 给被选中的一级选项添加其二级选项
          let children = []
          for(let i = 0; i<thisMemberInfo.length; i++){
            let obj = {}
            obj.value = thisMemberInfo[i].sid
            obj.label = thisMemberInfo[i].name
            obj.leaf = true
            children[i] = obj
          }
          targetOption.children = children
        }).catch()

        this.projectOptions = [...this.projectOptions];
      }, 1);
    },

    // 提交成绩
    onSubmitScore() {
      this.$post('project/score', this.markResult).then(r=>{
        this.$message.success('打分提交成功！')
      })
      console.log('成绩提交成功！')
    },

    // 发布全班成绩
    onReportScore() {

    }
  }
}
</script>

<style scoped>
  /*Header*/
  #commentHeader,#setRuleHeader,#selectStuHeader,#markHeader {
    background-color: #bed9f1;
    font-size: 15px;
    font-weight: bolder;
    text-align: center;
    padding-top: 7px;
    width: 80%;
  }
  /*Main*/
  #commentMain,#setRuleMain,#selectStuMain,#markMain {
    width: 80%;
  }

  /*滑块*/
  el-slider {
    width: 10px;
  }
</style>
