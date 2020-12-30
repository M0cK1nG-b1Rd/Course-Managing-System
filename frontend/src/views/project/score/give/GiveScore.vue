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
    <el-main id="selectStuMain">打分对象在此选择</el-main>

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
        feedback: ''
      },
      // 总分进度条的颜色定制
      customColors: [
        {color: '#f56c6c', percentage: 60},
        {color: '#e6a23c', percentage: 70},
        {color: '#1989fa', percentage: 80},
        {color: '#5cb87a', percentage: 100}
      ],
      // 布尔值表明是否已完成规则设置
      hasSetRule: false
    }
  },
  // 刷新或者打开页面时，像后端请求数据库中存储的打分规则
  // mounted () {
  //   this.$get('project/all').then((r) => {
  //     console.log(r.data.data)
  //     this.data = r.data.data
  //   })
  // },

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
      if(this.hasSetRule){
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
    }
  }
}
</script>

<style scoped>
  /*Header*/
  #commentHeader,#setRuleHeader,#selectStuHeader,#markHeader {
    background-color: #f8efef;
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
