<template xmlns:display="giveScore">
<!--<div>-->
<!--  &lt;!&ndash;页面头部信息&ndash;&gt;-->
<!--  <el-row>-->
<!--    <el-col :span="24"><div class="grid-content bg-purple-light header" >项目评分</div></el-col>-->
<!--  </el-row>-->
<!--&lt;!&ndash;  设置打分规则&ndash;&gt;-->

<!--&lt;!&ndash;  选择打分对象&ndash;&gt;-->

<!--&lt;!&ndash;  开始打分&ndash;&gt;-->

<!--&lt;!&ndash;  点评及反馈&ndash;&gt;-->

<!--&lt;!&ndash;  结果预览&ndash;&gt;-->

<!--</div>-->

  <el-container>
<!--    设置打分规则-->
    <el-header id="setRuleHeader" height="6.5%">设置打分规则</el-header>
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
    <el-header id="selectStuHeader" height="6.5%">选择打分对象</el-header>
    <el-main id="selectStuMain">打分对象在此选择</el-main>
<!--   打分区-->
    <el-header id="markHeader" height="6.5%">开始打分</el-header>
    <el-main id="markMain">在此进行打分</el-main>
<!--   点评区-->
    <el-header id="commentHeader" height="6.5%">点评及反馈</el-header>
    <el-main id="commentMain">在此进行反馈</el-main>

  </el-container>
</template>

<script>
export default {
  name: 'GiveScore',
  // 数据区
  data() {
    return {
      // 打分规则-各项占比情况-0-100的值
      markRule:{
        process: '',// 过程考核占比
        docs: '', // 文档及报告占比
        completion: '', // 项目完成情况占比
        presentation: '' // 答辩得分占比
      }
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
      let total = this.markRule.process + this.markRule.docs + this.markRule.completion + this.markRule.presentation
      if(total===100){
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
